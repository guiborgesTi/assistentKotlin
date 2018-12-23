CREATE TABLE public.user_assistent (
    id_usuario bigint DEFAULT nextval('public.id_user'::regclass) NOT NULL,
    user_name character varying(20) NOT NULL,
    password character varying(10) NOT NULL,
    user_level character(1) NOT NULL,
    active boolean DEFAULT true NOT NULL,
    data_json json,
    dt_inclusao timestamp without time zone
);
