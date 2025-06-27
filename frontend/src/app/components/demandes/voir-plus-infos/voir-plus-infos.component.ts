import { CommonModule, DatePipe } from '@angular/common';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { MenuItem } from 'primeng/api';
import { ButtonModule } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';
import { InputTextModule } from 'primeng/inputtext';
import { MessagesModule } from 'primeng/messages';
import { ToastModule } from 'primeng/toast';
import { StepsModule } from 'primeng/steps';
import {MultiSelectModule} from 'primeng/multiselect';
import { DropdownModule } from 'primeng/dropdown';
import { AccordionModule } from 'primeng/accordion';

import { CalendarModule } from 'primeng/calendar';
import { InputSwitchModule } from 'primeng/inputswitch';
import { InputNumberModule } from 'primeng/inputnumber';
import { FormsModule } from '@angular/forms';
import { finalize } from 'rxjs';
import {Demande} from "../../../models/demande";
import {TimelineModule} from "primeng/timeline";

@Component({
  selector: 'voir-plus-infos',
  standalone: true,
	imports: [CommonModule, AccordionModule, FormsModule, CalendarModule, InputNumberModule, InputSwitchModule, MultiSelectModule, DropdownModule, StepsModule, DialogModule, ButtonModule, ReactiveFormsModule, ToastModule, InputTextModule, MessagesModule, TimelineModule],
  templateUrl: './voir-plus-infos.component.html',
  styleUrl: './voir-plus-infos.component.scss',
  providers: [DatePipe]
})
export class VoirPlusInfosComponent implements OnInit {
	@Input() demande: Demande;
  	@Input() visible: boolean;
	@Output() visibleChangeInfos: EventEmitter<boolean> = new EventEmitter<boolean>();
    activeIndex: number | undefined = 0;

 	 specialiteDisponibleNames : any;
	typeServiceNames: any;
	libelleStatut : any={
		EN_COURS: "En cours",
		NON_DEMARRE: "Non demarré",
		TERMINE: "Terminé",
		REJETE: "Rejeté",
		VALIDE: "Validé",
	};
  constructor( private datePipe: DatePipe,
		private fb: FormBuilder,) {

	}

	items: MenuItem[];

		ngOnInit(): void {
		}

		activeIndexChange(index : any){
			this.activeIndex = index
		}

		    /**
     * Ferme la popup.
     */
			fermer() {
				this.visibleChangeInfos.emit(false);
				this.activeIndex = 0;
				this.visible = false;
			}



  getDateFormat(date:any) : any
  {
	const datePattern = /^\d{2}\/\d{2}\/\d{4}$/;

	if (datePattern.test(date)) {
		return date;  // Si le format est déjà correct, retourner le temps original
	  }

    return this.datePipe.transform(date, 'dd/MM/yyyy');
  }

  getTimeFormat(time: any): any {
	// Vérifier si le temps est déjà au format 'HH:mm'
	const timePattern = /^\d{2}:\d{2}$/; // Expression régulière pour vérifier 'HH:mm'

	if (timePattern.test(time)) {
	  return time;  // Si le format est déjà correct, retourner le temps original
	}

	// Sinon, transformer le temps au format 'HH:mm' avec datePipe
	return this.datePipe.transform(time, 'HH:mm');
  }



}
