package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity(name = "Bus_stops")
public class BusStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "Nombre de la parada", example = "Atocha", required = true)
    @NotBlank
    @Column
    private String name;

    @Column
    private Integer seat;

    @Column
    private Float size;

    @Column
    private LocalDate creation;

    @Column
    private Boolean covering;


}
