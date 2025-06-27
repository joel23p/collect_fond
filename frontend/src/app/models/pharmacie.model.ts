export class Pharmacie {
	id: number;
	numero: string;
	nom: string;
	ville: string;
	quartier: string;
	heureOuverture: string;
	heureFermeture: string;
	nomGerant: string;
	contact: string;
	statut: string;
	latitude: string;
	longitude: string;
	ouvert?: boolean;

	constructor(pharmacie: Partial<Pharmacie>) {
		Object.assign(this, pharmacie);
		return this;
	}
}
