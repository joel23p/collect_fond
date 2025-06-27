import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CelebrationMariage } from '../models/celebration-mariage';

@Injectable({
	providedIn: 'root'
})
export class CelebrationMariageService {

	private baseUrl = '/ws/demande-mariage';
	constructor(private http: HttpClient) {}

	/**
	 * Enregistrer une demande de célébration de mariage.
	 *
	 * @param demande les données de la demande à enregistrer
	 */
	enregistrer(celebrationMariage: CelebrationMariage): Observable<CelebrationMariage> {
		return this.http.post<CelebrationMariage>(this.baseUrl + '/enregistrer', celebrationMariage);
	}

	/**
	 * Récupérer toutes les demandes de mariage.
	 */
	lister(): Observable<CelebrationMariage[]> {
		return this.http.get<CelebrationMariage[]>(`${this.baseUrl}/lister`);
	}

	/**
	 * Récupérer une demande spécifique par son ID.
	 *
	 * @param id identifiant de la demande
	 */
	recuperer(id: number): Observable<CelebrationMariage> {
		return this.http.get<CelebrationMariage>(`${this.baseUrl}/recuperer/${id}`);
	}

	/**
	 * Mettre à jour une demande existante.
	 *
	 * @param demande les données mises à jour
	 */
	modifier(demande: CelebrationMariage): Observable<CelebrationMariage> {
		return this.http.put<CelebrationMariage>(`${this.baseUrl}/modifier`, demande);
	}

	/**
	 * Supprimer une demande par son ID.
	 *
	 * @param id identifiant de la demande
	 */
	supprimer(id: number): Observable<void> {
		return this.http.delete<void>(`${this.baseUrl}/supprimer/${id}`);
	}
}
