DROP DATABASE IF EXISTS futbol;
CREATE DATABASE IF NOT EXISTS futbol;
USE futbol;

create table equipo (
id_ciudad int,
id int primary key,
nombre varchar(50),
fecha_fundacion date,
nombre_campo varchar(50)
);

create table jugador (
id int primary key,
nombre varchar(50),
apellido varchar(50),
posicion varchar(10) check (posicion IN ('portero', 'defensa', 'medio', 'delantero')),
pierna_habil char check (pierna_habil IN ('D', 'Z', 'A'))
);

create table ciudad (
id int primary key,
nombre varchar(50),
jugador_natal boolean
);

create table equipo_jugador (
id int primary key auto_increment,
id_equipo int,
id_jugador int,
fecha_inicio DATE,
fecha_fin DATE,
dorsal INT check (dorsal between 1 AND 50)
);

ALTER TABLE equipo_jugador add constraint fk_jugador foreign key (id_jugador) references jugador (id);
ALTER TABLE equipo_jugador add constraint fk_equipo foreign key (id_equipo) references equipo (id);
ALTER TABLE equipo add constraint fk_ciudad foreign key (id_ciudad) references ciudad (id);

INSERT INTO ciudad (id, nombre) VALUES
(1, 'Madrid'),
(2, 'Barcelona'),
(3, 'Sevilla'),
(4, 'San Sebastián'),
(5, 'Bilbao'),
(6, 'Villarreal'),
(7, 'Valencia'),
(8, 'Getafe'),
(9, 'Vigo'),
(10, 'Pamplona'),
(11, 'Las Palmas de Gran Canaria'),
(12, 'Palma de Mallorca'),
(13, 'Girona'),
(14, 'Vitoria-Gasteiz'),
(15, 'Cádiz'),
(16, 'Granada'),
(17, 'Valladolid');

INSERT INTO equipo (id_ciudad, id, nombre, fecha_fundacion, nombre_campo) VALUES
(1, 1, 'Real Madrid', '1902-03-06', 'Santiago Bernabéu'),
(2, 2, 'FC Barcelona', '1899-11-29', 'Spotify Camp Nou'),
(1, 3, 'Atlético de Madrid', '1903-04-26', 'Cívitas Metropolitano'),
(3, 4, 'Sevilla FC', '1890-01-25', 'Ramón Sánchez-Pizjuán'),
(3, 5, 'Real Betis', '1907-09-12', 'Benito Villamarín'),
(4, 6, 'Real Sociedad', '1909-09-07', 'Reale Arena'),
(5, 7, 'Athletic Club', '1898-01-01', 'San Mamés'),
(6, 8, 'Villarreal CF', '1923-03-10', 'La Cerámica'),
(7, 9, 'Valencia CF', '1919-03-18', 'Mestalla'),
(8, 10, 'Getafe CF', '1983-03-30', 'Coliseum'),
(9, 11, 'RC Celta', '1923-08-23', 'Abanca Balaídos'),
(10, 12, 'CA Osasuna', '1920-10-24', 'El Sadar'),
(1, 13, 'Rayo Vallecano', '1924-05-29', 'Vallecas'),
(12, 14, 'RCD Mallorca', '1916-03-05', 'Son Moix'),
(2, 15, 'Girona FC', '1930-07-23', 'Montilivi'),
(2, 16, 'RCD Español', '1900-10-28', 'RCD Stadium'),
(14, 17, 'Deportivo Alavés', '1921-01-23', 'Mendizorroza'),
(15, 18, 'Real Oviedo', '1926-03-26', 'Carlos Tartiere'),
(6, 19, 'Elche CF', '1923-01-23', 'Martinez Valero'),
(7, 20, 'Levante', '1909-09-06', 'Ciutat De Valencia');

INSERT INTO jugador (id, nombre, apellido, posicion, pierna_habil) VALUES

-- ============================================================
-- 1. REAL MADRID (entrenador: Xabi Alonso)
-- ============================================================
(1,  'Thibaut',    'Courtois',          'portero',   'D'),
(2,  'Andriy',     'Lunin',             'portero',   'D'),
(3,  'Dani',       'Carvajal',          'defensa',   'D'),
(4,  'Eder',       'Militao',           'defensa',   'D'),
(5,  'David',      'Alaba',             'defensa',   'Z'),
(6,  'Trent',      'Alexander-Arnold',  'defensa',   'D'),
(7,  'Raul',       'Asencio',           'defensa',   'D'),
(8,  'Alvaro',     'Carreras',          'defensa',   'Z'),
(9,  'Fran',       'Garcia',            'defensa',   'Z'),
(10, 'Antonio',    'Rudiger',           'defensa',   'D'),
(11, 'Ferland',    'Mendy',             'defensa',   'Z'),
(12, 'Dean',       'Huijsen',           'defensa',   'D'),
(13, 'Jude',       'Bellingham',        'medio',     'D'),
(14, 'Eduardo',    'Camavinga',         'medio',     'Z'),
(15, 'Federico',   'Valverde',          'medio',     'D'),
(16, 'Aurelien',   'Tchouameni',        'medio',     'D'),
(17, 'Arda',       'Guler',             'medio',     'D'),
(18, 'Dani',       'Ceballos',          'medio',     'D'),
(19, 'Brahim',     'Diaz',              'medio',     'D'),
(20, 'Franco',     'Mastantuono',       'medio',     'D'),
(21, 'Vinicius',   'Junior',            'delantero', 'D'),
(22, 'Endrick',    'Felipe',            'delantero', 'D'),
(23, 'Kylian',     'Mbappe',            'delantero', 'D'),
(24, 'Rodrygo',    'Goes',              'delantero', 'D'),
(25, 'Gonzalo',    'Garcia',            'delantero', 'D'),

-- ============================================================
-- 2. FC BARCELONA (entrenador: Hansi Flick)
-- ============================================================
(26, 'Wojciech',   'Szczesny',          'portero',   'D'),
(27, 'Inaki',      'Pena',              'portero',   'D'),
(28, 'Jules',      'Kounde',            'defensa',   'D'),
(29, 'Ronald',     'Araujo',            'defensa',   'D'),
(30, 'Pau',        'Cubarsi',           'defensa',   'Z'),
(31, 'Alejandro',  'Balde',             'defensa',   'Z'),
(32, 'Eric',       'Garcia',            'defensa',   'D'),
(33, 'Gerard',     'Martin',            'defensa',   'Z'),
(34, 'Pedri',      'Gonzalez',          'medio',     'D'),
(35, 'Frenkie',    'De Jong',           'medio',     'D'),
(36, 'Marc',       'Casado',            'medio',     'D'),
(37, 'Dani',       'Olmo',              'medio',     'D'),
(38, 'Fermin',     'Lopez',             'medio',     'D'),
(39, 'Marcus',     'Rashford',          'medio',     'D'),
(40, 'Pau',        'Victor',            'medio',     'D'),
(41, 'Lamine',     'Yamal',             'delantero', 'D'),
(42, 'Robert',     'Lewandowski',       'delantero', 'D'),
(43, 'Raphinha',   'Belloli',           'delantero', 'D'),
(44, 'Ferran',     'Torres',            'delantero', 'D'),
(45, 'Ansu',       'Fati',              'delantero', 'D'),
(46, 'Gavi',       'Paez',              'medio',     'D'),
(47, 'Andreas',    'Christensen',       'defensa',   'D'),
(48, 'Hector',     'Fort',              'defensa',   'D'),
(49, 'Inigo',      'Martinez',          'defensa',   'Z'),
(50, 'Noah',       'Darvich',           'delantero', 'D'),

-- ============================================================
-- 3. ATLETICO DE MADRID (entrenador: Diego Simeone)
-- ============================================================
(51, 'Juan',       'Musso',             'portero',   'D'),
(52, 'Jan',        'Oblak',             'portero',   'D'),
(53, 'Jose Maria', 'Gimenez',           'defensa',   'D'),
(54, 'Matteo',     'Ruggeri',           'defensa',   'Z'),
(55, 'Nahuel',     'Molina',            'defensa',   'D'),
(56, 'David',      'Hancko',            'defensa',   'Z'),
(57, 'Marc',       'Pubill',            'defensa',   'D'),
(58, 'Clement',    'Lenglet',           'defensa',   'Z'),
(59, 'Robin',      'Le Normand',        'defensa',   'D'),
(60, 'Koke',       'Resurreccion',      'medio',     'D'),
(61, 'Pablo',      'Barrios',           'medio',     'D'),
(62, 'Johnny',     'Cardoso',           'medio',     'D'),
(63, 'Rodrigo',    'Mendoza',           'medio',     'D'),
(64, 'Marcos',     'Llorente',          'medio',     'D'),
(65, 'Thiago',     'Almada',            'medio',     'D'),
(66, 'Alex',       'Baena',             'medio',     'D'),
(67, 'Rodrigo',    'De Paul',           'medio',     'D'),
(68, 'Antoine',    'Griezmann',         'delantero', 'D'),
(69, 'Julian',     'Alvarez',           'delantero', 'D'),
(70, 'Alexander',  'Sorloth',           'delantero', 'D'),
(71, 'Samuel',     'Lino',              'delantero', 'Z'),
(72, 'Angel',      'Correa',            'delantero', 'D'),
(73, 'Conor',      'Gallagher',         'medio',     'D'),
(74, 'Ivan',       'Llorente',          'defensa',   'D'),
(75, 'Javi',       'Serrano',           'defensa',   'Z'),


-- ============================================================
-- 4. SEVILLA FC (entrenador: Xavi Garcia Pimienta)
-- ============================================================
(76,'Orjan',      'Nyland',            'portero',   'D'),
(77,'Alfonso',    'Pastor',            'portero',   'D'),
(78,'Jesus',      'Navas',             'defensa',   'D'),
(79,'Loic',       'Bade',              'defensa',   'D'),
(80,'Marcao',     'Teixeira',          'defensa',   'D'),
(81,'Marcos',     'Acuna',             'defensa',   'Z'),
(82,'Juanlu',     'Sanchez',           'defensa',   'D'),
(83,'Nianzou',    'Kouassi',           'defensa',   'D'),
(84,'Kike',       'Salas',             'defensa',   'D'),
(85,'Fernando',   'Reges',             'medio',     'D'),
(86,'Samu',       'Acosta',            'medio',     'D'),
(87,'Lucien',     'Agoume',            'medio',     'D'),
(88,'Ivan',       'Marcano',           'defensa',   'D'),
(89,'Dodi',       'Lukebakio',         'delantero', 'D'),
(90,'Chidera',    'Ejuke',             'delantero', 'D'),
(91,'Isaac',      'Romero',            'delantero', 'D'),
(92,'Youssef',    'En-Nesyri',         'delantero', 'D'),
(93,'Victor',     'Noriega',           'delantero', 'D'),
(94,'Rafa',       'Mir',               'delantero', 'D'),
(95,'Peque',      'Fernandez',         'medio',     'D'),
(96,'Jose Angel', 'Carmona',           'defensa',   'D'),
(97,'Karim',      'Rekik',             'defensa',   'Z'),
(98,'Alberto',    'Flores',            'medio',     'D'),
(99,'Erik',       'Lamela',            'medio',     'D'),
(100,'Adria',      'Pedrosa',           'defensa',   'Z'),

-- ============================================================
-- 5. REAL BETIS (entrenador: Manuel Pellegrini)
-- ============================================================
(101,'Rui',        'Silva',             'portero',   'D'),
(102,'Fran',       'Vieites',           'portero',   'D'),
(103,'Hector',     'Bellerin',          'defensa',   'D'),
(104,'Natan',      'De Souza',          'defensa',   'D'),
(105,'Marc',       'Bartra',            'defensa',   'D'),
(106,'Ricardo',    'Rodriguez',         'defensa',   'Z'),
(107,'Pablo',      'Fornals',           'medio',     'Z'),
(108,'Giovani',    'Lo Celso',          'medio',     'Z'),
(109,'Isco',       'Alarcon',           'medio',     'D'),
(110,'Guido',      'Rodriguez',         'medio',     'D'),
(111,'William',    'Carvalho',          'medio',     'D'),
(112,'Sergi',      'Altimira',          'medio',     'D'),
(113,'Dani',       'Avila',             'medio',     'D'),
(114,'Romain',     'Perraud',           'defensa',   'Z'),
(115,'Juanmi',     'Jimenez',           'delantero', 'D'),
(116,'Ayoze',      'Perez',             'delantero', 'D'),
(117,'Vitor',      'Roque',             'delantero', 'D'),
(118,'Antony',     'Matheus',           'delantero', 'D'),
(119,'Ez',         'Abde',              'delantero', 'Z'),
(120,'Cedric',     'Bakambu',           'delantero', 'D'),
(121,'Diego',      'Llorente',          'defensa',   'D'),
(122,'German',     'Pezzella',          'defensa',   'D'),
(123,'Chadi',      'Riad',              'defensa',   'Z'),
(124,'Johnny',     'Cardoso',           'medio',     'D'),
(125,'Jesus',      'Rodriguez',         'medio',     'D'),

-- ============================================================
-- 6. REAL SOCIEDAD (entrenador: Imanol Alguacil)
-- ============================================================
(126,'Alex',       'Remiro',            'portero',   'D'),
(127,'Andres',     'Fernandez',         'portero',   'D'),
(128,'Andoni',     'Gorosabel',         'defensa',   'D'),
(129,'Igor',       'Zubeldia',          'defensa',   'D'),
(130,'Aritz',      'Elustondo',         'defensa',   'D'),
(131,'Aihen',      'Munoz',             'defensa',   'Z'),
(132,'Jon',        'Aramburu',          'defensa',   'D'),
(133,'Hamari',     'Traore',            'defensa',   'D'),
(134,'Nayef',      'Aguerd',            'defensa',   'D'),
(135,'Luca',       'Sucic',             'medio',     'D'),
(136,'Brais',      'Mendez',            'medio',     'D'),
(137,'Asier',      'Illarramendi',      'medio',     'D'),
(138,'Benat',      'Turrientes',        'medio',     'D'),
(139,'Robert',     'Navarro',           'medio',     'D'),
(140,'Sergio',     'Gomez',             'defensa',   'Z'),
(141,'Mikel',      'Oyarzabal',         'delantero', 'Z'),
(142,'Takefusa',   'Kubo',              'delantero', 'D'),
(143,'Umar',       'Sadiq',             'delantero', 'D'),
(144,'Sheraldo',   'Becker',            'delantero', 'D'),
(145,'Carlos',     'Fernandez',         'delantero', 'D'),
(146,'Andre',      'Silva',             'delantero', 'D'),
(147,'Mohamed',    'Cho',               'delantero', 'D'),
(148,'Pablo',      'Marin',             'medio',     'D'),
(149,'Ander',      'Barrenetxea',       'delantero', 'Z'),
(150,'Jon',        'Pacheco',           'portero',   'D'),

-- ============================================================
-- 7. ATHLETIC CLUB (entrenador: Ernesto Valverde)
-- ============================================================
(151, 'Julen',      'Agirrezabala',      'portero',   'D'),
(152, 'Unai',       'Simon',             'portero',   'D'),
(153, 'Oscar',      'De Marcos',         'defensa',   'D'),
(154, 'Dani',       'Vivian',            'defensa',   'D'),
(155, 'Aitor',      'Paredes',           'defensa',   'D'),
(156, 'Yuri',       'Berchiche',         'defensa',   'Z'),
(157, 'Mikel',      'Jauregizar',        'defensa',   'D'),
(158, 'Andoni',     'Gorosabel',         'defensa',   'D'),
(159, 'Yeray',      'Alvarez',           'defensa',   'D'),
(160, 'Mikel',      'Vesga',             'medio',     'D'),
(161, 'Oihan',      'Sancet',            'medio',     'D'),
(162, 'Ander',      'Herrera',           'medio',     'D'),
(163, 'Unai',       'Gomez',             'medio',     'D'),
(164, 'Peru',       'Nolaskoain',        'medio',     'D'),
(165, 'Benat',      'Prados',            'medio',     'D'),
(166, 'Jon',        'Morcillo',          'medio',     'D'),
(167, 'Mikel',      'Balenziaga',        'defensa',   'Z'),
(168, 'Nico',       'Williams',          'delantero', 'D'),
(169, 'Inaki',      'Williams',          'delantero', 'D'),
(170, 'Gorka',      'Guruzeta',          'delantero', 'D'),
(171, 'Asier',      'Villalibre',        'delantero', 'D'),
(172, 'Luka',       'Susaeta',           'delantero', 'D'),
(173, 'Alex',       'Petxarroman',       'defensa',   'D'),
(174, 'Iker',       'Muniain',           'medio',     'D'),
(175,'Unai',       'Nunez',             'defensa',   'D'),

-- ============================================================
-- 8. VILLARREAL CF (entrenador: Marcelino / Quique Setien)
-- ============================================================
(176,'Diego',      'Conde',             'portero',   'D'),
(177,'Filip',      'Jorgensen',         'portero',   'D'),
(178,'Juan',       'Foyth',             'defensa',   'D'),
(179,'Alfonso',    'Pedraza',           'defensa',   'Z'),
(180,'Pau',        'Torres',            'defensa',   'Z'),
(181,'Eric',       'Bailly',            'defensa',   'D'),
(182,'Aissa',      'Mandi',             'defensa',   'D'),
(183,'Alberto',    'Moreno',            'defensa',   'Z'),
(184,'Serge',      'Aurier',            'defensa',   'D'),
(185,'Dani',       'Parejo',            'medio',     'D'),
(186,'Etienne',    'Capoue',            'medio',     'D'),
(187,'Samu',       'Chukwueze',         'medio',     'D'),
(188,'Ilias',      'Akhomach',          'medio',     'D'),
(189,'Nicolas',    'Pepe',              'medio',     'D'),
(190,'Yeremy',     'Pino',              'delantero', 'D'),
(191,'Gerard',     'Moreno',            'delantero', 'D'),
(192,'Arnaut',     'Danjuma',           'delantero', 'D'),
(193,'Pepe',       'Reina',             'portero',   'D'),
(194,'Raul',       'Albiol',            'defensa',   'D'),
(195,'Thierno',    'Barry',             'delantero', 'D'),
(196,'Jorge',      'Cuenca',            'defensa',   'Z'),
(197,'Ilias',      'Morales',           'medio',     'D'),
(198,'Pepelu',     'Martinez',          'medio',     'D'),
(199,'Kiko',       'Femenia',           'defensa',   'D'),
(200,'Jose Luis',  'Morales',           'delantero', 'Z'),

-- ============================================================
-- 9. VALENCIA CF (entrenador: Carlos Corberán)
-- ============================================================
(201,'Giorgi',     'Mamardashvili',     'portero',   'D'),
(202,'Jaume',      'Domenech',          'portero',   'D'),
(203,'Thierry',    'Correia',           'defensa',   'D'),
(204,'Cristhian',  'Mosquera',          'defensa',   'D'),
(205,'Cenk',       'Ozkacar',           'defensa',   'D'),
(206,'Jose Luis',  'Gaya',              'defensa',   'Z'),
(207,'Mouctar',    'Diakhaby',          'defensa',   'D'),
(208,'Hugo',       'Guillamon',         'defensa',   'D'),
(209,'Diego',      'Lopez',             'defensa',   'D'),
(210,'Andre',      'Almeida',           'medio',     'D'),
(211,'Pepelu',     'Martinez',          'medio',     'D'),
(212,'Javi',       'Guerra',            'medio',     'D'),
(213,'Cesar',      'Tarrega',           'medio',     'D'),
(214,'Yarek',      'Gasiorowski',       'defensa',   'D'),
(215,'Selim',      'Amallah',           'medio',     'D'),
(216,'Justin',     'Kluivert',          'delantero', 'D'),
(217,'Hugo',       'Duro',              'delantero', 'D'),
(218,'Dani',       'Gomez',             'delantero', 'D'),
(219,'Diego',      'Lopez',             'medio',     'D'),
(220,'Rafa',       'Mir',               'delantero', 'D'),
(221,'Alejandro',  'Nieto',             'medio',     'D'),
(222,'Sergi',      'Canos',             'delantero', 'D'),
(223,'Eray',       'Comert',            'defensa',   'D'),
(224,'Fran',       'Perez',             'delantero', 'D'),
(225,'Nico',       'Gonzalez',          'medio',     'D'),

-- ============================================================
-- 10. GETAFE CF (entrenador: José Bordalás)
-- ============================================================
(226,'David',      'Soria',             'portero',   'D'),
(227,'Alfonso',    'Herrero',           'portero',   'D'),
(228,'Stefan',     'Mitrovic',          'defensa',   'D'),
(229,'Djene',      'Dakonam',           'defensa',   'D'),
(230,'Damian',     'Suarez',            'defensa',   'D'),
(231,'Omar',       'Alderete',          'defensa',   'D'),
(232,'Mathias',    'Olivera',           'defensa',   'Z'),
(233,'Gastón',     'Alvarez',           'defensa',   'D'),
(234,'Jesus',      'Forsberg',          'defensa',   'D'),
(235,'Mauro',      'Arambarri',         'medio',     'D'),
(236,'Luis',       'Milla',             'medio',     'D'),
(237,'Carles',     'Alena',             'medio',     'D'),
(238,'Oscar',      'Rodriguez',         'medio',     'D'),
(239,'Chema',      'Rodriguez',         'medio',     'D'),
(240,'Portu',      'Sanahuja',          'medio',     'D'),
(241,'Nemanja',    'Maksimovic',        'medio',     'D'),
(242,'Borja',      'Mayoral',           'delantero', 'D'),
(243,'Mason',      'Greenwood',         'delantero', 'D'),
(244,'Jaime',      'Mata',              'delantero', 'D'),
(245,'Enes',       'Unal',              'delantero', 'D'),
(246,'Juanmi',     'Latasa',            'delantero', 'D'),
(247,'Juan',       'Iglesias',          'defensa',   'D'),
(248,'Jorge',      'Cuenca',            'defensa',   'Z'),
(249,'Diego',      'Rico',              'defensa',   'Z'),
(250,'Florian',    'Neuhaus',           'medio',     'D'),

-- ============================================================
-- 11. RC CELTA DE VIGO (entrenador: Claudio Giráldez)
-- ============================================================
(251,'Ivan',       'Villar',            'portero',   'D'),
(252,'Vicente',    'Guaita',            'portero',   'D'),
(253,'Kevin',      'Vazquez',           'defensa',   'D'),
(254,'Unai',       'Nunez',             'defensa',   'Z'),
(255,'Joseph',     'Aidoo',             'defensa',   'D'),
(256,'Carlos',     'Dominguez',         'defensa',   'D'),
(257,'Oscar',      'Mingueza',          'defensa',   'D'),
(258,'Hugo',       'Alvarez',           'defensa',   'D'),
(259,'Jailson',    'Marques',           'defensa',   'D'),
(260,'Fran',       'Beltran',           'medio',     'D'),
(261,'Luca',       'De La Torre',       'medio',     'D'),
(262,'Carles',     'Perez',             'medio',     'D'),
(263,'Williot',    'Swedberg',          'medio',     'D'),
(264,'Gabri',      'Veiga',             'medio',     'D'),
(265,'Miguel',     'Rodriguez',         'medio',     'D'),
(266,'Iago',       'Aspas',             'delantero', 'Z'),
(267,'Jonathan',   'Bamba',             'delantero', 'D'),
(268,'Borja',      'Iglesias',          'delantero', 'D'),
(269,'Anastasios', 'Douvikas',          'delantero', 'D'),
(270,'Alfon',      'Gonzalez',          'medio',     'D'),
(271,'Jorge',      'Saenz',             'defensa',   'D'),
(272,'Franco',     'Cervi',             'delantero', 'Z'),
(273,'Patrick',    'Emond',             'delantero', 'D'),
(274,'Agustin',    'Marchesin',         'portero',   'D'),
(275,'Javier',     'Manquillo',         'defensa',   'D'),

-- ============================================================
-- 12. CA OSASUNA (entrenador: Alessio Lisci)
-- ============================================================
(276,'Sergio',     'Herrera',           'portero',   'D'),
(277,'Aitor',      'Fernandez',         'portero',   'D'),
(278,'Nacho',      'Vidal',             'defensa',   'D'),
(279,'David',      'Garcia',            'defensa',   'Z'),
(280,'Aridane',    'Hernandez',         'defensa',   'D'),
(281,'Juan Cruz',  'Oluwatosin',        'defensa',   'Z'),
(282,'Alejandro',  'Catena',            'defensa',   'D'),
(283,'Kike',       'Barja',             'medio',     'D'),
(284,'Lucas',      'Torro',             'medio',     'D'),
(285,'Jon',        'Moncayola',         'medio',     'D'),
(286,'Pablo',      'Ibanez',            'medio',     'D'),
(287,'Ruben',      'Garcia',            'medio',     'D'),
(288,'Bryan',      'Zaragoza',          'medio',     'D'),
(289,'Abde',       'Ezzalzouli',        'delantero', 'D'),
(290,'Ante',       'Budimir',           'delantero', 'D'),
(291,'Jesus',      'Areso',             'defensa',   'D'),
(292,'Moi',        'Gomez',             'medio',     'Z'),
(293,'Patrick',    'Sondre',            'medio',     'D'),
(294,'Ezequiel',   'AvilesMeza',        'medio',     'D'),
(295,'Alberto',    'Flores',            'medio',     'D'),
(296,'Jorge',      'Herrando',          'defensa',   'D'),
(297,'Arnau',      'Danjuma',           'delantero', 'D'),
(298,'Chimy',      'Avila',             'delantero', 'D'),
(299,'Jonjon',     'Boyomo',            'defensa',   'D'),
(300,'Nicolas',    'Seibt',             'portero',   'D'),

-- ============================================================
-- 13. RAYO VALLECANO (entrenador: Iñigo Pérez)
-- ============================================================
(301,'Augusto',    'Batalla',           'portero',   'D'),
(302,'Stole',      'Dimitrievski',      'portero',   'D'),
(303,'Ivan',       'Balliu',            'defensa',   'D'),
(304,'Florian',    'Lejeune',           'defensa',   'D'),
(305,'Alejandro',  'Catena',            'defensa',   'D'),
(306,'Fran',       'Garcia',            'defensa',   'Z'),
(307,'Mario',      'Suarez',            'defensa',   'D'),
(308,'Sergio',     'Camello',           'defensa',   'D'),
(309,'Niels',      'Nkounkou',          'defensa',   'Z'),
(310,'Oscar',      'Trejo',             'medio',     'D'),
(311,'Unai',       'Lopez',             'medio',     'Z'),
(312,'Jose',       'Pozo',              'medio',     'D'),
(313,'Randy',      'Nteka',             'medio',     'D'),
(314,'Pathe',      'Ciss',              'medio',     'D'),
(315,'Jorge',      'De Frutos',         'medio',     'D'),
(316,'Oscar',      'Valentín',          'medio',     'D'),
(317,'Raul',       'De Tomas',          'delantero', 'D'),
(318,'Alvaro',     'Garcia',            'delantero', 'D'),
(319,'Sergio',     'Leon',              'delantero', 'D'),
(320,'Luca',       'Zidane',            'portero',   'D'),
(321,'Andres',     'Martin',            'medio',     'D'),
(322,'Isi',        'Palazon',           'delantero', 'D'),
(323,'Bebeto',     'Andrean',           'delantero', 'D'),
(324,'Jose Maria', 'Salvi',             'defensa',   'D'),
(325,'Abdel',      'Abqar',             'medio',     'D'),





-- ============================================================
-- 14. RCD MALLORCA (entrenador: Martín Demichelis)
-- ============================================================
(326,'Predrag',    'Rajkovic',          'portero',   'D'),
(327,'Leo',        'Roman',             'portero',   'D'),
(328,'Pablo',      'Maffeo',            'defensa',   'D'),
(329,'Antonio',    'Raillo',            'defensa',   'D'),
(330,'Martin',     'Valjent',           'defensa',   'D'),
(331,'Jaume',      'Costa',             'defensa',   'Z'),
(332,'Takuma',     'Asano',             'delantero', 'D'),
(333,'Brian',      'Oliván',            'defensa',   'D'),
(334,'Mateu',      'Morey',             'defensa',   'D'),
(335,'Dani',       'Rodriguez',         'medio',     'D'),
(336,'Antonio',    'Sanchez',           'medio',     'D'),
(337,'Samú',       'Costa',             'medio',     'D'),
(338,'Cyle',       'Larin',             'delantero', 'D'),
(339,'Vedat',      'Muriqi',            'delantero', 'D'),
(340,'Lee',        'Kang-In',           'delantero', 'D'),
(341,'Sergi',      'Darder',            'medio',     'D'),
(342,'Jose Luis',  'Morales',           'delantero', 'Z'),
(343,'Clement',    'Grenier',           'medio',     'D'),
(344,'David',      'Larrubia',          'delantero', 'D'),
(345,'Giovanni',   'Gonzalez',          'defensa',   'D'),
(346,'Alex',       'Sureda',            'medio',     'D'),
(347,'Omar',       'Mascarell',         'medio',     'D'),
(348,'Baba',       'Rahman',            'defensa',   'Z'),
(349,'Abdón',      'Prats',             'delantero', 'D'),
(350,'Dominic',    'Greif',             'portero',   'D'),

-- ============================================================
-- 15. GIRONA FC (entrenador: Míchel)
-- ============================================================
(351,'Paulo',      'Gazzaniga',         'portero',   'D'),
(352,'Juan Carlos', 'Martin',           'portero',   'D'),
(353,'Yan',        'Couto',             'defensa',   'D'),
(354,'Ladislav',   'Krejci',            'defensa',   'Z'),
(355,'Eric',       'Garcia',            'defensa',   'D'),
(356,'Miguel',     'Gutierrez',         'defensa',   'Z'),
(357,'David',      'Lopez',             'defensa',   'D'),
(358,'Santiago',   'Bueno',             'defensa',   'D'),
(359,'Victor',     'Tsygankov',         'medio',     'D'),
(360,'Oriol',      'Romeu',             'medio',     'D'),
(361,'Aleix',      'Garcia',            'medio',     'D'),
(362,'Yangel',     'Herrera',           'medio',     'D'),
(363,'Ivan',       'Martin',            'medio',     'D'),
(364,'Bryan',      'Gil',               'delantero', 'Z'),
(365,'Cristhian',  'Stuani',            'delantero', 'D'),
(366,'Savinho',    'Moreira',           'delantero', 'D'),
(367,'Arnaut',     'Danjuma',           'delantero', 'D'),
(368,'Bojan',      'Miovski',           'delantero', 'D'),
(369,'Gabriel',    'Misehouy',          'medio',     'D'),
(370,'Abel',       'Ruiz',              'delantero', 'D'),
(371,'Jhon',       'Solis',             'defensa',   'D'),
(372,'Paulo',      'Fernandes',         'medio',     'D'),
(373,'Toni',       'Villa',             'delantero', 'D'),
(374,'Donny',      'Van de Beek',       'medio',     'D'),
(375,'Alejandro',  'Frances',           'defensa',   'D'),

-- ============================================================
-- 16. RCD ESPANYOL (entrenador: Manolo González)
-- ============================================================
(376,'Joan',       'Garcia',            'portero',   'D'),
(377,'Carlos',     'Lopez',             'portero',   'D'),
(378,'Nathanael',  'Ogbeta',            'defensa',   'D'),
(379,'Leandro',    'Cabrera',           'defensa',   'D'),
(380,'Omar',       'El Hilali',         'defensa',   'D'),
(381,'Carlos',     'Romero',            'defensa',   'D'),
(382,'Didac',      'Vila',              'defensa',   'Z'),
(383,'Sergi',      'Gomez',             'defensa',   'D'),
(384,'Brian',      'Olivan',            'defensa',   'D'),
(385,'Carlos',     'Alcaraz',           'medio',     'D'),
(386,'Jofre',      'Carreras',          'medio',     'D'),
(387,'Martin',     'Braithwaite',       'delantero', 'D'),
(388,'Luis',       'Rioja',             'medio',     'Z'),
(389,'Alex',       'Domingo',           'medio',     'D'),
(390,'Pol',        'Lozano',            'medio',     'D'),
(391,'Javi',       'Puado',             'delantero', 'D'),
(392,'Dani',       'Galan',             'delantero', 'Z'),
(393,'Pere',       'Milla',             'delantero', 'D'),
(394,'Vini',       'Souza',             'medio',     'D'),
(395,'Alejo',      'Veliz',             'delantero', 'D'),
(396,'David',      'Lopez',             'defensa',   'D'),
(397,'Laia',       'Aleixandri',        'defensa',   'D'),
(398,'Lamine',     'Diarra',            'medio',     'D'),
(399,'Andres',     'Prieto',            'portero',   'D'),
(400,'Joselu',     'Mato',              'delantero', 'D'),

-- ============================================================
-- 17. DEPORTIVO ALAVES (entrenador: Eduardo Coudet)
-- ============================================================
(401,'Antonio',    'Sivera',            'portero',   'D'),
(402,'Sivera',     'Backup',            'portero',   'D'),
(403,'Ruben',      'Duarte',            'defensa',   'Z'),
(404,'Victor',     'Laguardia',         'defensa',   'D'),
(405,'Florian',    'Lejeune',           'defensa',   'D'),
(406,'Toni',       'Moya',              'medio',     'D'),
(407,'Manu',       'Sanchez',           'defensa',   'Z'),
(408,'Ximo',       'Navarro',           'defensa',   'D'),
(409,'Jon',        'Guridi',            'medio',     'D'),
(410,'Luis',       'Rioja',             'delantero', 'Z'),
(411,'Theo',       'Zidane',            'defensa',   'D'),
(412,'Pere',       'Pons',              'medio',     'D'),
(413,'Deyverson',  'Acosta',            'delantero', 'D'),
(414,'Toni',       'Martinez',          'delantero', 'D'),
(415,'Kike',       'Garcia',            'delantero', 'D'),
(416,'Carlos',     'Vicente',           'delantero', 'D'),
(417,'Samu',       'Gomez',             'medio',     'D'),
(418,'Sergio',     'Lozano',            'medio',     'D'),
(419,'Jon',        'Arrizabalaga',      'portero',   'D'),
(420,'Conechny',   'Saul',              'medio',     'D'),
(421,'Abqar',      'Abdel',             'medio',     'D'),
(422,'Jacob',      'Bruun',             'delantero', 'D'),
(423,'Sedlar',     'Aleksandar',        'defensa',   'D'),
(424,'Facundo',    'Pellistri',         'delantero', 'D'),
(425,'Carlos',     'Benavidez',         'medio',     'D'),

-- ============================================================
-- 18. REAL OVIEDO (entrenador: Guillermo Almada)
--     (ascendido tras 24 años en Segunda)
-- ============================================================
(426,'Alfonso',    'Herrero',           'portero',   'D'),
(427,'Gaspar',     'Campos',            'portero',   'D'),
(428,'Dani',       'Calvo',             'defensa',   'D'),
(429,'Jimmy',      'Bermudez',          'defensa',   'D'),
(430,'Lucas',      'Ahijado',           'defensa',   'Z'),
(431,'Nehuen',     'Paz',               'defensa',   'D'),
(432,'Carlos',     'Hernandez',         'defensa',   'D'),
(433,'Jordi',      'Sanchez',           'defensa',   'D'),
(434,'Santi',      'Cazorla',           'medio',     'A'),
(435,'Borja',      'Sanchez',           'medio',     'D'),
(436,'Manu',       'Garcia',            'medio',     'D'),
(437,'Alejandro',  'Repo',              'medio',     'D'),
(438,'Lucas',      'Benitez',           'medio',     'D'),
(439,'Sergio',     'Tejera',            'medio',     'D'),
(440,'Nacho',      'Vidal',             'defensa',   'D'),
(441,'Roberto',    'Suarez',            'delantero', 'D'),
(442,'Seydouba',   'Cisse',             'delantero', 'D'),
(443,'Marcos',     'Calderon',          'defensa',   'D'),
(444,'Bastian',    'Meier',             'medio',     'D'),
(445,'Arnau',      'Puig',              'medio',     'D'),
(446,'Jairo',      'Izquierdo',         'delantero', 'Z'),
(447,'Brayan',     'Riascos',           'delantero', 'D'),
(448,'Hugo',       'Rama',              'delantero', 'D'),
(449,'Adrian',     'Colunga',           'delantero', 'D'),
(450,'David',      'Costas',            'defensa',   'D'),

-- ============================================================
-- 19. ELCHE CF (entrenador: Eder Sarabia)
--     (ascendido de Segunda División)
-- ============================================================
(451,'Kiko',       'Casilla',           'portero',   'D'),
(452,'Pedro',      'Bigas',             'defensa',   'D'),
(453,'Tete',       'Morente',           'defensa',   'D'),
(454,'Juan',       'Cruz',              'defensa',   'Z'),
(455,'Patricio',   'Gabarrón',          'portero',   'D'),
(456,'Josema',     'Sanchez',           'defensa',   'D'),
(457,'Helibelton', 'Palacios',          'defensa',   'D'),
(458,'Lautaro',    'Blanco',            'defensa',   'Z'),
(459,'Fidel',      'Chaves',            'medio',     'D'),
(460,'Gus',        'Ledes',             'medio',     'D'),
(461,'Ezequiel',   'Ponce',             'delantero', 'D'),
(462,'Omar',       'Mascarell',         'medio',     'D'),
(463,'Andres',     'Garcia',            'medio',     'D'),
(464,'Alvaro',     'Sanchez',           'defensa',   'D'),
(465,'Sory',       'Kaba',              'delantero', 'D'),
(466,'Lucas',      'Perez',             'delantero', 'D'),
(467,'Raul',       'Guti',              'medio',     'D'),
(468,'Nico',       'Castro',            'medio',     'D'),
(469,'Christian',  'Rivera',            'medio',     'Z'),
(470,'Marc',       'Domenech',          'portero',   'D'),
(471,'Ivan',       'Marcone',           'medio',     'D'),
(472,'Ivan',       'Balliu',            'defensa',   'D'),
(473,'Samuel',     'Odobert',           'delantero', 'D'),
(474,'Gonzalo',    'Villar',            'medio',     'D'),
(475,'Claudio',    'Medina',            'defensa',   'D'),

-- ============================================================
-- 20. LEVANTE UD (entrenador: Luís Castro)
--     (ascendido de Segunda División)
-- ============================================================
(476,'Andriy',     'Lunin',             'portero',   'D'),
(477,'Pablo',      'Martinez',          'portero',   'D'),
(478,'Pepelu',     'Martinez',          'portero',   'D'),
(479,'Jose',       'Campana',           'medio',     'D'),
(480,'Carlos',     'Clerc',             'defensa',   'Z'),
(481,'Dani',       'Gomez',             'delantero', 'D'),
(482,'Gonzalo',    'Melero',            'medio',     'D'),
(483,'Jose',       'Luis Morales',      'delantero', 'Z'),
(484,'Son',        'Heung-Min',         'delantero', 'D'),
(485,'Enis',       'Bardhi',            'medio',     'D'),
(486,'Miquel',     'Crespi',            'defensa',   'D'),
(487,'Marc',       'Pubill',            'defensa',   'D'),
(488,'Rober',      'Pier',              'defensa',   'D'),
(489,'Sergio',     'Postigo',           'defensa',   'D'),
(490,'Nemanja',    'Radoja',            'medio',     'D'),
(491,'Roger',      'Marti',             'delantero', 'Z'),
(492,'Toño',       'Garcia',            'portero',   'D'),
(493,'Coke',       'Andujar',           'defensa',   'D'),
(494,'Iban',       'Salvador',          'medio',     'D'),
(495,'Marc',       'Relats',            'delantero', 'D'),
(496,'Mickael',    'Malsa',             'medio',     'D'),
(497,'Nikola',     'Vukcevic',          'medio',     'D'),
(498,'Ruben',      'Vezo',              'defensa',   'D'),
(499,'Marc',       'Pubill',            'defensa',   'D'),
(500,'Armando',    'Sadiku',            'delantero', 'D');

INSERT INTO equipo_jugador (id_equipo, id_jugador) VALUES
-- Equipo 1
(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),
(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),
(1,21),(1,22),(1,23),(1,24),(1,25),
 
-- Equipo 2
(2,26),(2,27),(2,28),(2,29),(2,30),(2,31),(2,32),(2,33),(2,34),(2,35),
(2,36),(2,37),(2,38),(2,39),(2,40),(2,41),(2,42),(2,43),(2,44),(2,45),
(2,46),(2,47),(2,48),(2,49),(2,50),
 
-- Equipo 3
(3,51),(3,52),(3,53),(3,54),(3,55),(3,56),(3,57),(3,58),(3,59),(3,60),
(3,61),(3,62),(3,63),(3,64),(3,65),(3,66),(3,67),(3,68),(3,69),(3,70),
(3,71),(3,72),(3,73),(3,74),(3,75),
 
-- Equipo 4
(4,76),(4,77),(4,78),(4,79),(4,80),(4,81),(4,82),(4,83),(4,84),(4,85),
(4,86),(4,87),(4,88),(4,89),(4,90),(4,91),(4,92),(4,93),(4,94),(4,95),
(4,96),(4,97),(4,98),(4,99),(4,100),
 
-- Equipo 5
(5,101),(5,102),(5,103),(5,104),(5,105),(5,106),(5,107),(5,108),(5,109),(5,110),
(5,111),(5,112),(5,113),(5,114),(5,115),(5,116),(5,117),(5,118),(5,119),(5,120),
(5,121),(5,122),(5,123),(5,124),(5,125),
 
-- Equipo 6
(6,126),(6,127),(6,128),(6,129),(6,130),(6,131),(6,132),(6,133),(6,134),(6,135),
(6,136),(6,137),(6,138),(6,139),(6,140),(6,141),(6,142),(6,143),(6,144),(6,145),
(6,146),(6,147),(6,148),(6,149),(6,150),
 
-- Equipo 7
(7,151),(7,152),(7,153),(7,154),(7,155),(7,156),(7,157),(7,158),(7,159),(7,160),
(7,161),(7,162),(7,163),(7,164),(7,165),(7,166),(7,167),(7,168),(7,169),(7,170),
(7,171),(7,172),(7,173),(7,174),(7,175),
 
-- Equipo 8
(8,176),(8,177),(8,178),(8,179),(8,180),(8,181),(8,182),(8,183),(8,184),(8,185),
(8,186),(8,187),(8,188),(8,189),(8,190),(8,191),(8,192),(8,193),(8,194),(8,195),
(8,196),(8,197),(8,198),(8,199),(8,200),
 
-- Equipo 9
(9,201),(9,202),(9,203),(9,204),(9,205),(9,206),(9,207),(9,208),(9,209),(9,210),
(9,211),(9,212),(9,213),(9,214),(9,215),(9,216),(9,217),(9,218),(9,219),(9,220),
(9,221),(9,222),(9,223),(9,224),(9,225),
 
-- Equipo 10
(10,226),(10,227),(10,228),(10,229),(10,230),(10,231),(10,232),(10,233),(10,234),(10,235),
(10,236),(10,237),(10,238),(10,239),(10,240),(10,241),(10,242),(10,243),(10,244),(10,245),
(10,246),(10,247),(10,248),(10,249),(10,250),
 
-- Equipo 11
(11,251),(11,252),(11,253),(11,254),(11,255),(11,256),(11,257),(11,258),(11,259),(11,260),
(11,261),(11,262),(11,263),(11,264),(11,265),(11,266),(11,267),(11,268),(11,269),(11,270),
(11,271),(11,272),(11,273),(11,274),(11,275),
 
-- Equipo 12
(12,276),(12,277),(12,278),(12,279),(12,280),(12,281),(12,282),(12,283),(12,284),(12,285),
(12,286),(12,287),(12,288),(12,289),(12,290),(12,291),(12,292),(12,293),(12,294),(12,295),
(12,296),(12,297),(12,298),(12,299),(12,300),
 
-- Equipo 13
(13,301),(13,302),(13,303),(13,304),(13,305),(13,306),(13,307),(13,308),(13,309),(13,310),
(13,311),(13,312),(13,313),(13,314),(13,315),(13,316),(13,317),(13,318),(13,319),(13,320),
(13,321),(13,322),(13,323),(13,324),(13,325),
 
-- Equipo 14
(14,326),(14,327),(14,328),(14,329),(14,330),(14,331),(14,332),(14,333),(14,334),(14,335),
(14,336),(14,337),(14,338),(14,339),(14,340),(14,341),(14,342),(14,343),(14,344),(14,345),
(14,346),(14,347),(14,348),(14,349),(14,350),
 
-- Equipo 15
(15,351),(15,352),(15,353),(15,354),(15,355),(15,356),(15,357),(15,358),(15,359),(15,360),
(15,361),(15,362),(15,363),(15,364),(15,365),(15,366),(15,367),(15,368),(15,369),(15,370),
(15,371),(15,372),(15,373),(15,374),(15,375),
 
-- Equipo 16
(16,376),(16,377),(16,378),(16,379),(16,380),(16,381),(16,382),(16,383),(16,384),(16,385),
(16,386),(16,387),(16,388),(16,389),(16,390),(16,391),(16,392),(16,393),(16,394),(16,395),
(16,396),(16,397),(16,398),(16,399),(16,400),
 
-- Equipo 17
(17,401),(17,402),(17,403),(17,404),(17,405),(17,406),(17,407),(17,408),(17,409),(17,410),
(17,411),(17,412),(17,413),(17,414),(17,415),(17,416),(17,417),(17,418),(17,419),(17,420),
(17,421),(17,422),(17,423),(17,424),(17,425),
 
-- Equipo 18
(18,426),(18,427),(18,428),(18,429),(18,430),(18,431),(18,432),(18,433),(18,434),(18,435),
(18,436),(18,437),(18,438),(18,439),(18,440),(18,441),(18,442),(18,443),(18,444),(18,445),
(18,446),(18,447),(18,448),(18,449),(18,450),
 
-- Equipo 19
(19,451),(19,452),(19,453),(19,454),(19,455),(19,456),(19,457),(19,458),(19,459),(19,460),
(19,461),(19,462),(19,463),(19,464),(19,465),(19,466),(19,467),(19,468),(19,469),(19,470),
(19,471),(19,472),(19,473),(19,474),(19,475),
 
-- Equipo 20
(20,476),(20,477),(20,478),(20,479),(20,480),(20,481),(20,482),(20,483),(20,484),(20,485),
(20,486),(20,487),(20,488),(20,489),(20,490),(20,491),(20,492),(20,493),(20,494),(20,495),
(20,496),(20,497),(20,498),(20,499),(20,500);
 
SELECT jugador.nombre, equipo.nombre
FROM equipo_jugador, equipo, jugador
WHERE equipo_jugador.id_jugador = jugador.id AND equipo.id = equipo_jugador.id_equipo;