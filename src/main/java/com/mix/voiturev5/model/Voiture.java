package com.mix.voiturev5.model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "voiture")
@Data
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "idsociete")

    int idsociete;
    String immatriculation;
    String marque;
    String modele;
    int kilometrageentree;
    java.sql.Date acquisition;
}