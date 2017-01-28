    CREATE SEQUENCE user_id_seq
      INCREMENT 1
      MINVALUE 1
      MAXVALUE 9223372036854775807
      START 1
      CACHE 1;


    CREATE TABLE sys_user
    (
      user_id bigint NOT NULL DEFAULT nextval('user_id_seq'::regclass),
      user_name character varying(50) NOT NULL,
      password character varying(60),
      email character varying(100),
      first_name character varying(150),
      last_name character varying(150),
      activated boolean NOT NULL,
      lang_key character varying(5),
      activation_key character varying(20),
      reset_key character varying(20),
      created_by character varying(50) NOT NULL,
      created_date timestamp without time zone NOT NULL,
      reset_date timestamp without time zone,
      updated_by character varying(50),
      updated_date timestamp without time zone DEFAULT now(),
      CONSTRAINT pk_user PRIMARY KEY (user_id),
      CONSTRAINT sys_user_email_key UNIQUE (email),
      CONSTRAINT sys_user_user_name_key UNIQUE (user_name)
    )

    CREATE TABLE sys_authority
    (
      name character varying(50) NOT NULL,
      CONSTRAINT pk_sys_authority PRIMARY KEY (name)
    )

    CREATE TABLE sys_user_authority
    (
      user_id bigint NOT NULL,
      authority character varying(50) NOT NULL,
      CONSTRAINT sys_user_authority_pkey PRIMARY KEY (user_id, authority)
    )
