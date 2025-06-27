import { CommonModule } from "@angular/common";
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MenuItem, Message, PrimeNGConfig } from "primeng/api";
import { InputTextModule } from "primeng/inputtext";
import { MenubarModule } from "primeng/menubar";
import { MessagesModule } from "primeng/messages";
import { ToastModule } from 'primeng/toast';
import { ApplicationErreur } from "./models/application-erreur.model";
import { Utilisateur } from "./models/utilisateur.model";
import { ApplicationMessageService } from "./services/message-service.service";
import { NavigationService } from "./services/navigation.service";
import { ButtonModule } from "primeng/button";
import { FooterComponent } from "./components/footer/footer.component";
import {CardDemandeComponent} from "./components/etat-civil/card-demande/card-demande.component";
import {HeroSectionComponent} from "./components/accueil/hero-section/hero-section.component";
import {AuthService} from "./services/auth.service";
import {SidebarModule} from "primeng/sidebar";


@Component({
	selector: 'app-root',
	standalone: true,
	imports: [
		RouterOutlet,
		CommonModule,
		MenubarModule,
		InputTextModule,
		MessagesModule,
		ToastModule,
		ButtonModule,
		FooterComponent,
		CardDemandeComponent,
		HeroSectionComponent,
		FooterComponent,
		HeroSectionComponent,
		SidebarModule
	],
	templateUrl: './app.component.html',
	styleUrl: './app.component.scss'
})
export class AppComponent {
	isToggle: boolean;
	isMobile: boolean = false;
	sidebarVisible: boolean = true;
	showModal: boolean = false;
	isVisible: boolean = false;
	title = 'Collect Fond'
	applicationErreur: ApplicationErreur;
	items: MenuItem[]
	messages: Message[];
	utilisateurConnecte: Utilisateur;

	constructor(
				private messageService: ApplicationMessageService,
				private navigationService: NavigationService,
				private primeNgConfig: PrimeNGConfig,
				private authService: AuthService, ) {
	}

	ngOnInit(): void {

		this.messageService.messageErreur.subscribe(
			(applicationErreur) => {
				this.applicationErreur = applicationErreur;
				if (this.applicationErreur) {
					this.messages = [{
						severity: this.applicationErreur.type.toLowerCase(),
						detail: this.applicationErreur.messageAvecCode
					}];
				}
			}
		);
			if(this.authService.isAuthenticated()){
				this.utilisateurConnecte = this.authService.getUtilisateurConnecte()
			}

		this.items = [
			{
				label: 'Accueil',
				routerLink: 'accueil'
			},
			{
				label: 'Etat Civil',
				routerLink: 'etat-civil'
			},
			{
				label: 'Urbanisme et Fonciers',
				routerLink: 'urbanisme-fonciers'
			},
			{
				label: 'Services Sociaux',
				routerLink: 'services-sociaux'
			},
			{
				label: 'Vos demandes',
				routerLink: 'demandes/vos-demandes'
			},

		];


		this.primeNgConfig.setTranslation({
			dayNames: ['Dimanche',
				'Lundi',
				'Mardi',
				'Mercredi',
				'Jeudi',
				'Vendredi',
				'Samedi'],
			dayNamesShort: ['Dim.',
				'Lun.',
				'Mar.',
				'Mer.',
				'Jeu.',
				'Ven.',
				'Sam.'],
			dayNamesMin: ['Di',
				'Lu',
				'Ma',
				'Me',
				'Je',
				'Ve',
				'Sa'],
			monthNames: ['Janvier',
				'Fevrier',
				'Mars',
				'Avril',
				'Mai',
				'Juin',
				'Juillet',
				'Août',
				'Septembre',
				'Octobre',
				'Novembre',
				'Decembre'],
			monthNamesShort: ['Janv.',
				'Fevr.',
				'Mars',
				'Avri.',
				'Mai',
				'Juin',
				'Juil.',
				'Août',
				'Sept.',
				'Octo.',
				'Novem.',
				'Decem.']
		});
	}

	/**
	 * Retourne true si la page de connexion est affichée.
	 */
	isLogin(): boolean {
		return this.navigationService.isLogin();
	}

	/**
	 * Déconnecte l'utilisateur connecté et redirige vers la page d'authentification.
	 */
	deconnecter(): void {
		localStorage.removeItem('access_token');
		this.navigationService.goTologin();
	}
	connecter(): void {
		this.navigationService.goTologin();
	}

	addToggle() {
		this.isToggle = !this.isToggle;
	}


}
