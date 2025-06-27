export class StatutImportPharmacie {
	nbreLigneAImporter: number;
	pharmaciesNonImportees:[] ;

	constructor(statutImportPharmacie: StatutImportPharmacie) {
		Object.assign(this, statutImportPharmacie);
		return this;
	}
}