import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { ButtonModule } from 'primeng/button';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';
import { of } from 'rxjs';
import { PopupPharmacieComponent } from '../../components/popup-pharmacie/popup-pharmacie.component';
import { PharmacieService } from '../../services/pharmacie.service';

describe('ModalComponent', () => {
	let component: PopupPharmacieComponent;
	let fixture: ComponentFixture<PopupPharmacieComponent>;
	let pharmaciesServiceSpy: jasmine.SpyObj<PharmacieService>;
	let messageServiceSpy: jasmine.SpyObj<MessageService>;

	beforeEach(async () => {
		const pharmaciesServiceSpyObj = jasmine.createSpyObj('PharmaciesService', ['creer', 'lister']);
		const messageServiceSpyObj = jasmine.createSpyObj('MessageService', ['add']);

		await TestBed.configureTestingModule({
			declarations: [PopupPharmacieComponent],
			imports: [ReactiveFormsModule, DialogModule, ButtonModule, ToastModule],
			providers: [
				{ provide: PharmacieService, useValue: pharmaciesServiceSpyObj },
				{ provide: MessageService, useValue: messageServiceSpyObj }
			]
		}).compileComponents();

		pharmaciesServiceSpy = TestBed.inject(PharmacieService) as jasmine.SpyObj<PharmacieService>;
		messageServiceSpy = TestBed.inject(MessageService) as jasmine.SpyObj<MessageService>;
	});

	beforeEach(() => {
		fixture = TestBed.createComponent(PopupPharmacieComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});

	it('should call creer() method on PharmaciesService with correct data and display success message', () => {
		const mockPharmacie = {
			contact: '0707070707',
			heureFermeture: '10:57',
			heureOuverture: '10:57',
			nom: 'Belle monde',
			nomGerant: 'Alphonse',
			numero: 'AF0789563845',
			quartier: 'Angre',
			ville: 'abidjan',
			latitude: '1,666',
			longitude: '1,7777',
			statut: 'ACTIF'
		};

		pharmaciesServiceSpy.creer.and.returnValue(of({}));

		component.enregistrer();

		expect(pharmaciesServiceSpy.creer).toHaveBeenCalledWith(mockPharmacie);

		expect(messageServiceSpy.add).toHaveBeenCalledWith({
			severity: 'success',
			summary: 'Success',
			detail: 'Pharmacie enregistré avec succès'
		});

	});
});
