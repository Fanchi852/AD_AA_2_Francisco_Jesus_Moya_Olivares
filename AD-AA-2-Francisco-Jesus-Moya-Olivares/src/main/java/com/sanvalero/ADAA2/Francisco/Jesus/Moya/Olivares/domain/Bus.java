package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Buss")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String code;

    @Column(name = "double_bus")
    private Boolean doublebus;

    @Column(name = "buy_date")
    private LocalDate buydate;

    @Column
    private Float consumption;

    @Column
    private Integer capacity;

    @Column
    private Integer line;

}
