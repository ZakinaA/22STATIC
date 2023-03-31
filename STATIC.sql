-- phpMyAdmin SQL Dump
-- version 5.0.4deb2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : ven. 31 mars 2023 à 06:19
-- Version du serveur :  10.5.12-MariaDB-0+deb11u1
-- Version de PHP : 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `STATIC`
--

-- --------------------------------------------------------

--
-- Structure de la table `album`
--

CREATE TABLE `album` (
  `alb_id` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `dateCreation` date DEFAULT NULL,
  `cheminImg` varchar(200) DEFAULT NULL,
  `idGroupe` int(11) NOT NULL,
  `lienAlbum` varchar(255) DEFAULT NULL,
  `archiver` tinyint(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `album`
--

INSERT INTO `album` (`alb_id`, `nom`, `dateCreation`, `cheminImg`, `idGroupe`, `lienAlbum`, `archiver`, `description`) VALUES
(1, 'Le monde chico', '2009-01-22', 'https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/41Izfgf8DML.jpg', 1, 'https://open.spotify.com/embed/album/0OrjrvwmdJ82zYJpJ46lUs', 0, 'Some quick example text to build on the card title and make up the bulk of the card\'s content.'),
(2, 'Envolée Zougloutique', '2009-01-22', 'https://is2-ssl.mzstatic.com/image/thumb/Music115/v4/fc/af/1d/fcaf1da3-6db5-01dc-28d4-eaa040c628ad/21UMGIM55076.rgb.jpg/1200x1200bf-60.jpg', 2, 'https://open.spotify.com/embed/album/6AIBufmFvUfgCdWLhHiQr5', 0, 'HAHAHAHA GUILLAUME'),
(3, 'Mini World', '2007-03-14', 'https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/51pw5F5WQ7L._SX300_SY300_QL70_ML2_.jpg', 3, 'https://open.spotify.com/embed/album/1r7XjAgjwlakmXC2GbPXjH', 0, 'Some quick example text to build on the card title and make up the bulk of the card\'s content.'),
(4, 'Mi Vida', '2020-01-22', 'https://cdns-images.dzcdn.net/images/cover/78bc8601a174b8f1ee20fc8577f06671/500x500.jpg', 4, 'https://open.spotify.com/embed/album/6Rq5fjFsMh2iF4RCNo2PFk', 0, 'Some quick example text to build on the card title and make up the bulk of the card\'s content.'),
(5, ' Random Access Memories', '2013-05-17', 'https://i0.wp.com/www.indiemusic.fr/wp-content/uploads/2013/05/Daft-Punk-Random-Access-Memories.jpg?resize=600%2C600', 5, 'https://open.spotify.com/embed/album/4m2880jivSbbyEGAKfITCa', 1, 'Some quick example text to build on the card title and make up the bulk of the card\'s content.');

-- --------------------------------------------------------

--
-- Structure de la table `dispositif`
--

CREATE TABLE `dispositif` (
  `dis_id` int(11) NOT NULL,
  `annee` int(11) DEFAULT NULL,
  `libelle` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `dispositif`
--

INSERT INTO `dispositif` (`dis_id`, `annee`, `libelle`) VALUES
(1, 2021, 'Normanzik'),
(2, 2022, 'Norzik');

-- --------------------------------------------------------

--
-- Structure de la table `donnerconcert`
--

CREATE TABLE `donnerconcert` (
  `idGroupe` int(11) NOT NULL,
  `idLieuConcert` int(11) NOT NULL,
  `dateConcert` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `donnerconcert`
--

INSERT INTO `donnerconcert` (`idGroupe`, `idLieuConcert`, `dateConcert`) VALUES
(1, 1, '2022-05-31'),
(2, 1, '2022-08-19'),
(3, 1, '2022-02-21'),
(4, 1, '2022-12-25');

-- --------------------------------------------------------

--
-- Structure de la table `festival`
--

CREATE TABLE `festival` (
  `fes_id` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `annee` varchar(50) DEFAULT NULL,
  `dateDebut` date DEFAULT NULL,
  `dateFin` date DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `festival`
--

INSERT INTO `festival` (`fes_id`, `nom`, `annee`, `dateDebut`, `dateFin`, `logo`) VALUES
(1, 'Papillons de Nuit', '2022', '2022-06-03', '2022-06-05', 'https://www.rollingstone.fr/wp-content/uploads/2023/02/Papillons-de-nuit-2023.jpg'),
(2, 'Festival Beauregard', '2022', '2022-07-06', '2022-07-10', 'https://www.festivalbeauregard.com/user/image/edition/editionLogo_048727xlarge.png');

-- --------------------------------------------------------

--
-- Structure de la table `genre`
--

CREATE TABLE `genre` (
  `gen_id` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `genre`
--

INSERT INTO `genre` (`gen_id`, `libelle`) VALUES
(1, 'Folk'),
(2, 'Pop'),
(3, 'Rock'),
(4, 'Reggae');

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

CREATE TABLE `groupe` (
  `gro_id` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `dateCreation` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `melSiteWeb` varchar(255) DEFAULT NULL,
  `siteWeb` varchar(255) DEFAULT NULL,
  `lieuRepetition` varchar(50) DEFAULT NULL,
  `estSelectionne` int(11) DEFAULT NULL,
  `idDispositif` int(11) DEFAULT NULL,
  `idMembre` int(11) DEFAULT NULL,
  `idGenre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`gro_id`, `nom`, `dateCreation`, `telephone`, `melSiteWeb`, `siteWeb`, `lieuRepetition`, `estSelectionne`, `idDispositif`, `idMembre`, `idGenre`) VALUES
(1, 'PNL', '2014-01-01', '02-52-46-21-56', 'spar@gmail.com', NULL, 'Caen', 1, 1, 4, 1),
(2, 'Magic System', '2007-05-02', '02-56-75-84-11', 'bar@gmail.com', NULL, 'Caen', 1, 1, 3, 3),
(3, 'Indila', '2009-02-01', '02-58-69-32-14', 'nar@gmail.com', NULL, 'Caen', 1, 2, 2, 4),
(4, 'Kendji Girac', '2009-02-23', '02-53-43-53-63', 'ban@gmail.com', NULL, 'Caen', 1, 2, 6, 2),
(5, 'Daft Punk', '1993', '02-52-45-14-56', 'aa', 'aa', 'Caen', 1, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `groupemembre`
--

CREATE TABLE `groupemembre` (
  `idGroupe` int(11) NOT NULL,
  `idMembre` int(11) NOT NULL,
  `idInstrument` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupemembre`
--

INSERT INTO `groupemembre` (`idGroupe`, `idMembre`, `idInstrument`) VALUES
(1, 1, 1),
(1, 5, 1),
(2, 2, 1),
(3, 3, 1),
(3, 6, 5),
(4, 4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `instrument`
--

CREATE TABLE `instrument` (
  `ins_id` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `instrument`
--

INSERT INTO `instrument` (`ins_id`, `libelle`) VALUES
(1, 'Flute'),
(2, 'Guitare'),
(3, 'Piano'),
(4, 'Violon'),
(5, 'Clarinette'),
(6, 'Trompette'),
(7, 'Batterie'),
(8, 'Percussions'),
(9, 'Accordeon');

-- --------------------------------------------------------

--
-- Structure de la table `jury`
--

CREATE TABLE `jury` (
  `jur_id` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  `idDispositif` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `jury`
--

INSERT INTO `jury` (`jur_id`, `libelle`, `idDispositif`) VALUES
(1, 'fete', 1);

-- --------------------------------------------------------

--
-- Structure de la table `lieuconcert`
--

CREATE TABLE `lieuconcert` (
  `lie_id` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `codePostal` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lieuconcert`
--

INSERT INTO `lieuconcert` (`lie_id`, `nom`, `ville`, `codePostal`) VALUES
(1, 'Beauregard', 'Caen', '14000'),
(2, 'Leclerc', 'Avranches', '50300'),
(3, 'Inter', 'l\'Aigle', '61300');

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

CREATE TABLE `membre` (
  `mem_id` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `idStatut` int(11) NOT NULL,
  `idInstrument` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `membre`
--

INSERT INTO `membre` (`mem_id`, `nom`, `prenom`, `idStatut`, `idInstrument`) VALUES
(1, 'Ademo', 'Patrick', 2, 1),
(2, 'Martin', 'Charlot', 1, 4),
(3, 'Moineau', 'Ben', 3, 3),
(4, 'Lepretre', 'Jules', 5, 2),
(5, 'Gilbert', 'Tom', 4, 3),
(6, 'EL Musaui', 'While', 5, 5);

-- --------------------------------------------------------

--
-- Structure de la table `partenaire`
--

CREATE TABLE `partenaire` (
  `par_id` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `idJury` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `partenaire`
--

INSERT INTO `partenaire` (`par_id`, `nom`, `prenom`, `idJury`) VALUES
(1, 'Le Cozannet', 'Arnaud', 1),
(4, 'admin', 'admin', 1);

-- --------------------------------------------------------

--
-- Structure de la table `programmer`
--

CREATE TABLE `programmer` (
  `idGroupe` int(11) NOT NULL,
  `IdFestival` int(11) NOT NULL,
  `dateProgrammation` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `programmer`
--

INSERT INTO `programmer` (`idGroupe`, `IdFestival`, `dateProgrammation`) VALUES
(3, 2, '2023-04-23'),
(4, 1, '2023-07-15');

-- --------------------------------------------------------

--
-- Structure de la table `statut`
--

CREATE TABLE `statut` (
  `sta_code` int(11) NOT NULL,
  `libelleStatut` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `statut`
--

INSERT INTO `statut` (`sta_code`, `libelleStatut`) VALUES
(1, 'Intermittant'),
(2, 'Salarié'),
(3, 'Apprenti'),
(4, 'Intérimaire'),
(5, 'Indépendant');

-- --------------------------------------------------------

--
-- Structure de la table `titre`
--

CREATE TABLE `titre` (
  `idGroupe` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `intitule` varchar(50) DEFAULT NULL,
  `duree` time DEFAULT NULL,
  `lienURL` varchar(255) DEFAULT NULL,
  `idAlbum` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `titre`
--

INSERT INTO `titre` (`idGroupe`, `numero`, `intitule`, `duree`, `lienURL`, `idAlbum`) VALUES
(1, 1, 'Le monde ou rien', '04:16:00', 'https://www.youtube.com/embed/umF1kfVujhM', 1),
(1, 2, 'Sur Paname', '04:07:00', 'https://www.youtube.com/embed/xX3qrI_tt8s', 1),
(1, 3, 'Ho lala', '14:02:27', 'https://www.youtube.com/embed/SWEYLpG70AI', 1),
(1, 4, 'J\'vends', '03:50:00', 'https://www.youtube.com/embed/CnlQzDg4WA0', 1),
(1, 5, 'Abonné', '03:37:00', 'https://www.youtube.com/embed/4fYNeUoOsV4', 1),
(1, 6, 'J\'suis PNL', '04:31:00', 'https://www.youtube.com/embed/w7lu-cNnYC8tt8s', 1),
(1, 7, 'Mexico', '04:04:00', 'https://www.youtube.com/embed/LZx6oeNeoWM', 1),
(1, 8, 'Porte de Mesrine', '04:51:00', 'https://www.youtube.com/embed/ip_g9FrrYl0', 1),
(1, 9, 'Dans ta rue', '05:30:00', 'https://www.youtube.com/embed/s9y6iCRyRSE', 1),
(1, 10, 'Laisse', '03:43:00', 'https://www.youtube.com/embed/7bkhectXdrc', 1),
(1, 11, 'Loin des hommes', '02:48:00', 'https://www.youtube.com/embed/LJt31fvGyzM', 1),
(1, 12, 'Le M', '04:10:00', 'https://www.youtube.com/embed/-3kGDdy7LUY', 1),
(1, 13, 'Rebenga', '04:20:00', 'https://www.youtube.com/embed/IF2rNUJILIY', 1),
(1, 14, 'Plus Tony que Sosa', '05:05:00', 'https://www.youtube.com/embed/hLVseW967QA', 1),
(1, 15, 'Que la mif', '04:24:00', 'https://www.youtube.com/embed/FLJBazeyG2M', 1),
(1, 16, 'Tempête', '04:54:00', 'https://www.youtube.com/embed/VtQ0odvF6_s', 1),
(1, 17, 'Dans la soucoupe', '03:47:00', 'https://www.youtube.com/embed/hg8EGC5QaxM', 1),
(2, 18, 'Plémalé Makou', '04:26:00', 'https://www.youtube.com/embed/_uhSYFoI2EY', 2),
(2, 19, 'Petit Hamza (A l\'école)', '04:15:00', 'https://www.youtube.com/embed/KJ0gIPcUsoI', 2),
(2, 20, 'Joyeux anniversaire', '00:00:03', 'https://www.youtube.com/embed/FTO03hN-Xbo', 2),
(2, 21, 'Ambé', '04:51:00', 'https://www.youtube.com/embed/lAqOkg80i70', 2),
(2, 22, 'A nos disparus hommage', '04:28:00', 'https://www.youtube.com/embed/pqCf98hQEe8', 2),
(2, 23, 'Jeunesse politisée feat Mix 1er', '03:44:00', 'https://www.youtube.com/embed/mtaUlNz2rfA', 2),
(2, 24, 'Ambiance Wôyô', '03:40:00', 'https://www.youtube.com/embed/RSUX_f1_c7U', 2),
(2, 25, 'Molo Molo Feat Ipupa', '04:34:00', 'https://www.youtube.com/embed/ndc5OUqUxTw', 2),
(2, 26, 'Pauvre Planteur', '03:45:00', 'https://www.youtube.com/embed/7deOwP2nKXU', 2),
(2, 27, 'Ziaglo', '04:10:00', 'https://www.youtube.com/embed/D0zCSx1cURE', 2),
(2, 28, 'Anoumabo est Joli', '04:16:00', 'https://www.youtube.com/embed/XLFxAwADzjA', 2),
(2, 29, 'Voyager feat Smarty', '03:24:00', 'https://www.youtube.com/embed/Ysi2PQcnlsg', 2),
(3, 26, 'Dernière Danse', '03:35:00', 'https://www.youtube.com/embed/K5KAc5CoCuk', 3),
(3, 27, 'Tourner Dans Le Vide', '04:11:00', 'https://www.youtube.com/embed/vtNJMAyeP0s', 3),
(3, 28, 'Love Story', '04:44:00', 'https://www.youtube.com/embed/DF3XjEhJ40Y', 3),
(3, 29, 'S.O.S', '04:48:00', 'https://www.youtube.com/embed/m65jhGwtWrg', 3),
(3, 30, 'Comme Un Bateau', '04:56:00', 'https://www.youtube.com/embed/HOGQPMmKB7Y', 3),
(3, 31, 'Run Run', '03:46:00', 'https://www.youtube.com/embed/iv5bB40Rxsg', 3),
(3, 32, 'Ego', '04:17:00', 'https://www.youtube.com/embed/fSjg8yrc8s0', 3),
(3, 34, 'Boite En Argent', '04:26:00', 'https://www.youtube.com/embed/G2sVBDyvra0', 3),
(3, 35, 'Tu Ne M\'Entends Pas', '04:26:00', 'https://www.youtube.com/embed/0vdsUyu9XUk', 3),
(3, 36, 'Mini World', '05:10:00', 'https://www.youtube.com/embed/suRElMxSzMU', 3),
(4, 37, 'Habibi', '03:52:00', 'https://www.youtube.com/embed/0iwUQeldVXw', 4),
(4, 38, 'Dernier métro', '03:51:00', 'https://www.youtube.com/embed/Hx4Eor0KS4E', 4),
(4, 39, 'Evidemment', '03:59:00', 'https://www.youtube.com/embed/VHIEznwcqsk', 4),
(4, 40, 'Conquistador', '03:42:00', 'https://www.youtube.com/embed/FrzNo65aTqw', 4),
(4, 41, 'Dans mes bras', '03:17:00', 'https://www.youtube.com/embed/dvItruOSOaE', 4),
(4, 42, 'Yelele', '03:19:00', 'https://www.youtube.com/embed/qWTn0NWWkSA', 4),
(4, 43, 'La Magicienne', '03:36:00', 'https://www.youtube.com/embed/LsbdAYCD5Kw', 4),
(4, 44, 'Bebeto', '03:26:00', 'https://www.youtube.com/embed/lVxawLsN48s', 4),
(4, 45, 'Andale', '03:14:00', 'https://www.youtube.com/embed/9gFvU_ZKuzw', 4),
(4, 46, 'Reggeaton', '03:08:00', 'https://www.youtube.com/embed/24wGW01meug', 4),
(4, 47, 'Oh! Prends mon âme', '04:09:00', 'https://www.youtube.com/embed/HfW_-dWLHcQ', 4),
(4, 48, 'Dans mes bras (Version acoustique)', '03:13:00', 'https://www.youtube.com/embed/Bei9yhJEg7Y', 4),
(4, 49, 'Evidemment (Version acoustique)', '03:51:00', 'https://www.youtube.com/embed/QsFmV1LRnZE', 4),
(4, 50, 'Habibi (Version acoustique)', '03:15:00', 'https://www.youtube.com/embed/lFewflsGkLc', 4),
(4, 51, 'Bebeto - Remix', '03:58:00', 'https://www.youtube.com/embed/GiebTnLdt04', 4),
(4, 52, 'La Gitane - Souvenirs d\'enfance', '03:54:00', 'https://www.youtube.com/embed/kwZSPBIaT-c', 4),
(4, 53, 'Petit papa Noël', '03:50:00', 'https://www.youtube.com/embed/dcRfCZScC6k', 4);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `uti_id` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `idPartenaire` int(11) DEFAULT NULL,
  `idMembre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`uti_id`, `login`, `mdp`, `idPartenaire`, `idMembre`) VALUES
(1, 'elmusaui', '8a82a529f0de37861aae6d3fcc2185c9', NULL, 6),
(2, 'arnaud', '0deb391b38356889e7e5cc31c3d11b92', 1, NULL),
(3, 'admin', 'ec8aa11cc10babc6475e20a05724237f', 4, NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`alb_id`),
  ADD KEY `FK_ALBUM_GROUPE` (`idGroupe`);

--
-- Index pour la table `dispositif`
--
ALTER TABLE `dispositif`
  ADD PRIMARY KEY (`dis_id`);

--
-- Index pour la table `donnerconcert`
--
ALTER TABLE `donnerconcert`
  ADD PRIMARY KEY (`idGroupe`,`idLieuConcert`),
  ADD KEY `FK_DONNERCONCERT_LIEUCONCERT` (`idLieuConcert`);

--
-- Index pour la table `festival`
--
ALTER TABLE `festival`
  ADD PRIMARY KEY (`fes_id`);

--
-- Index pour la table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`gen_id`);

--
-- Index pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD PRIMARY KEY (`gro_id`),
  ADD KEY `FK_GROUPE_GENRE` (`idGenre`),
  ADD KEY `FK_GROUPE_MEMBRE` (`idMembre`),
  ADD KEY `FK_GROUPE_DISPOSITIF` (`idDispositif`);

--
-- Index pour la table `groupemembre`
--
ALTER TABLE `groupemembre`
  ADD PRIMARY KEY (`idGroupe`,`idMembre`,`idInstrument`),
  ADD KEY `FK_GROUPEMEMBRE_MEMBRE` (`idMembre`),
  ADD KEY `FK_GROUPEMEMBRE_INSTRUMENT` (`idInstrument`);

--
-- Index pour la table `instrument`
--
ALTER TABLE `instrument`
  ADD PRIMARY KEY (`ins_id`);

--
-- Index pour la table `jury`
--
ALTER TABLE `jury`
  ADD PRIMARY KEY (`jur_id`),
  ADD KEY `FK_JURY_DISPOSITIF` (`idDispositif`);

--
-- Index pour la table `lieuconcert`
--
ALTER TABLE `lieuconcert`
  ADD PRIMARY KEY (`lie_id`);

--
-- Index pour la table `membre`
--
ALTER TABLE `membre`
  ADD PRIMARY KEY (`mem_id`),
  ADD KEY `FK_MEMBRE_STATUT` (`idStatut`),
  ADD KEY `FK_MEMBRE_INSTRUMENT` (`idInstrument`);

--
-- Index pour la table `partenaire`
--
ALTER TABLE `partenaire`
  ADD PRIMARY KEY (`par_id`),
  ADD KEY `FK_PARTENAIRE_JURY` (`idJury`);

--
-- Index pour la table `programmer`
--
ALTER TABLE `programmer`
  ADD PRIMARY KEY (`idGroupe`,`IdFestival`),
  ADD KEY `FK_PROGRAMMER_FESTIVAL` (`IdFestival`);

--
-- Index pour la table `statut`
--
ALTER TABLE `statut`
  ADD PRIMARY KEY (`sta_code`);

--
-- Index pour la table `titre`
--
ALTER TABLE `titre`
  ADD PRIMARY KEY (`idGroupe`,`numero`),
  ADD KEY `FK_TITRE_ALBUM` (`idAlbum`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`uti_id`),
  ADD KEY `FK_UTILISATEUR_PARTENAIRE` (`idPartenaire`),
  ADD KEY `FK_UTILISATEUR_MEMBRE` (`idMembre`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `album`
--
ALTER TABLE `album`
  MODIFY `alb_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `dispositif`
--
ALTER TABLE `dispositif`
  MODIFY `dis_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `festival`
--
ALTER TABLE `festival`
  MODIFY `fes_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `genre`
--
ALTER TABLE `genre`
  MODIFY `gen_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `groupe`
--
ALTER TABLE `groupe`
  MODIFY `gro_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `instrument`
--
ALTER TABLE `instrument`
  MODIFY `ins_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `jury`
--
ALTER TABLE `jury`
  MODIFY `jur_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `lieuconcert`
--
ALTER TABLE `lieuconcert`
  MODIFY `lie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `membre`
--
ALTER TABLE `membre`
  MODIFY `mem_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `partenaire`
--
ALTER TABLE `partenaire`
  MODIFY `par_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `statut`
--
ALTER TABLE `statut`
  MODIFY `sta_code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `uti_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `FK_ALBUM_GROUPE` FOREIGN KEY (`idGroupe`) REFERENCES `groupe` (`gro_id`);

--
-- Contraintes pour la table `donnerconcert`
--
ALTER TABLE `donnerconcert`
  ADD CONSTRAINT `FK_DONNERCONCERT_GROUPE` FOREIGN KEY (`idGroupe`) REFERENCES `groupe` (`gro_id`),
  ADD CONSTRAINT `FK_DONNERCONCERT_LIEUCONCERT` FOREIGN KEY (`idLieuConcert`) REFERENCES `lieuconcert` (`lie_id`);

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `FK_GROUPE_DISPOSITIF` FOREIGN KEY (`idDispositif`) REFERENCES `dispositif` (`dis_id`),
  ADD CONSTRAINT `FK_GROUPE_GENRE` FOREIGN KEY (`idGenre`) REFERENCES `genre` (`gen_id`),
  ADD CONSTRAINT `FK_GROUPE_MEMBRE` FOREIGN KEY (`idMembre`) REFERENCES `membre` (`mem_id`);

--
-- Contraintes pour la table `groupemembre`
--
ALTER TABLE `groupemembre`
  ADD CONSTRAINT `FK_GROUPEMEMBRE_GROUPE` FOREIGN KEY (`idGroupe`) REFERENCES `groupe` (`gro_id`),
  ADD CONSTRAINT `FK_GROUPEMEMBRE_INSTRUMENT` FOREIGN KEY (`idInstrument`) REFERENCES `instrument` (`ins_id`),
  ADD CONSTRAINT `FK_GROUPEMEMBRE_MEMBRE` FOREIGN KEY (`idMembre`) REFERENCES `membre` (`mem_id`);

--
-- Contraintes pour la table `jury`
--
ALTER TABLE `jury`
  ADD CONSTRAINT `FK_JURY_DISPOSITIF` FOREIGN KEY (`idDispositif`) REFERENCES `dispositif` (`dis_id`);

--
-- Contraintes pour la table `membre`
--
ALTER TABLE `membre`
  ADD CONSTRAINT `FK_MEMBRE_INSTRUMENT` FOREIGN KEY (`idInstrument`) REFERENCES `instrument` (`ins_id`),
  ADD CONSTRAINT `FK_MEMBRE_STATUT` FOREIGN KEY (`idStatut`) REFERENCES `statut` (`sta_code`);

--
-- Contraintes pour la table `partenaire`
--
ALTER TABLE `partenaire`
  ADD CONSTRAINT `FK_PARTENAIRE_JURY` FOREIGN KEY (`idJury`) REFERENCES `jury` (`jur_id`);

--
-- Contraintes pour la table `programmer`
--
ALTER TABLE `programmer`
  ADD CONSTRAINT `FK_PROGRAMMER_FESTIVAL` FOREIGN KEY (`IdFestival`) REFERENCES `festival` (`fes_id`),
  ADD CONSTRAINT `FK_PROGRAMMER_GROUPE` FOREIGN KEY (`idGroupe`) REFERENCES `groupe` (`gro_id`);

--
-- Contraintes pour la table `titre`
--
ALTER TABLE `titre`
  ADD CONSTRAINT `FK_TITRE_ALBUM` FOREIGN KEY (`idAlbum`) REFERENCES `album` (`alb_id`),
  ADD CONSTRAINT `FK_TITRE_GROUPE` FOREIGN KEY (`idGroupe`) REFERENCES `groupe` (`gro_id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK_UTILISATEUR_MEMBRE` FOREIGN KEY (`idMembre`) REFERENCES `membre` (`mem_id`),
  ADD CONSTRAINT `FK_UTILISATEUR_PARTENAIRE` FOREIGN KEY (`idPartenaire`) REFERENCES `partenaire` (`par_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
