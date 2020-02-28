--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 12.0

-- Started on 2020-02-28 20:17:51

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

--
-- TOC entry 2898 (class 0 OID 34173)
-- Dependencies: 197
-- Data for Name: member; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.member (member_id, password, email, country, name, surname, pseudo) FROM stdin;
21	$2a$10$WHoyJv6hLAoXVXK9ZrJlG.xj7gI0OC.nOiIzM1CznsV0VbPTBzp3y	Jean@mail.fr	France	Jean	Lapierre	JeanLp
28	$2a$10$mJGNzRZGY6R.HuM94C3xGewSbPlO3FmQTXD4ik/iJFncNz6R5rCmm	Pierre@mail.fr	Canada	Pierre	Laroche	PierreLr
29	$2a$10$p.nvhR2ah84ihd7khhAYqe.pLHjA5tikSjifpNsdhQQ/QajuOeuFG	mathieu@email.fr	Belgique 	Mathieu	Dupont 	Matmat
30	$2a$10$ZkeVA0HU9HPwZWRQTCIBQuqr85MQx4vYBN2M/yOOOdPt5Q2fhc55G	elodie@email.fr	France	Elodie	Martin	elomar
31	$2a$10$/GAbDvilgbn5bRjWabcseuRRI2kk7X7X00MNxbWYpnx3QIKTKzIKO	camille@mail.fr	France	Camille	De la fontaine\r\n	camilledp
\.


--
-- TOC entry 2900 (class 0 OID 34184)
-- Dependencies: 199
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topo (id, name_topo, region, country, topo_status, member_id, official, release_date) FROM stdin;
1	le Piton des Colciennes	Joconde\n	France	Disponible	21	t	2020-02-16
22	la Montagne du Beaumart	Grand-Est	France	Indisponible	21	f	2020-02-16
20	le Volcan d'Avitou	Nord	test	Indisponible	21	t	2020-02-16
19	la Colline Douce	Auvergne	France	Disponible	21	t	2020-02-16
17	les Volcans d'Auribonne	Nord	France	Disponible	21	t	2020-02-16
26	la Montagne de Besanbeuge	Grand-Est	France	Indisponible	21	f	2020-02-28
25	la Montagne d'Haguezon	Grand-Est	France	Disponible	21	t	2020-02-28
21	les Volcans du Soizon	Auvergne	France	Disponible	21	t	2020-02-16
10	le Puy de Belveil	Auvergne	France	Disponible	21	f	2020-02-16
12	les Pics Solitaires	Nord	France	Disponible	21	t	2020-02-16
13	la Montagne Délicate	Nord	France	Disponible	21	f	2020-02-16
7	le Piton Boisé	Nord	France	Disponible	21	f	2020-02-16
24	les Puys Avides	Est	France	Indisponible	21	f	2020-02-16
23	les Volcans de la Clasier	Est	France	Disponible	21	f	2020-02-16
11	le Pic Chatoyant	Nord	France	Disponible	21	t	2020-02-16
6	les Sommets Fracturés	Nord	France	Disponible	21	t	2020-02-16
8	le Piton de l'Est	Auvergne	France	Disponible	21	t	2020-02-16
9	les Monts du Narroux	Auvergne	France	Disponible	21	t	2020-02-16
\.


--
-- TOC entry 2901 (class 0 OID 34195)
-- Dependencies: 200
-- Data for Name: comment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.comment (comment, member_id, topo_id, comment_id) FROM stdin;
Mon premier Commentaire	21	1	\N
Mon deuxieme commentaire	21	1	\N
Mon troisieme Commentaire	21	1	\N
Mon 4e Commentaire	21	1	\N
\.


--
-- TOC entry 2911 (class 0 OID 34397)
-- Dependencies: 210
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.comments (comment_id, comment, member_id, topo_id) FROM stdin;
1	Mon Premier Commenataire	21	1
2	Mon Second Commentaire	21	1
3	Mon 3e Commentaire	21	1
6	Tres bon topo	21	25
\.


--
-- TOC entry 2910 (class 0 OID 34371)
-- Dependencies: 209
-- Data for Name: files; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.files (file_name, file_type, topo_id, data, id) FROM stdin;
\.


--
-- TOC entry 2908 (class 0 OID 34333)
-- Dependencies: 207
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, name) FROM stdin;
1	ROLE_ADMIN
2	ROLE_USER
\.


--
-- TOC entry 2909 (class 0 OID 34341)
-- Dependencies: 208
-- Data for Name: member_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.member_role (member_id, role_id) FROM stdin;
21	1
28	2
29	2
30	2
31	1
\.


--
-- TOC entry 2913 (class 0 OID 34407)
-- Dependencies: 212
-- Data for Name: persistent_logins; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.persistent_logins (username, series, token, last_used) FROM stdin;
\.


--
-- TOC entry 2903 (class 0 OID 34206)
-- Dependencies: 202
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservation (reservation_id, user_id, topo_id, reservation_status, owner_id) FROM stdin;
9	21	23	Rejete	21
7	21	10	Termine	21
13	21	23	Refusee	21
3	21	12	Accepte	21
20	28	25	Indisponible	21
4	21	11	Refusee	21
1	21	6	Refusee	21
10	21	8	Refusee	21
14	28	1	Refusee	21
15	28	1	Refusee	21
16	28	1	Refusee	21
17	28	1	Refusee	21
18	28	1	Refusee	21
19	28	1	Refusee	21
21	28	20	Indisponible	21
22	28	22	EnAttente	21
5	21	7	Accepte	21
\.


--
-- TOC entry 2904 (class 0 OID 34217)
-- Dependencies: 203
-- Data for Name: sector; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sector (sector_status, sector_name, topo_id, sector_id) FROM stdin;
Disponible	le Ravin Écarlate	25	15
Indisponible	le Gouffre Féroce	25	16
Disponible	le Promontoire de Vulpin	1	1
Disponible	le Promontoire Rocheux	1	2
Disponible	les Promontoires d'Aigle	20	3
Disponible	le Canyon Brisé	20	4
Disponible	l'Abîme de Levasir	20	5
Disponible	le Mur du Colzon	20	6
Disponible	le Ravin de Montauvin	23	7
Disponible	le Fjord Parfumé	23	8
Disponible	les Falaises de Vateaux	23	9
Disponible	les Gorges des Cappes	23	10
Disponible	la Gorge de Mort	23	11
Disponible	l'Abysse Sacré	24	12
Disponible	le Rocher Énorme	24	13
Disponible	les Rochers Glacés	25	14
\.


--
-- TOC entry 2906 (class 0 OID 34228)
-- Dependencies: 205
-- Data for Name: way; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.way (way_id, name, cotation, number_points, sector_id) FROM stdin;
2	Voa	cota	5	1
3	Noa	cotsa	5	1
4	Boaa	codta	5	1
8	A	B	5	3
9	B	12	12	3
10	Voie	9b	12	3
11	Premiere	9b	1	3
12	Une Nouvelle Voie	9c	12	7
13	Une Nouvelle Voie	4a	12	12
\.


--
-- TOC entry 2919 (class 0 OID 0)
-- Dependencies: 211
-- Name: comments_comment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.comments_comment_id_seq', 6, true);


--
-- TOC entry 2920 (class 0 OID 0)
-- Dependencies: 196
-- Name: compte_idcompte_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.compte_idcompte_seq', 31, true);


--
-- TOC entry 2921 (class 0 OID 0)
-- Dependencies: 201
-- Name: reservation_idreservation_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservation_idreservation_seq', 22, true);


--
-- TOC entry 2922 (class 0 OID 0)
-- Dependencies: 206
-- Name: sector_sector_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sector_sector_id_seq', 16, true);


--
-- TOC entry 2923 (class 0 OID 0)
-- Dependencies: 198
-- Name: topo_idtopo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_idtopo_seq', 26, true);


--
-- TOC entry 2924 (class 0 OID 0)
-- Dependencies: 204
-- Name: voie_idvoie_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.voie_idvoie_seq', 13, true);


-- Completed on 2020-02-28 20:17:51

--
-- PostgreSQL database dump complete
--

