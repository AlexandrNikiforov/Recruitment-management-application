CREATE TABLE public.user (
    id bigint NOT NULL,
    email varchar NOT NULL,
    password varchar NOT NULL,
    enabled boolean NOT NULL,
    role_id bigint NOT NULL,
    first_name varchar,
    last_name varchar
);

CREATE SEQUENCE public.user_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.role (
    id bigint NOT NULL,
    name varchar NOT NULL
);

CREATE SEQUENCE public.role_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.user_role (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);

CREATE TABLE public.vacancy (
    id bigint NOT NULL,
    company_id bigint NOT NULL,
    position_name varchar NOT NULL,
    required_experience varchar,
    description varchar,
    salary int,
    salary_currency varchar
);

CREATE SEQUENCE public.vacancy_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.company (
    id bigint NOT NULL,
    name varchar NOT NULL UNIQUE,
    description varchar
);

CREATE SEQUENCE public.company_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY public.user
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id);

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fk_userrole_user FOREIGN KEY (user_id) REFERENCES public.user(id);

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fk_userrole_role FOREIGN KEY (role_id) REFERENCES public.role(id);

ALTER TABLE ONLY public.vacancy
    ADD CONSTRAINT vacancy_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.company
    ADD CONSTRAINT company_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.vacancy
    ADD CONSTRAINT fk_vacancy_company FOREIGN KEY (company_id) REFERENCES public.company(id);

