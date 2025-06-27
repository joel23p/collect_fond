import { Component } from '@angular/core';
import {CalendarModule} from "primeng/calendar";
import {NgIf} from "@angular/common";
import {PaginatorModule} from "primeng/paginator";
import {ReactiveFormsModule} from "@angular/forms";
import {CardDemandeComponent} from "./card-demande/card-demande.component";
import {InstructionComponent} from "../accueil/instruction/instruction.component";

@Component({
  selector: 'app-etat-civil',
  standalone: true,
	imports: [
		CalendarModule,
		NgIf,
		PaginatorModule,
		ReactiveFormsModule,
		CardDemandeComponent,
		InstructionComponent
	],
  templateUrl: './etat-civil.component.html',
  styleUrl: './etat-civil.component.scss'
})
export class EtatCivilComponent {

}
