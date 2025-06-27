import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CalendarModule } from 'primeng/calendar';
import { FormsModule } from '@angular/forms';
import { CelebrationMariageService } from '../../../services/celebration-mariage.service';
import { Marie } from '../../../models/marie';
import { Demande } from '../../../models/demande';
import { ApplicationMessageService } from '../../../services/message-service.service';
import { ConfirmationService, Message, MessageService } from 'primeng/api';
import { ApplicationErreur } from '../../../models/application-erreur.model';
import {NavigationService} from "../../../services/navigation.service";
import {CelebrationMariage} from "../../../models/celebration-mariage";
import {valueReferenceToExpression} from "@angular/compiler-cli/src/ngtsc/annotations/common";
import {error} from "@angular/compiler-cli/src/transformers/util";


@Component({
  selector: 'app-celebration-mariage',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, CalendarModule, FormsModule],
  templateUrl: './celebration-mariage.component.html',
  styleUrls: ['./celebration-mariage.component.scss']
})
export class CelebrationMariageComponent {

  currentStep: number = 1;
  rendezVousForm: FormGroup;
  currentYear: number = new Date().getFullYear();
  date: Date | undefined;
  minDate: Date | undefined;
  maxDate: Date | undefined;
	celebrationMariages: CelebrationMariage[] = [];
	celebrationMariage: CelebrationMariage = new CelebrationMariage();
  formulaireDemande: FormGroup;
  loading: boolean;
  epoux: Marie;
  epouse: Marie;
  demande: Demande;
  applicationErreur: ApplicationErreur;
  messages: Message[];
  estSoumis: boolean = false;
  numeroDemande: string = "20250418-CM-001";
	messageErreur: string | null = null; // À déclarer dans ton component


  constructor(private formbuilder: FormBuilder, private demandeMariageService:  CelebrationMariageService, private readonly applicationMessageService: ApplicationMessageService,
    private readonly messageService: MessageService, private readonly navigationService: NavigationService) {
    this.formulaireDemande = this.formbuilder.group({
      id: [null],
      nomEpoux: ['', Validators.required],
      prenomsEpoux: ['', Validators.required],
      telephoneEpoux: ['', Validators.required],
      professionEpoux: ['', Validators.required],
      dateNaissEpoux: ['', Validators.required],
      lieuNaissEpoux: ['', Validators.required],
		nomPereEpoux: ['', Validators.required],
		prenomsPereEpoux: ['', Validators.required],
		nomMereEpoux: ['', Validators.required],
		prenomsMereEpoux: ['', Validators.required],
      adresseEpoux: ['', Validators.required],
		adressePereEpoux: ['', Validators.required],
		adresseMereEpoux: ['', Validators.required],
		nomTemoinEpoux: ['', Validators.required],
		prenomsTemoinEpoux: ['', Validators.required],
		adresseTemoinEpoux: ['', Validators.required],
		professionTemoinEpoux: ['', Validators.required],
      autorisationEpoux: ['', Validators.required],

      nomEpouse: ['', Validators.required],
      prenomsEpouse: ['', Validators.required],
      telephoneEpouse: ['', Validators.required],
      professionEpouse: ['', Validators.required],
      dateNaissEpouse: ['', Validators.required],
      lieuNaissEpouse: ['', Validators.required],
		nomPereEpouse: ['', Validators.required],
		prenomsPereEpouse: ['', Validators.required],
		nomMereEpouse: ['', Validators.required],
		prenomsMereEpouse: ['', Validators.required],
      adresseEpouse: ['', Validators.required],
		adressePereEpouse: ['', Validators.required],
		adresseMereEpouse: ['', Validators.required],
		nomTemoinEpouse: ['', Validators.required],
		prenomsTemoinEpouse: ['', Validators.required],
		adresseTemoinEpouse: ['', Validators.required],
		professionTemoinEpouse: ['', Validators.required],
      autorisationEpouse: ['', Validators.required],

		dateRendezVous: ['', Validators.required]

    });
  }

  ngOnInit() {
    let today = new Date();
    let year = today.getFullYear();
    this.minDate = new Date(year, 0, 1);
    this.maxDate = new Date(year, 11, 31);
  }

  get dateControl() {
    return this.rendezVousForm.get('date');
  }

  // Gestion des étapes
  setStep(step: number): void {
    this.currentStep = step;
    console.log(this.formulaireDemande.value.epouse);

  }

  nextStep(): void {
    if (this.currentStep < 4) {
      this.currentStep++;
    }
  }

  previousStep(): void {
    if (this.currentStep > 1) {
      this.currentStep--;
    }
  }


  onSubmit(): void {
    /*const form = this.formulaireDemande.value;
    this.epoux = {
      id: null,
      nom: form.nomEpoux,
      prenoms: form.prenomsEpoux,
      dateNaisss: form.dateNaissEpoux,
      telephone: form.telephoneEpoux,
      profession: form.professionEpoux,
      pere: form.pereEpoux,
      mere: form.mereEpoux,
      domicile: form.adresseEpoux,
      autoriserPar: form.autorisationEpoux,
      type: 'EPOUX',
      lieuNaiss: form.lieuNaissEpoux
    };

    this.epouse = {
      id: null,
      nom: form.nomEpoux,
      prenoms: form.prenomsEpoux,
      dateNaisss: form.dateNaissEpoux,
      telephone: form.telephoneEpoux,
      profession: form.professionEpoux,
      pere: form.pereEpoux,
      mere: form.mereEpoux,
      domicile: form.adresseEpoux,
      autoriserPar: form.autorisationEpouse,
      type: 'EPOUX',
      lieuNaiss: form.lieuNaissEpouse
    };

    this.demande = {
      id: form.id,
      epoux: this.epoux,
      epouse: this.epouse,
      dateSouhaite: form.dateSouhaite,
      dateDemande: new Date,
      isConfirme: false
    }

    this.loading = true;
    this.demandeMariageService.enregistrer(this.demande).subscribe({
      next: (response) => {
        this.loading = false;
        this.formulaireDemande.reset();
      },
      error: (error) => {
        this.loading = false;
        this.applicationErreur = error.error;
        this.messages = [{
          severity: this.applicationErreur.type.toLowerCase(),
          detail: this.applicationErreur.messageAvecCode
        }];
      },
    });*/
	// this.navigationService.goTo("/accueil", {messageSuccess: "Votre demande a été bien enregistrée. N° 433212"})
	  this.estSoumis = true;

  }

   /**
	 * Affiche le message de succès lors d'une action.
	 */
	afficherMessageSucces(message: string, summary: string = 'Succès', severity: string = 'success'): void {
		this.applicationMessageService.clear();
		this.messageService.add({
			severity: severity,
			summary: summary,
			detail: message
		});
	}
	/***
	 Gestion de l'upload du fichier
	 */
	onUpload(e: Event) {

	}

	// enregistrerDemandeMariage(){
	// 	const celebrationMariage = Object.assign(new CelebrationMariage(), this.formulaireDemande.value);
	// 	this.demandeMariageService.enregistrer(celebrationMariage).subscribe(() => {
	// 	}).;
	// }


	enregistrerDemandeMariage() {
		const celebrationMariage = Object.assign(new CelebrationMariage(), this.formulaireDemande.value);
		this.demandeMariageService.enregistrer(celebrationMariage).subscribe({
			next: () => {
				// Tu peux aussi réinitialiser le message d'erreur ici si besoin
				this.messageErreur = null;
			},
			error: (err) => {
				console.error('Erreur lors de l\'enregistrement :', err);
				this.messageErreur = 'Une erreur est survenue lors de l’enregistrement. Veuillez réessayer.';
			}
		});
	}



}
