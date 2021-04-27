package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name="Buss")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String code;
    @Column(name = "double_bus")
    private Boolean doublebus;
    @Column(name = "buy_date")
    private LocalDate buydate;
    @Column
    private Float consumption;
    @Column
    private int capacity;
    @Column
    private int line;

}
