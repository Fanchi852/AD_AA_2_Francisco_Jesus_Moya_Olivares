package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "Bus_stops")
public class BusStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int seat;
    @Column
    private Float size;
    @Column
    private LocalDate creation;
    @Column
    private Boolean covering;


}
