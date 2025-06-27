import { Routes } from '@angular/router';
import { AdministrationComponent } from "./components/administration/administration.component";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { LoginComponent } from "./components/login/login.component";
import { AccueilComponent } from './components/accueil/accueil.component';
import { CelebrationMariageComponent } from './components/demandes/celebration-mariage/celebration-mariage.component';
import {EtatCivilComponent} from "./components/etat-civil/etat-civil.component";
import {VosDemandesComponent} from "./components/demandes/vos-demandes/vos-demandes.component";
import {GestionMembresComponent} from "./components/gestion-membres/gestion-membres.component";
import {GestionPaiementsComponent} from "./components/gestion-paiements/gestion-paiements.component";



export const routes: Routes = [
	{
		path: '',
		redirectTo: '/accueil',
		pathMatch: 'full'
	},
	{
		path: 'accueil',
		component: AccueilComponent
	},
	{
		path: 'etat-civil',
		component: EtatCivilComponent
	},
	{
		path: 'connexion',
		component: LoginComponent
	},
	{
		path: 'tableau-de-bord',
		component: DashboardComponent
	},
	{
		path: 'administration',
		component: AdministrationComponent
	},
	{
		path: 'demandes/celebration-mariage',
		component: CelebrationMariageComponent
	  },
	{
		path: 'demandes/vos-demandes',
		component: VosDemandesComponent
	},
	{
		path: 'gestion-membres',
		component: GestionMembresComponent
	},
	{
		path: 'gestion-paiements',
		component: GestionPaiementsComponent
	}

];
