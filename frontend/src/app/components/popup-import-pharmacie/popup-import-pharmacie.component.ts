import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import {
	FileUploadErrorEvent,
	FileUploadEvent,
	FileUploadModule,
} from 'primeng/fileupload';
import { DialogModule } from 'primeng/dialog';
import { PharmacieService } from '../../services/pharmacie.service';
import { ApplicationMessageService } from '../../services/message-service.service';
import { CommonModule } from '@angular/common';
import { Message, MessageService as ToastService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { HttpEvent, HttpResponse } from '@angular/common/http';
import { ProgressSpinnerModule } from 'primeng/progressspinner';
import { Pharmacie } from '../../models/pharmacie.model';
import { TableModule } from 'primeng/table';
import { FieldsetModule } from 'primeng/fieldset';
import { StatutImportPharmacie } from '../../models/statut-import-pharmacie';

@Component({
	selector: 'popup-import-pharmacie',
	standalone: true,
	imports: [
		CommonModule,
		FileUploadModule,
		DialogModule,
		ToastModule,
		ProgressSpinnerModule,
		TableModule,
		FieldsetModule,
	],
	templateUrl: './popup-import-pharmacie.component.html',
	styleUrl: './popup-import-pharmacie.component.scss',
	providers: [ApplicationMessageService, ToastService],
})
export class PopupImportPharmacieComponent implements OnInit {
	@Output() statusImport = new EventEmitter<boolean>();

	affichePopup: boolean = false;
	urlImport: string;
	fichierUploaded: any;
	fichiers: any[] = [];
	lignesNonEnregistrees: Pharmacie[] = [];
	entetesLignesNonEnregistrees: string[] = [];
	loading: any;
	isImportReussi = false;

	messageImport: Message[] ;

	statutImportPharmacie: StatutImportPharmacie;

	constructor(private applicationMessageService: ApplicationMessageService) {}

	ngOnInit(): void {
		this.urlImport = PharmacieService.importPharmacieUrl;
	}

	/**
	 * Notifie le composant parent que l'upload des fichiers est terminé
	 *
	 * @param $event evenement déclenché après l'upload des fichiers
	 */
	onUpload($event: FileUploadEvent): void {
		const event: HttpEvent<any> = $event.originalEvent;
		this.loading = false;
		this.isImportReussi = true;
		if (event instanceof HttpResponse) {
			this.statutImportPharmacie = event.body as StatutImportPharmacie;
			if(this.statutImportPharmacie.pharmaciesNonImportees.length) {
				// En cas de pharmacies non enregistrées on les affiche
				this.lignesNonEnregistrees = this.statutImportPharmacie.pharmaciesNonImportees.filter((el: any) => el != null);
				this.entetesLignesNonEnregistrees = Object.keys(this.lignesNonEnregistrees[0]).slice(0, -2); // retire les valeurs Latitude et Longitude
			}
			const nombrePharmaciesEnregistrees = this.statutImportPharmacie?.nbreLigneAImporter - this.statutImportPharmacie?.pharmaciesNonImportees.length;
			this.messageImport = [{
				severity: 'info',
				detail: `Traitement terminé: ${ nombrePharmaciesEnregistrees } / ${ this.statutImportPharmacie?.nbreLigneAImporter } pharmacie(s) enregistrée(s)`
			}];
			this.statusImport.emit(false);
		}
	}

	/**
	 * Affiche un message d'erreur lorsque l'upload des fichiers échoue
	 *
	 * @param $event evenement déclenché après l'upload des fichiers
	 */
	onUploadError($event: FileUploadErrorEvent): void {
		this.loading = false;
		this.applicationMessageService.updateMessageErreur($event.error.error);
	}

	/**
	 * ouvre la poppup.
	 */
	ouvrePopup(): void {
		this.affichePopup = true;
	}

	/**
	 * Ferme la popup.
	 */
	cacherPopup(): void {
		this.statusImport.emit(this.isImportReussi);
		this.affichePopup = false;
		this.isImportReussi = false;
		this.entetesLignesNonEnregistrees = null;
		this.lignesNonEnregistrees = null;
		this.statutImportPharmacie = null;
	}
}
