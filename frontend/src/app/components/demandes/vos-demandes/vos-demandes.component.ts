import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {TableModule} from "primeng/table";
import { CommonModule } from '@angular/common';
import {VoirPlusInfosComponent} from "../voir-plus-infos/voir-plus-infos.component";
import {Demande} from "../../../models/demande";
import {Button} from "primeng/button";
import {CelebrationMariageService} from "../../../services/celebration-mariage.service";
import {CelebrationMariage} from "../../../models/celebration-mariage";

@Component({
  selector: 'app-vos-demandes',
  standalone: true,
	imports: [
		TableModule,
		CommonModule,
		VoirPlusInfosComponent,
		Button
	],
  templateUrl: './vos-demandes.component.html',
  styleUrl: './vos-demandes.component.css'
})
export class VosDemandesComponent implements OnInit{
	@Input() celebrationMariage: CelebrationMariage;
	visibleInfos: boolean = false;
	selectedDemande: Demande;
	@ViewChild('dt1') dt1: any;
	libelleStatut : any={
		EN_COURS: "En cours",
		NON_DEMARRE: "Non demarré",
		TERMINE: "Terminé",
		REJETE: "Rejeté",
		VALIDE: "Validé",
	};



	demandes!: any[];
	celebrationsMariage: CelebrationMariage[] = [];

	constructor( private celebrationMariageService:  CelebrationMariageService,) {
	}
	ngOnInit() {
		this.listerDemande()
	}

	onHideModalPourPlusInfos(updatedVisible: boolean): void {
		this.visibleInfos = updatedVisible;
	}

	ouvrirPopupPourPlusInfos(celebrationMariage: any): void {
		this.selectedDemande = celebrationMariage as Demande;
		this.visibleInfos = true;
	}

	listerDemande(){
		this.celebrationMariageService.lister().subscribe({
			next: (data) => {
				this.celebrationsMariage = data;
			}
		})
	}
}
