CREATE TABLE public.user (
    id bigint NOT NULL,
    email varchar NOT NULL,
    password varchar NOT NULL,
    enagled boolean NOT NULL,
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

