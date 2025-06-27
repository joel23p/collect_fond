INSERT INTO utilisateur (id, username, prenoms, nom, role, statut ) VALUES
(nextval('utilisateur_id_seq'), 'admin', 'Administrateur', 'Super','ADMIN','ACTIF'),
(nextval('utilisateur_id_seq'), 'yop_agent', 'Ali', 'Koffi','Usager','ACTIF');
;
