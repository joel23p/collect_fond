import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-stat-card',
  standalone: true,
  imports: [],
  templateUrl: './stat-card.component.html',
  styleUrl: './stat-card.component.css'
})
export class StatCardComponent {

	@Input()
	titre!: string;

	@Input()
	valeur!: number | string | undefined;

	@Input()
	icone!: string;

	@Input()
	boxShadow!: string;

	@Input()
	backgroundColor!: string;

}
