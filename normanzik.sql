-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : lun. 26 sep. 2022 à 14:02
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `normanzik`
--

-- --------------------------------------------------------

--
-- Structure de la table `album`
--

DROP TABLE IF EXISTS `album`;
CREATE TABLE IF NOT EXISTS `album` (
  `alb_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `dateCreation` date DEFAULT NULL,
  `cheminImg` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`alb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `album`
--

INSERT INTO `album` (`alb_id`, `nom`, `dateCreation`, `cheminImg`) VALUES
(1, 'Le monde chico', '2009-01-22', NULL),
(2, 'Envolée Zougloutique', '2009-01-22', NULL),
(3, 'Mini World', '2007-03-14', NULL),
(4, 'Mi Vida', '2020-01-22', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `dispositif`
--

DROP TABLE IF EXISTS `dispositif`;
CREATE TABLE IF NOT EXISTS `dispositif` (
  `dis_id` int(11) NOT NULL AUTO_INCREMENT,
  `annee` int(11) DEFAULT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dis_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `donnerconcert`;
CREATE TABLE IF NOT EXISTS `donnerconcert` (
  `idGroupe` int(11) NOT NULL,
  `idLieucConcert` int(11) NOT NULL,
  `dateConcert` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idGroupe`,`idLieucConcert`),
  KEY `FK_DONNERCONCERT_LIEUCONCERT` (`idLieucConcert`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `donnerconcert`
--

INSERT INTO `donnerconcert` (`idGroupe`, `idLieucConcert`, `dateConcert`) VALUES
(1, 1, '2022-05-31'),
(2, 1, '2022-08-19'),
(3, 1, '2022-02-21'),
(4, 1, '2022-12-25');

-- --------------------------------------------------------

--
-- Structure de la table `genre`
--

DROP TABLE IF EXISTS `genre`;
CREATE TABLE IF NOT EXISTS `genre` (
  `gen_id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`gen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `gro_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `dateCreation` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `melSiteWeb` varchar(50) DEFAULT NULL,
  `lieuReception` varchar(50) DEFAULT NULL,
  `estSelectionne` int(11) DEFAULT NULL,
  `idDispositif` int(11) NOT NULL,
  `idMembre` int(11) NOT NULL,
  `idGenre` int(11) NOT NULL,
  PRIMARY KEY (`gro_id`),
  KEY `FK_GROUPE_DISPOSITIF` (`idDispositif`),
  KEY `FK_GROUPE_GENRE` (`idGenre`),
  KEY `FK_GROUPE_MEMBRE` (`idMembre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`gro_id`, `nom`, `dateCreation`, `telephone`, `melSiteWeb`, `lieuReception`, `estSelectionne`, `idDispositif`, `idMembre`, `idGenre`) VALUES
(1, 'Les Spartavies', '2011-01-01', '02-52-46-21-56', 'spar@gmail.com', 'Caen', 1, 1, 4, 1),
(2, 'Les Barnguys', '2007-05-02', '02-56-75-84-11', 'bar@gmail.com', 'Caen', 1, 1, 3, 3),
(3, 'Les Narcos', '2009-02-01', '02-58-69-32-14', 'nar@gmail.com', 'Caen', 1, 2, 2, 4),
(4, 'Banditas', '2009-02-01', '02-53-43-53-63', 'ban@gmail.com', 'Caen', 1, 2, 1, 2),
(5, 'Static', '2022-06-26', '0652545522', NULL, NULL, 0, 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `groupemembre`
--

DROP TABLE IF EXISTS `groupemembre`;
CREATE TABLE IF NOT EXISTS `groupemembre` (
  `idGroupe` int(11) NOT NULL,
  `idMembre` int(11) NOT NULL,
  PRIMARY KEY (`idGroupe`,`idMembre`),
  KEY `FK_GROUPEMEMBRE_MEMBRE` (`idMembre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupemembre`
--

INSERT INTO `groupemembre` (`idGroupe`, `idMembre`) VALUES
(1, 1),
(1, 5),
(2, 2),
(3, 3),
(4, 4);

-- --------------------------------------------------------

--
-- Structure de la table `instrument`
--

DROP TABLE IF EXISTS `instrument`;
CREATE TABLE IF NOT EXISTS `instrument` (
  `ins_id` int(5) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ins_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

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
-- Structure de la table `lieuconcert`
--

DROP TABLE IF EXISTS `lieuconcert`;
CREATE TABLE IF NOT EXISTS `lieuconcert` (
  `lie_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `codePostal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`lie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `membre`;
CREATE TABLE IF NOT EXISTS `membre` (
  `mem_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `idInstrument` int(5) NOT NULL,
  `idStatut` varchar(50) NOT NULL,
  PRIMARY KEY (`mem_id`),
  KEY `FK_MEMBRE_INSTRUMENT` (`idInstrument`),
  KEY `FK_MEMBRE_STATUT` (`idStatut`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `membre`
--

INSERT INTO `membre` (`mem_id`, `nom`, `prenom`, `idInstrument`, `idStatut`) VALUES
(1, 'Ademo', 'Patrick', 1, '2'),
(2, 'Martin', 'Charlot', 4, '1'),
(3, 'Moineau', 'Ben', 3, '3'),
(4, 'Lepretre', 'Jules', 2, '5'),
(5, 'Gilbert', 'Tom', 3, '4'),
(6, 'EL Musaui', 'While', 5, '5');

-- --------------------------------------------------------

--
-- Structure de la table `statut`
--

DROP TABLE IF EXISTS `statut`;
CREATE TABLE IF NOT EXISTS `statut` (
  `sta_code` varchar(5) NOT NULL,
  `libelleStatut` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sta_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `statut`
--

INSERT INTO `statut` (`sta_code`, `libelleStatut`) VALUES
('1', 'Intermittant'),
('2', 'Salarié'),
('3', 'Apprenti'),
('4', 'Intérimaire'),
('5', 'Indépendant');

-- --------------------------------------------------------

--
-- Structure de la table `titre`
--

DROP TABLE IF EXISTS `titre`;
CREATE TABLE IF NOT EXISTS `titre` (
  `idGroupe` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `intitule` varchar(50) DEFAULT NULL,
  `duree` int(11) DEFAULT NULL,
  `lienURL` varchar(50) DEFAULT NULL,
  `idAlbum` int(11) NOT NULL,
  PRIMARY KEY (`idGroupe`,`numero`),
  KEY `FK_Titre_Membre` (`idAlbum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `titre`
--

INSERT INTO `titre` (`idGroupe`, `numero`, `intitule`, `duree`, `lienURL`, `idAlbum`) VALUES
(1, 1, 'Bagarre', 250, 'https://www.google.com/url?sa=t&rct=j&q=&esrc=s&so', 1),
(2, 2, 'Pêche', 180, 'https://www.youtube.com/watch?v=cIwD6qutv00', 2),
(3, 3, 'Herbe', 300, 'https://www.youtube.com/watch?v=9TKEZ2I8jWo', 3),
(4, 4, 'Banque', 206, 'https://vm.tiktok.com/ZMNKFppBJ/', 4);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `donnerconcert`
--
ALTER TABLE `donnerconcert`
  ADD CONSTRAINT `FK_DONNERCONCERT_GROUPE` FOREIGN KEY (`idGroupe`) REFERENCES `groupe` (`gro_id`),
  ADD CONSTRAINT `FK_DONNERCONCERT_LIEUCONCERT` FOREIGN KEY (`idLieucConcert`) REFERENCES `lieuconcert` (`lie_id`);

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
  ADD CONSTRAINT `FK_GROUPEMEMBRE_MEMBRE` FOREIGN KEY (`idMembre`) REFERENCES `membre` (`mem_id`);

--
-- Contraintes pour la table `membre`
--
ALTER TABLE `membre`
  ADD CONSTRAINT `FK_MEMBRE_INSTRUMENT` FOREIGN KEY (`idInstrument`) REFERENCES `instrument` (`ins_id`),
  ADD CONSTRAINT `FK_MEMBRE_STATUT` FOREIGN KEY (`idStatut`) REFERENCES `statut` (`sta_code`);

--
-- Contraintes pour la table `titre`
--
ALTER TABLE `titre`
  ADD CONSTRAINT `FK_TITRE_GROUPE` FOREIGN KEY (`idGroupe`) REFERENCES `groupe` (`gro_id`),
  ADD CONSTRAINT `FK_Titre_Membre` FOREIGN KEY (`idAlbum`) REFERENCES `album` (`alb_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
