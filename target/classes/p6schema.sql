--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 12.0

-- Started on 2020-02-28 20:02:16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- TOC entry 200 (class 1259 OID 34195)
-- Name: comment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comment (
    comment character varying(500) NOT NULL,
    member_id integer NOT NULL,
    topo_id integer NOT NULL,
    comment_id integer
);


ALTER TABLE public.comment OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 34397)
-- Name: comments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comments (
    comment_id integer NOT NULL,
    comment character varying,
    member_id integer,
    topo_id integer
);


ALTER TABLE public.comments OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 34405)
-- Name: comments_comment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.comments ALTER COLUMN comment_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.comments_comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 197 (class 1259 OID 34173)
-- Name: member; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.member (
    member_id integer NOT NULL,
    password character varying NOT NULL,
    email character varying NOT NULL,
    country character varying NOT NULL,
    name character varying NOT NULL,
    surname character varying NOT NULL,
    pseudo character varying(50) NOT NULL
);


ALTER TABLE public.member OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 34171)
-- Name: compte_idcompte_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.compte_idcompte_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.compte_idcompte_seq OWNER TO postgres;

--
-- TOC entry 2902 (class 0 OID 0)
-- Dependencies: 196
-- Name: compte_idcompte_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.compte_idcompte_seq OWNED BY public.member.member_id;


--
-- TOC entry 209 (class 1259 OID 34371)
-- Name: files; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.files (
    file_name character varying,
    file_type character varying,
    topo_id integer,
    data bytea,
    id character varying NOT NULL
);


ALTER TABLE public.files OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 34341)
-- Name: member_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.member_role (
    member_id integer,
    role_id integer
);


ALTER TABLE public.member_role OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 34407)
-- Name: persistent_logins; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.persistent_logins (
    username character varying(64) NOT NULL,
    series character varying(64) NOT NULL,
    token character varying(64) NOT NULL,
    last_used timestamp without time zone NOT NULL
);


ALTER TABLE public.persistent_logins OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 34206)
-- Name: reservation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation (
    reservation_id integer NOT NULL,
    user_id integer NOT NULL,
    topo_id integer NOT NULL,
    reservation_status character varying,
    owner_id integer
);


ALTER TABLE public.reservation OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 34204)
-- Name: reservation_idreservation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reservation_idreservation_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_idreservation_seq OWNER TO postgres;

--
-- TOC entry 2903 (class 0 OID 0)
-- Dependencies: 201
-- Name: reservation_idreservation_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reservation_idreservation_seq OWNED BY public.reservation.reservation_id;


--
-- TOC entry 207 (class 1259 OID 34333)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 34217)
-- Name: sector; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sector (
    sector_status character varying NOT NULL,
    sector_name character varying NOT NULL,
    topo_id integer NOT NULL,
    sector_id integer NOT NULL
);


ALTER TABLE public.sector OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 34318)
-- Name: sector_sector_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.sector ALTER COLUMN sector_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.sector_sector_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 199 (class 1259 OID 34184)
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo (
    id integer NOT NULL,
    name_topo character varying NOT NULL,
    region character varying NOT NULL,
    country character varying NOT NULL,
    topo_status character varying NOT NULL,
    member_id integer NOT NULL,
    official boolean,
    release_date date
);


ALTER TABLE public.topo OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 34182)
-- Name: topo_idtopo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.topo_idtopo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topo_idtopo_seq OWNER TO postgres;

--
-- TOC entry 2904 (class 0 OID 0)
-- Dependencies: 198
-- Name: topo_idtopo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topo_idtopo_seq OWNED BY public.topo.id;


--
-- TOC entry 205 (class 1259 OID 34228)
-- Name: way; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.way (
    way_id integer NOT NULL,
    name character varying NOT NULL,
    cotation character varying NOT NULL,
    number_points integer NOT NULL,
    sector_id integer NOT NULL
);


ALTER TABLE public.way OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 34226)
-- Name: voie_idvoie_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.voie_idvoie_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.voie_idvoie_seq OWNER TO postgres;

--
-- TOC entry 2905 (class 0 OID 0)
-- Dependencies: 204
-- Name: voie_idvoie_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.voie_idvoie_seq OWNED BY public.way.way_id;


--
-- TOC entry 2744 (class 2604 OID 34176)
-- Name: member member_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.member ALTER COLUMN member_id SET DEFAULT nextval('public.compte_idcompte_seq'::regclass);


--
-- TOC entry 2746 (class 2604 OID 34209)
-- Name: reservation reservation_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation ALTER COLUMN reservation_id SET DEFAULT nextval('public.reservation_idreservation_seq'::regclass);


--
-- TOC entry 2745 (class 2604 OID 34187)
-- Name: topo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo ALTER COLUMN id SET DEFAULT nextval('public.topo_idtopo_seq'::regclass);


--
-- TOC entry 2747 (class 2604 OID 34231)
-- Name: way way_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.way ALTER COLUMN way_id SET DEFAULT nextval('public.voie_idvoie_seq'::regclass);


--
-- TOC entry 2763 (class 2606 OID 34404)
-- Name: comments comments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comments
    ADD CONSTRAINT comments_pkey PRIMARY KEY (comment_id);


--
-- TOC entry 2749 (class 2606 OID 34181)
-- Name: member compte_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.member
    ADD CONSTRAINT compte_pk PRIMARY KEY (member_id);


--
-- TOC entry 2761 (class 2606 OID 34389)
-- Name: files files_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.files
    ADD CONSTRAINT files_pkey PRIMARY KEY (id);


--
-- TOC entry 2765 (class 2606 OID 34411)
-- Name: persistent_logins persistent_logins_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persistent_logins
    ADD CONSTRAINT persistent_logins_pkey PRIMARY KEY (series);


--
-- TOC entry 2753 (class 2606 OID 34214)
-- Name: reservation reservation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pk PRIMARY KEY (reservation_id);


--
-- TOC entry 2759 (class 2606 OID 34340)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2755 (class 2606 OID 34327)
-- Name: sector sector_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sector
    ADD CONSTRAINT sector_pkey PRIMARY KEY (sector_id);


--
-- TOC entry 2751 (class 2606 OID 34192)
-- Name: topo topo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pk PRIMARY KEY (id);


--
-- TOC entry 2757 (class 2606 OID 34236)
-- Name: way voie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.way
    ADD CONSTRAINT voie_pk PRIMARY KEY (way_id);


--
-- TOC entry 2769 (class 2606 OID 34242)
-- Name: reservation compte_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT compte_reservation_fk FOREIGN KEY (user_id) REFERENCES public.member(member_id);


--
-- TOC entry 2773 (class 2606 OID 34344)
-- Name: member_role fk_member; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.member_role
    ADD CONSTRAINT fk_member FOREIGN KEY (member_id) REFERENCES public.member(member_id);


--
-- TOC entry 2774 (class 2606 OID 34349)
-- Name: member_role fk_role; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.member_role
    ADD CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- TOC entry 2766 (class 2606 OID 34392)
-- Name: topo memberfk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT memberfk FOREIGN KEY (member_id) REFERENCES public.member(member_id) NOT VALID;


--
-- TOC entry 2772 (class 2606 OID 34328)
-- Name: way sector_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.way
    ADD CONSTRAINT sector_id_fk FOREIGN KEY (sector_id) REFERENCES public.sector(sector_id) NOT VALID;


--
-- TOC entry 2767 (class 2606 OID 34262)
-- Name: comment topo_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT topo_commentaire_fk FOREIGN KEY (topo_id) REFERENCES public.topo(id);


--
-- TOC entry 2775 (class 2606 OID 34379)
-- Name: files topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.files
    ADD CONSTRAINT topo_fk FOREIGN KEY (topo_id) REFERENCES public.topo(id) NOT VALID;


--
-- TOC entry 2770 (class 2606 OID 34257)
-- Name: reservation topo_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT topo_reservation_fk FOREIGN KEY (topo_id) REFERENCES public.topo(id);


--
-- TOC entry 2771 (class 2606 OID 34252)
-- Name: sector topo_secteur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sector
    ADD CONSTRAINT topo_secteur_fk FOREIGN KEY (topo_id) REFERENCES public.topo(id);


--
-- TOC entry 2768 (class 2606 OID 34366)
-- Name: comment user_comment-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT "user_comment-fk" FOREIGN KEY (member_id) REFERENCES public.member(member_id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


-- Completed on 2020-02-28 20:02:17

--
-- PostgreSQL database dump complete
--

