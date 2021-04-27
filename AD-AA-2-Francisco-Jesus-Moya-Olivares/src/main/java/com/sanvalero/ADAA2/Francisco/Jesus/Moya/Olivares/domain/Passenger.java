package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "Passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Boolean premium;
    @Column(name = "inscription_date")
    private LocalDate inscriptiondate;
    @Column
    private String name;
    @Column
    private int edad;
    @Column(name = "distance_between_home_Stopbus")
    private Float distancebetweenhomestopbus;

}
