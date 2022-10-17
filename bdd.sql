-- phpMyAdmin SQL Dump
-- version 5.0.4deb2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : lun. 17 oct. 2022 à 14:00
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
  `cheminImg` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, 'Papillons de Nuit', '2022', '2022-06-03', '2022-06-05', 'https://freshflavour.fr/wp-content/uploads/2017/04/papillons-de-nuit-logo-e1495268346896.png'),
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
(1, 'Les Spartavies', '2011-01-01', '02-52-46-21-56', 'spar@gmail.com', NULL, 'Caen', 1, 1, 4, 1),
(2, 'Les Barnguys', '2007-05-02', '02-56-75-84-11', 'bar@gmail.com', NULL, 'Caen', 1, 1, 3, 3),
(3, 'Les Narcos', '2009-02-01', '02-58-69-32-14', 'nar@gmail.com', NULL, 'Caen', 1, 2, 2, 4),
(4, 'Banditas', '2009-02-01', '02-53-43-53-63', 'ban@gmail.com', NULL, 'Caen', 1, 2, 1, 2),
(5, 'Static', '2022-06-26', '0652545522', NULL, NULL, NULL, 0, 1, 1, 1);

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
  `mdp` varchar(50) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `idStatut` int(11) NOT NULL,
  `idInstrument` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `membre`
--

INSERT INTO `membre` (`mem_id`, `nom`, `prenom`, `mdp`, `mail`, `idStatut`, `idInstrument`) VALUES
(1, 'Ademo', 'Patrick', NULL, NULL, 2, 1),
(2, 'Martin', 'Charlot', NULL, NULL, 1, 4),
(3, 'Moineau', 'Ben', NULL, NULL, 3, 3),
(4, 'Lepretre', 'Jules', NULL, NULL, 5, 2),
(5, 'Gilbert', 'Tom', NULL, NULL, 4, 3),
(6, 'EL Musaui', 'While', NULL, NULL, 5, 5),
(9, 'a', 'aer', NULL, NULL, 3, 3);

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
(1, 'Le Cozannet', 'Arnaud', 1);

-- --------------------------------------------------------

--
-- Structure de la table `programmer`
--

CREATE TABLE `programmer` (
  `idGroupe` int(11) NOT NULL,
  `IdFestival` int(11) NOT NULL,
  `dateProgrammation` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, 1, 'Bagarre', '14:02:27', 'https://www.google.com/url?sa=t&rct=j&q=&esrc=s&so', 1),
(2, 2, 'Pêche', '14:02:27', 'https://www.youtube.com/watch?v=cIwD6qutv00', 2),
(3, 3, 'Herbe', '14:02:27', 'https://www.youtube.com/watch?v=9TKEZ2I8jWo', 3),
(4, 4, 'Banque', '14:02:27', 'https://vm.tiktok.com/ZMNKFppBJ/', 4);

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
(1, 'elmusaui', 'elmusaui', NULL, 6),
(2, 'arnaud', 'a', 1, NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`alb_id`);

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
ALTER TABLE `dispositif`
  MODIFY `dis_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `album`
--
ALTER TABLE `album`
  MODIFY `alb_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
  MODIFY `mem_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `partenaire`
--
ALTER TABLE `partenaire`
  MODIFY `par_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `statut`
--
ALTER TABLE `statut`
  MODIFY `sta_code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `uti_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

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
