import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import {NavigationService} from "../../../services/navigation.service";
import {ApplicationMessageService} from "../../../services/message-service.service";
import {PrimeNGConfig} from "primeng/api";
import {AuthService} from "../../../services/auth.service";

@Component({
  selector: 'app-card-demande',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './card-demande.component.html',
  styleUrl: './card-demande.component.scss'
})
export class CardDemandeComponent {

	constructor(
		private navigationService: NavigationService,
		 ) {
	}

  services = [
    {
      image: '/assets/img/extrait-naissance.jpg',
		lien: '/demandes/celebration-mariage',
		title: 'Acte de naissance',
		description: `Un acte de naissance, signé par un officier d\'état civil, atteste une naissance et est requis pour certaines démarches administratives.`
    },
    {
      image: '/assets/img/mariage.jpg',
		lien: '/demandes/celebration-mariage',
      title: 'Célébration de mariage',
      description: `Le mariage est l’union librement consentie de deux personnes.
		Il donne à un couple un statut légal et un régime matrimonial et crée entre les époux des droits et des obligations.`
    },
    {
      image: '/assets/img/decès.jpg',
		lien: '/demandes/celebration-mariage',
		title: ' Acte de décès',
		description: `Un acte de décès est un acte juridique de l\'état civil. C\'est un acte authentique signé par
                            un officier de l\'état civil établi lors du décès d\'une personne.`
    },
	  {
		  image: '/assets/img/acte-mariage.jpg',
		  lien: '/demandes/celebration-mariage',
		  title: 'Acte de mariage',
		  description: `Un acte de mariage est un acte juridique de l\'état civil, c\'est un acte authentique signé
                    par un officier de l'état civil établi pour attester de la situation marital des époux.`
	  }
  ];
	goTo(lien:any) : void
	{
		this.navigationService.goTo(lien);
	}
}
