create database voiturespring;
\c voiturespring

drop table societe cascade;
drop table voiture cascade;
drop table kilometrage cascade;
drop table Administrateur cascade;
drop table token cascade;



create table societe(
                        id serial primary key,
                        nom varchar(50),
                        email varchar(50),
                        mdp varchar(50)
);
insert into societe values
    (default,'Aeroflow','Aeroflow','Aeroflow')
;

create table voiture(
                        id serial primary key,
                        idsociete integer,
                        immatriculation varchar(30),

                        marque varchar(30),
                        modele varchar(30),
                        kilometrageentree integer,
                        acquisition date not null
);

select * from voiture;


insert into voiture values
    (default,1,'3355TBB','Kia','Sportage',0,'2022-01-01');
insert into voiture values      (default,1,'1230TAS','Toyota','Hilux',0,'2022-02-01');
insert into voiture values  (default,1,'5004TAP','Toyota','Fortuner',0,'2022-03-21');
insert into voiture values  (default,1,'3971TBD','Chevrolet','Captiva LT',0,'2022-04-12');


create table kilometrage(
                            id serial primary key,
                            idvoiture integer,
                            dateactuel date not null default now(),
                            debutkm integer ,
                            finkm integer
);

insert into kilometrage values
                            (default,1,'2022-01-01',0,150),
                            (default,1,'2022-01-02',150,200),
                            (default,1,'2022-01-03',200,300),
                            (default,1,'2022-01-04',350,500)
;



-- select * from voiture, kilometrage where voiture.id = kilometrage.idvoiture;

-- select voiture.id ,kilometrage.id as idkilometrage,voiture.immatriculation,voiture.modele,kilometrage.debutkm,kilometrage.finkm from voiture, kilometrage where voiture.id = kilometrage.idvoiture and voiture.id = 1;


create table Administrateur(
                               id serial primary key,
                               email varchar(10),
                               psswd varchar(10)
);

insert into Administrateur(id,email,psswd) values (default,'admin','admin');


create table token(
                      id serial primary key,
                      idadmin integer references Administrateur(id),
                      token varchar(200),
                      datecreation date,
                      dateexpiration date
);

insert into token(idadmin,token,datecreation,dateexpiration) values(1,'BLABBLA','2022-10-03','2022-10-05');


select count(*) from token where token='"+token+"' and dateexpiration>current_date;


Create table Assurance_Societe(
                                  id serial primary key not null,
                                  nomsociete varchar(20) not null
);

Insert into Assurance_Societe(nomsociete) values('Aro'),('Havana'),('MAMA');

drop table assurance_voiture cascade ;
Create table Assurance_voiture(
                                  id serial primary key not null,
                                  idvoiture integer not null references voiture(id),
                                  idassurancesociete int not null references Assurance_Societe(id),
                                  date_debut_validite timestamp,
                                  date_fin_validite timestamp
);
Insert into Assurance_voiture(idvoiture,idassurancesociete,date_debut_validite,date_fin_validite) values(1,1,'2022-12-9','2023-4-9');
Insert into Assurance_voiture(idvoiture,idassurancesociete,date_debut_validite,date_fin_validite) values(2,3,'2022-12-12','2023-4-15');
Insert into Assurance_voiture(idvoiture,idassurancesociete,date_debut_validite,date_fin_validite) values(3,2,'2022-12-23','2023-4-24');
Insert into Assurance_voiture(idvoiture,idassurancesociete,date_debut_validite,date_fin_validite) values(4,1,'2022-12-11','2023-4-12');
Insert into Assurance_voiture(idvoiture,idassurancesociete,date_debut_validite,date_fin_validite) values(4,1,'2022-12-11','2022-11-12');



select * from voiture

create or replace view assuranceVoiture as
select av.id as idassurance, voiture.id as idvoiture,idsociete, immatriculation,marque,modele,
       date_fin_validite, assc.nomsociete from voiture
           join Assurance_voiture Av on voiture.id = Av.idvoiture
           join Assurance_Societe assC on Av.idassurancesociete = assc.id;




select
    assurancev0_.idassurance as idassura1_1_,
    assurancev0_.date_fin_validite as date_fin2_1_,
    assurancev0_.idsociete as idsociet3_1_,
    assurancev0_.idvoiture as idvoitur4_1_,
    assurancev0_.immatriculation as immatric5_1_,
    assurancev0_.marque as marque6_1_,
    assurancev0_.modele as modele7_1_,
    assurancev0_.nomsociete as nomsocie8_1_
from
    assurancevoiture assurancev0_
where
    assurancev0_.date_fin_validite between '2022-10-12 00:00:00.0' and
        '2022-12-12 00:00:00.0'



select
    assurancev0_.idassurance as idassura1_1_,
    assurancev0_.date_fin_validite as date_fin2_1_,
    assurancev0_.idsociete as idsociet3_1_,
    assurancev0_.idvoiture as idvoitur4_1_,
    assurancev0_.immatriculation as immatric5_1_,
    assurancev0_.marque as marque6_1_,
    assurancev0_.modele as modele7_1_,
    assurancev0_.nomsociete as nomsocie8_1_
from
    assurancevoiture assurancev0_
where
    assurancev0_.date_fin_validite between '2022-12-12 00:00:00.0' and '2023-01-12 00:00:00.0'
