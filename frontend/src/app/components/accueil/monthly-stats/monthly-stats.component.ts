import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Chart, registerables} from "chart.js";

// Register Chart.js components
Chart.register(...registerables);

@Component({
	selector: 'app-monthly-stats',
	standalone: true,
	imports: [],
	templateUrl: './monthly-stats.component.html',
	styleUrl: './monthly-stats.component.css'
})
export class MonthlyStatsComponent implements OnInit , AfterViewInit {
	@ViewChild('chartCanvas') chartCanvas!: ElementRef<HTMLCanvasElement>;
	@ViewChild('pieChartCanvas') pieChartCanvas!: ElementRef<HTMLCanvasElement>;

	ngOnInit(): void {

	}
	ngAfterViewInit():void{
		this.createLineChart();
		this.createPieChart();
	}

	createLineChart(): void {
		const ctx = this.chartCanvas.nativeElement.getContext('2d');
		new Chart(ctx!, {
			type: 'line',
			data: {
				labels: ['Jan', 'Fév', 'Mar', 'Avr', 'Mai', 'Jun'],
				datasets: [{
					label: 'Évolution Mensuelle',
					data: [10, 20, 15, 30, 40, 35],
					borderColor: '#007bff',
					backgroundColor: 'rgba(0,123,255,0.2)',
					fill: true,
					tension: 0.3,
					pointBackgroundColor: '#007bff',
					pointBorderColor: '#007bff',
					pointRadius: 6,
					pointHoverRadius: 8
				}]
			},
			options: {
				responsive: true,
				maintainAspectRatio: false,
				plugins: {
					legend: {
						display: false
					}
				},
				scales: {
					y: {
						beginAtZero: true,
						grid: {
							color: 'rgba(0,0,0,0.1)'
						}
					},
					x: {
						grid: {
							display: false
						}
					}
				}
			}
		});
	}

	createPieChart(): void {
		const ctx = this.pieChartCanvas.nativeElement.getContext('2d');
		new Chart(ctx!, {
			type: 'pie',
			data: {
				labels: ['Type A', 'Type B', 'Type C', 'Type D', 'Type E', 'Type F', 'Type G', 'Type H'],
				datasets: [{
					label: 'Répartition par Type',
					data: [25, 20, 15, 12, 10, 8, 5, 5],
					backgroundColor: [
						'#007bff',  // Blue - 25%
						'#ffc107',  // Yellow - 20%
						'#6c757d',  // Gray - 15%
						'#198754',  // Green - 12%
						'#f5c542',  // Light Yellow - 10%
						'#dc3545',  // Red - 8%
						'#17a2b8',  // Teal - 5%
						'#343a40'   // Dark Gray - 5%
					],
					borderWidth: 2,
					borderColor: '#fff'
				}]
			},
			options: {
				responsive: true,
				maintainAspectRatio: false,
				plugins: {
					legend: {
						position: 'bottom',
						labels: {
							padding: 20,
							usePointStyle: true
						}
					},
					tooltip: {
						callbacks: {
							label: function(context) {
								const label = context.label || '';
								const value = context.parsed;
								const total = context.dataset.data.reduce((a: number, b: number) => a + b, 0);
								const percentage = Math.round((value / total) * 100);
								return `${label}: ${percentage}%`;
							}
						}
					}
				}
			}
		});
	}
}
