import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Message } from 'primeng/api';
import { ButtonModule } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';
import { InputTextModule } from 'primeng/inputtext';
import { MessagesModule } from 'primeng/messages';
import { ToastModule } from 'primeng/toast';
import { ApplicationErreur } from '../../models/application-erreur.model';
import { Pharmacie } from "../../models/pharmacie.model";
import { PharmacieService } from '../../services/pharmacie.service';

@Component({
	selector: 'popup-pharmacie',
	standalone: true,
	imports: [CommonModule, DialogModule, ButtonModule, ReactiveFormsModule, ToastModule, InputTextModule, MessagesModule],
	templateUrl: './popup-pharmacie.component.html',
	styleUrls: ['./popup-pharmacie.component.scss']
})
export class PopupPharmacieComponent {
	@Input() visible: boolean;
	@Output() enregistrerPharmacie = new EventEmitter();
	@Output() visibleChange: EventEmitter<boolean> = new EventEmitter<boolean>();

	applicationErreur: ApplicationErreur;
	loading = false;
	messages: Message[];
	pharmacies: Pharmacie[];

	formulairePharmacie = new FormGroup({
		id: new FormControl(null),
		numero: new FormControl('', [Validators.required]),
		nom: new FormControl('', [Validators.required]),
		ville: new FormControl('', [Validators.required]),
		quartier: new FormControl('', [Validators.required]),
		heureOuverture: new FormControl('', [Validators.required]),
		heureFermeture: new FormControl('', [Validators.required]),
		nomGerant: new FormControl('', [Validators.required]),
		contact: new FormControl('', [Validators.required]),
		latitude: new FormControl(null),
		longitude: new FormControl(null),
		statut: new FormControl('ACTIVE', [Validators.required]),
	});

	constructor(private pharmacieService: PharmacieService) {
	}

	ngOnInit(): void {
	}

	/**
	 * Ferme la popup.
	 */
	fermer() {
		this.visibleChange.emit(false);
	}

	/**
	 * Enregistre une pharmacie
	 */
	enregistrer() {
		this.loading = true;
		this.pharmacieService.creer(this.formulairePharmacie.value as Pharmacie).subscribe({
			next: (response) => {
				this.loading = false;
				this.visibleChange.emit(false);
				this.enregistrerPharmacie.emit();
				this.formulairePharmacie.reset();
			},
			error: (error) => {
				this.loading = false;
				this.applicationErreur = error.error;
				this.messages = [{
					severity: this.applicationErreur.type.toLowerCase(),
					detail: this.applicationErreur.messageAvecCode
				}];
			},
		});
	}
}
