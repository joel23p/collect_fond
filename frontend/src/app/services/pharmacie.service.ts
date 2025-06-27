import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Pharmacie } from "../models/pharmacie.model";


@Injectable({
	providedIn: 'root'
})
export class PharmacieService {
	private baseUrl = '/ws/pharmacie';
	static readonly importPharmacieUrl = '/ws/pharmacie/importer';
	constructor(private http: HttpClient) {
	}

	/**
	 * Récupère la liste des pharmacies.
	 */
	listerPharmacies(): Observable<Pharmacie[]> {
		return this.http.get<Pharmacie[]>(`${this.baseUrl}/lister`);
	}

	/**
	 * Crée une nouvelle pharmacie.
	 *
	 * @param pharmacie la pharmacie à créer.
	 */
	creer(pharmacie : Pharmacie): Observable<void>{
		return this.http.post<void>(this.baseUrl + '/enregistrer', pharmacie)
	}
}
