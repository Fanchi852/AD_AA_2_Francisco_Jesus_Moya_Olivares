package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.controller;


import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.Bus;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.BusStopsLinesRelation;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.exception.BusNotFopundException;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.exception.BusStopsLinesRelationNotFopundException;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.service.BusStopsLinesRelationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.controller.Response.NOT_FOUND;

public class BusStopsLinesRelationController {

    private final Logger logger = LoggerFactory.getLogger(BusStopsLinesRelationController.class);

    @Autowired
    private BusStopsLinesRelationService busstopslinesrelationservice;

    @Operation(summary = "Obtiene el listado de relaciones entre autobuses y lineas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de relaciones entre autobuses y lineas",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = BusStopsLinesRelation.class)))),
    })
    @GetMapping(value = "/busstopslinesrelations", produces = "application/json")
    public ResponseEntity<ArrayList<BusStopsLinesRelation>> getBusStopsLinesRelation(){
        logger.info("inicio get");
        logger.info("fin get");
        return new ResponseEntity<>(busstopslinesrelationservice.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtiene una relacione entre autobuses y lineas por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe la relacione entre autobuses y lineas", content = @Content(schema = @Schema(implementation = BusStopsLinesRelation.class))),
            @ApiResponse(responseCode = "404", description = "La relacione entre autobuses y lineas no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @GetMapping(value = "/busstopslinesrelations/{id}", produces = "application/json")
    public ResponseEntity<BusStopsLinesRelation> getBusStopsLinesRelation(@PathVariable Integer id) {
        BusStopsLinesRelation busstopslinesrelation = busstopslinesrelationservice.findById(id)
                .orElseThrow(() -> new BusStopsLinesRelationNotFopundException(id));

        return new ResponseEntity<>(busstopslinesrelation, HttpStatus.OK);
    }

    @Operation(summary = "Almacena una relacione entre autobuses y lineas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "una relacione entre autobuses y lineas almacenada", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @PostMapping(value = "/busstopslinesrelations", produces = "application/json", consumes = "application/json")
    public ResponseEntity<BusStopsLinesRelation> addBusStopsLinesRelation(@RequestBody BusStopsLinesRelation busstopslinesrelation){
        logger.info(busstopslinesrelation.toString());
        return new ResponseEntity<>(busstopslinesrelationservice.save(busstopslinesrelation), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina una relacione entre autobuses y lineas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se elimina la relacione entre autobuses y lineas", content = @Content(schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "404", description = "La relacione entre autobuses y lineas no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @DeleteMapping(value = "/busstopslinesrelations/{id}", produces = "application/json")
    public ResponseEntity<Response> deleteBusStopsLinesRelation(@PathVariable Integer id) {
        busstopslinesrelationservice.deleteById(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }


    @ExceptionHandler(BusStopsLinesRelationNotFopundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handleException(BusStopsLinesRelationNotFopundException bsjrnfe) {
        Response response = Response.errorResonse(NOT_FOUND, bsjrnfe.getMessage());
        logger.error(bsjrnfe.getMessage(), bsjrnfe);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
