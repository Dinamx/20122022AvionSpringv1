-- create database avionwebservice;
-- \c avionwebservice

-- drop table societe cascade;
-- drop table avion cascade;
-- drop table kilometrage cascade;
-- drop table Administrateur cascade;
-- drop table token cascade;
--


create table societe(
                        id serial primary key,
                        nom varchar(50),
                        email varchar(50),
                        mdp varchar(50)
);
insert into societe values
    (default,'airmad','airmad','airmad')
;

create table avion(
                        id serial primary key,
                        idsociete integer references societe(id),
                        immatriculation varchar(30),
                        marque varchar(30),
                        modele varchar(30),
                        kilometrageentree integer,
                        imageAvion text default 'img.jpg'
);


INSERT INTO avion (idsociete, immatriculation, marque, modele, kilometrageentree, imageAvion)
VALUES (1, 'N123456', 'Boeing', '737', 10000,default),
       (1, 'N234567', 'Airbus', 'A320', 20000, default),
       (1, 'N345678', 'Boeing', '747', 30000, default),
       (1, 'N456789', 'Embraer', 'E190', 40000, default),
       (1, 'N567890', 'Airbus', 'A330', 50000, default);


select * from avion;




create table kilometrage(
                            id serial primary key,
                            idavion integer references avion(id),
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



-- select * from avion, kilometrage where avion.id = kilometrage.idavion;

-- select avion.id ,kilometrage.id as idkilometrage,avion.immatriculation,avion.modele,kilometrage.debutkm,kilometrage.finkm from avion, kilometrage where avion.id = kilometrage.idavion and avion.id = 1;


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

-- insert into token(idadmin,token,datecreation,dateexpiration) values(1,'BLABBLA','2022-10-03','2022-10-05');


select count(*) from token where token='"+token+"' and dateexpiration>current_date;


Create table Assurance_Societe(
                                  id serial primary key not null,
                                  nomsociete varchar(20) not null
);

Insert into Assurance_Societe(nomsociete) values('Aro'),('Havana'),('MAMA');

drop table assurance_avion cascade ;
Create table Assurance_avion(
                                  id serial primary key not null,
                                  idavion integer not null references avion(id),
                                  idassurancesociete int not null references Assurance_Societe(id),
                                  date_debut_validite timestamp,
                                  date_fin_validite timestamp
);
Insert into Assurance_avion(idavion,idassurancesociete,date_debut_validite,date_fin_validite) values(1,1,'2022-12-9','2023-4-9');
Insert into Assurance_avion(idavion,idassurancesociete,date_debut_validite,date_fin_validite) values(2,3,'2022-12-12','2023-4-15');
Insert into Assurance_avion(idavion,idassurancesociete,date_debut_validite,date_fin_validite) values(3,2,'2022-12-23','2023-4-24');
Insert into Assurance_avion(idavion,idassurancesociete,date_debut_validite,date_fin_validite) values(3,2,'2022-12-23','2023-4-24');
Insert into Assurance_avion(idavion,idassurancesociete,date_debut_validite,date_fin_validite) values(4,1,'2022-12-11','2023-4-12');
Insert into Assurance_avion(idavion,idassurancesociete,date_debut_validite,date_fin_validite) values(4,1,'2022-12-11','2022-11-12');




create or replace view assuranceDetail as
select a.id , a.modele,a.marque,a.immatriculation,Assurance_avion.date_debut_validite
     ,Assurance_avion.date_fin_validite,"AS".nomsociete  from assurance_avion
         join Assurance_Societe "AS" on "AS".id = Assurance_avion.idassurancesociete
         join avion a on Assurance_avion.idavion = a.id

drop view kilometrageDetail;
create or replace view kilometrageDetail as
select kilometrage.id, a.id as idavion,a.immatriculation,a.marque,a.modele,kilometrage.debutkm, kilometrage.finkm,kilometrage.dateactuel from kilometrage join avion a on a.id = kilometrage.idavion;


select * from kilometrageDetail;


-- create or replace view assuranceVoiture as
-- select av.id as idassurance, avion.id as idavion,idsociete, immatriculation,marque,modele,
--        date_fin_validite, assc.nomsociete from avion
--            join Assurance_avion Av on avion.id = Av.idavion
--            join Assurance_Societe assC on Av.idassurancesociete = assc.id;
--



