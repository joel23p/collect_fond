-- TABLE DES PAIEMENTS
CREATE TABLE paiements (
     id            INT8 PRIMARY KEY,
     membres_id     INT8  NOT NULL,
     date_paiement TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
     montant       INT8 NOT NULL,
     info          VARCHAR(255),
     create_at     TIMESTAMP,
     create_by     VARCHAR(255),
     update_at     TIMESTAMP,
     update_by     VARCHAR(255),
     version       INT8           NOT NULL DEFAULT 0,
     FOREIGN KEY (membres_id) REFERENCES membres (id) ON DELETE CASCADE
);

CREATE SEQUENCE paiements_id_SEQ INCREMENT BY 50 START 1;
ALTER TABLE paiements
    ALTER COLUMN id SET DEFAULT nextval('paiements_id_seq');