/*
SQLyog Community v11.51 (32 bit)
MySQL - 5.6.17 : Database - rezervacijaprostora
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rezervacijaprostora` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `rezervacijaprostora`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `AdministratorID` int(20) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(20) DEFAULT NULL,
  `Prezime` varchar(20) DEFAULT NULL,
  `KorisnickoIme` varchar(20) DEFAULT NULL,
  `Sifra` varchar(20) DEFAULT NULL,
  `Ulogovan` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`AdministratorID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `administrator` */

insert  into `administrator`(`AdministratorID`,`Ime`,`Prezime`,`KorisnickoIme`,`Sifra`,`Ulogovan`) values (1,'Aleksandar','Kandic','aco','aco','Offline'),(2,'Admin','Admin','admin','admin','Offline'),(3,'Vladan','Kandic','vlado','vlado','Offline');

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `KorisnikID` int(10) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(20) DEFAULT NULL,
  `Prezime` varchar(20) DEFAULT NULL,
  `DatumRodjenja` date DEFAULT NULL,
  `Kontakt` varchar(15) DEFAULT NULL,
  `Mail` varchar(30) DEFAULT NULL,
  `Ulica` varchar(50) DEFAULT NULL,
  `Broj` varchar(20) DEFAULT NULL,
  `Ptt` int(10) DEFAULT NULL,
  PRIMARY KEY (`KorisnikID`),
  KEY `Ptt` (`Ptt`),
  CONSTRAINT `korisnik_ibfk_1` FOREIGN KEY (`Ptt`) REFERENCES `mesto` (`Ptt`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `korisnik` */

insert  into `korisnik`(`KorisnikID`,`Ime`,`Prezime`,`DatumRodjenja`,`Kontakt`,`Mail`,`Ulica`,`Broj`,`Ptt`) values (1,'Aco','Kandic','1993-04-16','0643039461','acokandic@gmail.com','Vozdovacka','5',11000),(4,'Marko','Kandic','1998-04-23','066/199997','marko@gmail.com','Vozdovacka','5',88280),(5,'Sasa','Losic','1989-05-05','065792279','sasa.losic@gmail.com','Makedonska','21',11000),(11,'Milan','Mikic','1981-02-02','064/303-9461','milan@gmail.com','Zmaj Jovina','55',22330),(14,'Sava','Raskovic','1989-02-02','06425782585','sava@gmail.com','Kirina','65',24000),(15,'Vladan','Kandic','1996-04-13','066847177','vladan@gmai.com','Radomira Markovica','15',11000),(17,'Dejan','Kandic','1994-12-12','066367377','dejan@gmail.com','Vozdovacka','5',88280);

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `Ptt` int(10) NOT NULL,
  `Naziv` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mesto` */

insert  into `mesto`(`Ptt`,`Naziv`) values (11000,'Beograd'),(21000,'Novi Sad'),(22330,'Nova Pazova'),(24000,'Subotica'),(88280,'Nevesinje');

/*Table structure for table `prostorija` */

DROP TABLE IF EXISTS `prostorija`;

CREATE TABLE `prostorija` (
  `ProstorijaID` int(20) NOT NULL,
  `NazivProstorije` varchar(30) NOT NULL,
  `Kapacitet` int(4) NOT NULL,
  `Cena` decimal(10,0) NOT NULL,
  PRIMARY KEY (`ProstorijaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `prostorija` */

insert  into `prostorija`(`ProstorijaID`,`NazivProstorije`,`Kapacitet`,`Cena`) values (1,'Velika event sala',120,'90'),(2,'Mala event sala',50,'65'),(3,'Velika konferencijska sala',20,'40'),(4,'Mala konferencijska sala',8,'20'),(5,'Skype soba',2,'5');

/*Table structure for table `rezervacija` */

DROP TABLE IF EXISTS `rezervacija`;

CREATE TABLE `rezervacija` (
  `RezervacijaID` int(20) NOT NULL,
  `DatumRezervacije` date DEFAULT NULL,
  `KorisnikID` int(10) DEFAULT NULL,
  PRIMARY KEY (`RezervacijaID`),
  KEY `KorisnikID` (`KorisnikID`),
  CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`KorisnikID`) REFERENCES `korisnik` (`KorisnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rezervacija` */

insert  into `rezervacija`(`RezervacijaID`,`DatumRezervacije`,`KorisnikID`) values (1,'2015-02-08',11),(2,'2018-08-08',1),(3,'2015-08-02',1),(5,'2015-02-02',11),(6,'2016-12-15',4),(7,'2016-12-06',14),(8,'2016-06-21',14),(9,'2016-06-22',14);

/*Table structure for table `stavkarezervacije` */

DROP TABLE IF EXISTS `stavkarezervacije`;

CREATE TABLE `stavkarezervacije` (
  `RezervacijaID` int(20) NOT NULL,
  `RedniBrojStavke` int(20) NOT NULL,
  `VremeOd` time DEFAULT NULL,
  `VremeDo` time DEFAULT NULL,
  `Iznos` decimal(10,0) DEFAULT NULL,
  `ProstorijaID` int(20) DEFAULT NULL,
  PRIMARY KEY (`RezervacijaID`,`RedniBrojStavke`),
  KEY `ProstorijaID` (`ProstorijaID`),
  CONSTRAINT `stavkarezervacije_ibfk_2` FOREIGN KEY (`ProstorijaID`) REFERENCES `prostorija` (`ProstorijaID`),
  CONSTRAINT `stavkarezervacije_ibfk_3` FOREIGN KEY (`RezervacijaID`) REFERENCES `rezervacija` (`RezervacijaID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stavkarezervacije` */

insert  into `stavkarezervacije`(`RezervacijaID`,`RedniBrojStavke`,`VremeOd`,`VremeDo`,`Iznos`,`ProstorijaID`) values (1,1,'12:00:00','14:00:00','80',3),(1,2,'14:00:00','20:00:00','540',1),(2,1,'09:00:00','11:00:00','180',1),(2,2,'12:00:00','15:00:00','15',5),(3,1,'12:00:00','17:00:00','450',1),(3,2,'19:00:00','20:00:00','90',1),(5,1,'12:00:00','13:00:00','40',3),(6,1,'00:00:00','01:00:00','90',1),(7,1,'07:00:00','10:00:00','270',1),(8,1,'00:00:00','05:00:00','200',3),(9,1,'14:00:00','15:00:00','20',4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
