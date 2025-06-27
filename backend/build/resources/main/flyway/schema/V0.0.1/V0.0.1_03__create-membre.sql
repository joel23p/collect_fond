CREATE TABLE membres
(
    id INT8 PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenoms VARCHAR(100) NOT NULL,
    telephone VARCHAR(100) UNIQUE  NOT NULL,
    email VARCHAR(100) ,
    formule   VARCHAR(100) NOT NULL,
    date_inscription TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP ,
    create_at      TIMESTAMP,
    create_by     VARCHAR(255),
    update_at  TIMESTAMP,
    update_by VARCHAR(255),
    version INT8 NOT NULL DEFAULT 0
);
CREATE SEQUENCE membres_id_SEQ INCREMENT BY 50 START 1;
ALTER TABLE membres
    ALTER COLUMN id SET DEFAULT nextval('membres_id_seq');