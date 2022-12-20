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
                        imageAvion text default 'data:image/jpeg;base64,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'
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
         join avion a on Assurance_avion.idavion = a.id;

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



