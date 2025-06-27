import { Component } from '@angular/core';
import {MenuItem, PrimeNGConfig} from "primeng/api";
import { TabMenuModule } from 'primeng/tabmenu';
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-referentiel',
  standalone: true,
  imports: [TabMenuModule,RouterOutlet],
  templateUrl: './referentiel.component.html',
  styleUrl: './referentiel.component.scss'
})
export class ReferentielComponent {
	items: MenuItem[];
	activeItem: MenuItem;

	constructor() {
    	}
	ngOnInit() {
		this.items = [
			{
				label: 'Pharmacies',
				routerLink: '/referentiel/pharmacies'
			}
		]
	}
}
