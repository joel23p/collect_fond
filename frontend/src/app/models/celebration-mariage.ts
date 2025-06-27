export class CelebrationMariage {
	id?: number = 0;
	idRegistre?: number = 0;
	codeRegistre: string = "";
	codeDemande: string = "";
	nomEpoux: string = '';
	prenomsEpoux: string = '';
	telephoneEpoux: string = '';
	dateNaissEpoux: string = '';
	lieuNaissEpoux: string = '';
	professionEpoux: string = '';
	nomPereEpoux: string = '';
	prenomsPereEpoux: string = '';
	nomMereEpoux: string = '';
	prenomsMereEpoux: string = '';
	domicileEpoux: string = '';
	typePieceIdentEpoux: string = '';
	chemPieceIdentEpoux: string = '';
	certifResidenceEpoux: string = '';
	nomTemoinEpoux: string = '';
	prenomsTemoinEpoux: string = '';
	professionTemoinEpoux: string = '';
	domicileTemoinEpoux: string = '';
	typePieceIdentTemoinEpoux: string = '';
	chemPieceIdentTemoinEpoux: string = '';
	photoIdentEpoux: string = '';
	situationMatriEpoux: string = '';

	nomEpouse: string = '';
	prenomsEpouse: string = '';
	telephoneEpouse: string = '';
	dateNaissEpouse: string = '';
	lieuNaissEpouse: string = '';
	professionEpouse: string = '';
	nomPereEpouse: string = '';
	prenomsPereEpouse: string = '';
	nomMereEpouse: string = '';
	prenomsMereEpouse: string = '';
	domicileEpouse: string = '';
	typePieceIdentEpouse: string = '';
	chemPieceIdentEpouse: string = '';
	certifResidenceEpouse: string = '';
	nomTemoinEpouse: string = '';
	prenomsTemoinEpouse: string = '';
	professionTemoinEpouse: string = '';
	domicileTemoinEpouse: string = '';
	typePieceIdentTemoinEpouse: string = '';
	chemPieceIdentTemoinEpouse: string = '';
	photoIdentEpouse: string = '';
	situationMatriEpouse: string = '';

	dateRendezVous?: string = ''; // ISO string

	regime: 'COMMUNAUTE_BIEN' | 'SEPARATION_BIEN' = 'COMMUNAUTE_BIEN';
	statut: 'NON_DEMARRE' | 'EN_COURS' | 'REJETE' | 'VALIDE' | 'ANNULE' = 'NON_DEMARRE';
	roleDemandeur: 'EPOUX' | 'EPOUSE' | 'AMI' | 'PARENT' | 'TUTEUR' = 'EPOUX';

	montant?: number = 0;
	idEtapeActive?: number = 0;
	delaiEtapeActive?: number = 0;
	nomEtapeActive: string = '';
	createAt?: string = '';
	createBy: string = '';
	updateAt?: string = '';
	updateBy: string = '';
	etapes: any;
	version:number=0;
}
