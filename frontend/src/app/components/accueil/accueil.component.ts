import { Component } from '@angular/core';
import {ContributionsCardsComponent} from "./contributions-cards/contributions-cards.component";
import {AlertsComponent} from "./alerts/alerts.component";
import {MonthlyStatsComponent} from "./monthly-stats/monthly-stats.component";


@Component({
  selector: 'app-accueil',
  standalone: true,
	imports: [
		ContributionsCardsComponent,
		AlertsComponent,
		MonthlyStatsComponent
	],
  templateUrl: './accueil.component.html',
  styleUrl: './accueil.component.scss'
})
export class AccueilComponent {

}
