package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "Lines")
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Float size;

    @Column
    private Boolean acctive;

    @Column
    private LocalDate creation;

    @Column
    private String color;

}
