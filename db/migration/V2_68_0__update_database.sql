CREATE TABLE IF NOT EXISTS PUBLIC.TBNOTIFICACOES (
	NOTCODIGO INTEGER NOT NULL,
	NOTVISUALIZADO BOOLEAN,
	CONSTRAINT TBNOTIFICACOES_PK PRIMARY KEY (NOTCODIGO)
);
CREATE UNIQUE INDEX IF NOT EXISTS PRIMARY_KEY_TBNOTIFICACOES ON PUBLIC.TBNOTIFICACOES (NOTCODIGO);

ALTER TABLE TBITEMLICITACAO ADD COLUMN IF NOT EXISTS ITEVENCEDORPORTE VARCHAR;
ALTER TABLE TBITEMLICITACAO ADD COLUMN IF NOT EXISTS ITEVENCEDORMODELO VARCHAR;