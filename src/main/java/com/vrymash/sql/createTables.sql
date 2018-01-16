CREATE TABLE proof_words
(
  id serial NOT NULL,
  block_a integer NOT NULL DEFAULT 1000000000,
  block_b integer NOT NULL DEFAULT 1000000000,
  block_c integer NOT NULL DEFAULT 1000000000,
  block_d integer NOT NULL DEFAULT 1000000000,
  check_sum_a smallint NOT NULL DEFAULT 0,
  check_sum_b smallint NOT NULL DEFAULT 0,
  check_sum_c smallint NOT NULL DEFAULT 0,
  check_sum_d smallint NOT NULL DEFAULT 0,
  word character(64),
  confidence smallint NOT NULL DEFAULT 0,
  language_id serial,
  CONSTRAINT proof_words_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE proof_words OWNER TO postgres;

------------------------------------------------

CREATE TABLE languages
(
  id serial NOT NULL,
  language_name character(32),
  CONSTRAINT id PRIMARY KEY (id),
  CONSTRAINT language_id FOREIGN KEY (id)
      REFERENCES languages (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE languages OWNER TO postgres;
