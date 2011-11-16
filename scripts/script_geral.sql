CREATE DATABASE doctor
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'pt_BR.UTF-8'
       LC_CTYPE = 'pt_BR.UTF-8'
       CONNECTION LIMIT = -1;

CREATE TABLE users
(
  id serial NOT NULL,
  "name" character varying(60) NOT NULL,
  email character varying(50) NOT NULL,
  "password" character varying(20) NOT NULL,
  crm character varying(15),
  "type" smallint NOT NULL DEFAULT 0,
  CONSTRAINT id PRIMARY KEY (id)
);

CREATE TABLE services
(
  id serial NOT NULL,
  "name" character varying(20) NOT NULL,
  duration smallint,
  CONSTRAINT pk_service PRIMARY KEY (id)
);

CREATE TABLE services_doctor
(
  doctor_id integer NOT NULL,
  service_id integer NOT NULL,
  CONSTRAINT services_doctor_pkey PRIMARY KEY (doctor_id, service_id),
  CONSTRAINT fk_doctor FOREIGN KEY (doctor_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_service FOREIGN KEY (service_id)
      REFERENCES services (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE meetings
(
  id serial NOT NULL,
  notes character varying(100),
  "scheduledDate" date NOT NULL,
  "attendedDate" date,
  doctor_id integer NOT NULL,
  client_id integer NOT NULL,
  service_id integer NOT NULL,
  CONSTRAINT pk_meeting PRIMARY KEY (id),
  CONSTRAINT fk_client FOREIGN KEY (client_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_service_doctor FOREIGN KEY (service_id, doctor_id)
      REFERENCES services_doctor (service_id, doctor_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
