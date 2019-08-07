
CREATE DATABASE test-task

CREATE TABLE public.person
(
    id uuid NOT NULL,
    first_name character(255) COLLATE pg_catalog."default",
    second_name character(255) COLLATE pg_catalog."default",
    last_name character(255) COLLATE pg_catalog."default",
    birth_date date,
    gender character(10) COLLATE pg_catalog."default",
    CONSTRAINT person_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.person
    OWNER to postgres;