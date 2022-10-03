CREATE TABLE dispositif(
   dis_id INT,
   annee INT,
   libelle VARCHAR(50),
   PRIMARY KEY(dis_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE genre(
   gen_id INT NOT NULL AUTO_INCREMENT,
   libelle VARCHAR(50),
   PRIMARY KEY(gen_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE instrument(
   ins_id INT AUTO_INCREMENT,
   libelle VARCHAR(50),
   PRIMARY KEY(ins_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE statut(
   sta_code INT AUTO_INCREMENT,
   libelleStatut VARCHAR(50),
   PRIMARY KEY(sta_code)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE lieuconcert(
   lie_id INT AUTO_INCREMENT,
   nom VARCHAR(50),
   ville VARCHAR(50),
   codePostal VARCHAR(50),
   PRIMARY KEY(lie_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Album(
   alb_id INT NOT NULL AUTO_INCREMENT,
   nom VARCHAR(50),
   dateCreation DATE,
   cheminImg VARCHAR(200),
   PRIMARY KEY(alb_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Jury(
   jur_id INT AUTO_INCREMENT,
   libelle VARCHAR(50),
   idDispositif INT NOT NULL,
   PRIMARY KEY(jur_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Festival(
   fes_id INT AUTO_INCREMENT,
   nom VARCHAR(50),
   annee VARCHAR(50),
   dateDebut DATE,
   dateFin DATE,
   logo VARCHAR(255),
   PRIMARY KEY(fes_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Partenaire(
   par_id INT AUTO_INCREMENT,
   nom VARCHAR(50),
   prenom VARCHAR(50),
   mdp VARCHAR(50),
   mail VARCHAR(255),
   idJury INT NOT NULL,
   PRIMARY KEY(par_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Membre(
   mem_id INT AUTO_INCREMENT,
   nom VARCHAR(50),
   prenom VARCHAR(50),
   mdp VARCHAR(50),
   mail VARCHAR(255),
   idStatut INT NOT NULL,
   idInstrument INT,
   PRIMARY KEY(mem_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Groupe(
   gro_id INT AUTO_INCREMENT,
   nom VARCHAR(50),
   dateCreation varchar(50),
   telephone VARCHAR(50),
   melSiteWeb VARCHAR(255),
   siteWeb VARCHAR(255) DEFAULT NULL,
   lieuRepetition VARCHAR(50),
   estSelectionne INT,
   idDispositif INT,
   idMembre INT,
   idGenre INT,
   PRIMARY KEY(gro_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Titre(
   idGroupe INT,
   numero INT,
   intitule VARCHAR(50),
   duree TIME,
   lienURL VARCHAR(255),
   idAlbum INT,
   PRIMARY KEY(idGroupe, numero)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE groupemembre(
   idGroupe INT,
   idMembre INT,
   idInstrument INT,
   PRIMARY KEY(idGroupe, idMembre, idInstrument)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE donnerconcert(
   idGroupe INT,
   idLieuConcert INT,
   dateConcert varchar(50),
   PRIMARY KEY(idGroupe, idLieuConcert)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Programmer(
   idGroupe INT,
   IdFestival INT,
   dateProgrammation DATE,
   PRIMARY KEY(idGroupe, IdFestival)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `album` (`alb_id`, `nom`, `dateCreation`, `cheminImg`) VALUES
(1, 'Le monde chico', '2009-01-22', NULL),
(2, 'Envolée Zougloutique', '2009-01-22', NULL),
(3, 'Mini World', '2007-03-14', NULL),
(4, 'Mi Vida', '2020-01-22', NULL);

INSERT INTO `dispositif` (`dis_id`, `annee`, `libelle`) VALUES
(1, 2021, 'Normanzik'),
(2, 2022, 'Norzik');

INSERT INTO `donnerconcert` (`idGroupe`, `idLieuConcert`, `dateConcert`) VALUES
(1, 1, '2022-05-31'),
(2, 1, '2022-08-19'),
(3, 1, '2022-02-21'),
(4, 1, '2022-12-25');

INSERT INTO `genre` (`gen_id`, `libelle`) VALUES
(1, 'Folk'),
(2, 'Pop'),
(3, 'Rock'),
(4, 'Reggae');

INSERT INTO `groupe` (`gro_id`, `nom`, `dateCreation`, `telephone`, `melSiteWeb`, `lieuRepetition`, `estSelectionne`, `idDispositif`, `idMembre`, `idGenre`) VALUES
(1, 'Les Spartavies', '2011-01-01', '02-52-46-21-56', 'spar@gmail.com', 'Caen', 1, 1, 4, 1),
(2, 'Les Barnguys', '2007-05-02', '02-56-75-84-11', 'bar@gmail.com', 'Caen', 1, 1, 3, 3),
(3, 'Les Narcos', '2009-02-01', '02-58-69-32-14', 'nar@gmail.com', 'Caen', 1, 2, 2, 4),
(4, 'Banditas', '2009-02-01', '02-53-43-53-63', 'ban@gmail.com', 'Caen', 1, 2, 1, 2),
(5, 'Static', '2022-06-26', '0652545522', NULL, NULL, 0, 1, 1, 1);

INSERT INTO `groupemembre` (`idGroupe`, `idMembre`, `idInstrument`) VALUES
(1, 1, 1),
(1, 5, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 1);

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

INSERT INTO `lieuconcert` (`lie_id`, `nom`, `ville`, `codePostal`) VALUES
(1, 'Beauregard', 'Caen', '14000'),
(2, 'Leclerc', 'Avranches', '50300'),
(3, 'Inter', "l'Aigle", '61300');

INSERT INTO `membre` (`mem_id`, `nom`, `prenom`, `idInstrument`, `idStatut`) VALUES
(1, 'Ademo', 'Patrick', 1, '2'),
(2, 'Martin', 'Charlot', 4, '1'),
(3, 'Moineau', 'Ben', 3, '3'),
(4, 'Lepretre', 'Jules', 2, '5'),
(5, 'Gilbert', 'Tom', 3, '4'),
(6, 'EL Musaui', 'While', 5, '5');

INSERT INTO `statut` (`sta_code`, `libelleStatut`) VALUES
('1', 'Intermittant'),
('2', 'Salarié'),
('3', 'Apprenti'),
('4', 'Intérimaire'),
('5', 'Indépendant');

INSERT INTO `titre` (`idGroupe`, `numero`, `intitule`, `duree`, `lienURL`, `idAlbum`) VALUES
(1, 1, 'Bagarre', '14:02:27', 'https://www.google.com/url?sa=t&rct=j&q=&esrc=s&so', 1),
(2, 2, 'Pêche', '14:02:27', 'https://www.youtube.com/watch?v=cIwD6qutv00', 2),
(3, 3, 'Herbe', '14:02:27', 'https://www.youtube.com/watch?v=9TKEZ2I8jWo', 3),
(4, 4, 'Banque', '14:02:27', 'https://vm.tiktok.com/ZMNKFppBJ/', 4);

ALTER TABLE Jury
ADD CONSTRAINT FK_JURY_DISPOSITIF FOREIGN KEY(idDispositif) REFERENCES Dispositif(dis_id);

ALTER TABLE Partenaire
ADD CONSTRAINT FK_PARTENAIRE_JURY FOREIGN KEY(idJury) REFERENCES Jury(jur_id);

ALTER TABLE Membre
ADD CONSTRAINT FK_MEMBRE_STATUT FOREIGN KEY(idStatut) REFERENCES Statut(sta_code),
ADD CONSTRAINT FK_MEMBRE_INSTRUMENT FOREIGN KEY(idInstrument) REFERENCES Instrument(ins_id);

ALTER TABLE Groupe
ADD CONSTRAINT FK_GROUPE_GENRE FOREIGN KEY(idGenre) REFERENCES genre(gen_id),
ADD CONSTRAINT FK_GROUPE_MEMBRE FOREIGN KEY(idMembre) REFERENCES Membre(mem_id),
ADD CONSTRAINT FK_GROUPE_DISPOSITIF FOREIGN KEY(idDispositif) REFERENCES Dispositif(dis_id);

ALTER TABLE Titre
ADD CONSTRAINT FK_TITRE_GROUPE FOREIGN KEY(idGroupe) REFERENCES Groupe(gro_id),
ADD CONSTRAINT FK_TITRE_ALBUM FOREIGN KEY(idAlbum) REFERENCES Album(alb_id);

ALTER TABLE groupemembre
ADD CONSTRAINT FK_GROUPEMEMBRE_GROUPE FOREIGN KEY(idGroupe) REFERENCES Groupe(gro_id),
ADD CONSTRAINT FK_GROUPEMEMBRE_MEMBRE FOREIGN KEY(idMembre) REFERENCES Membre(mem_id),
ADD CONSTRAINT FK_GROUPEMEMBRE_INSTRUMENT FOREIGN KEY(idInstrument) REFERENCES Instrument(ins_id);

ALTER TABLE donnerconcert
ADD CONSTRAINT FK_DONNERCONCERT_GROUPE FOREIGN KEY(idGroupe) REFERENCES Groupe(gro_id),
ADD CONSTRAINT FK_DONNERCONCERT_LIEUCONCERT FOREIGN KEY(idLieuConcert) REFERENCES LieuConcert(lie_id);

ALTER TABLE Programmer
ADD CONSTRAINT FK_PROGRAMMER_GROUPE FOREIGN KEY(idGroupe) REFERENCES Groupe(gro_id),
ADD CONSTRAINT FK_PROGRAMMER_FESTIVAL FOREIGN KEY(IdFestival) REFERENCES Festival(fes_id);