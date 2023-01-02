-- Table: public.weather_server

-- DROP TABLE IF EXISTS public.weather_server;

CREATE TABLE IF NOT EXISTS public.weather_server
(
    id integer NOT NULL,
    url character varying(256) COLLATE pg_catalog."default",
    name character varying(256) COLLATE pg_catalog."default",
    key character varying(256) COLLATE pg_catalog."default",
    current_weather_url character varying(256) COLLATE pg_catalog."default",
    CONSTRAINT weather_server_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.weather_server
    OWNER to postgres;


-- Table: public.city

-- DROP TABLE IF EXISTS public.city;

CREATE TABLE IF NOT EXISTS public.city
(
    id integer NOT NULL,
    name character varying COLLATE pg_catalog."default",
    longitude character varying COLLATE pg_catalog."default",
    latitude character varying COLLATE pg_catalog."default",
    CONSTRAINT city_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.city
    OWNER to postgres;


-- Table: public.weather

-- DROP TABLE IF EXISTS public.weather;

CREATE TABLE IF NOT EXISTS public.weather
(
    id bigint NOT NULL DEFAULT nextval('weather_id_seq'::regclass),
    temperature integer,
    humidity integer,
    pressure integer,
    wind_speed integer,
    wind_gust integer,
    wind_bearing integer,
    cloud_cover integer,
    uv_index integer,
    visibility integer,
    city_id integer,
    server_id integer,
    ozone integer,
    wind_direction character varying COLLATE pg_catalog."default",
    date_time timestamp without time zone,
    CONSTRAINT weather_pkey PRIMARY KEY (id),
    CONSTRAINT city_fk FOREIGN KEY (city_id)
    REFERENCES public.city (id) MATCH SIMPLE
                        ON UPDATE NO ACTION
                        ON DELETE NO ACTION,
    CONSTRAINT server_fk FOREIGN KEY (server_id)
    REFERENCES public.weather_server (id) MATCH SIMPLE
                        ON UPDATE NO ACTION
                        ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.weather
    OWNER to postgres;





