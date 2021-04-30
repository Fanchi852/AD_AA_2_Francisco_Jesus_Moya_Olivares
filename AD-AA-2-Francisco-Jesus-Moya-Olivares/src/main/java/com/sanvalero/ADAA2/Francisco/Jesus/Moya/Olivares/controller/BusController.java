package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.controller;

import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.Bus;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.exception.BusNotFopundException;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.repository.BusRepository;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.service.BusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.controller.Response.NOT_FOUND;

@RestController
@Tag(name = "Autobuses", description = "Listado de autobuses")
public class BusController {

    private final Logger logger = LoggerFactory.getLogger(BusController.class);

    @Autowired
    private BusService busservice;

    @Operation(summary = "Obtiene el listado de productos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de autobuses",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Bus.class)))),
    })
    @GetMapping(value = "/buses", produces = "application/json")
    public ResponseEntity<ArrayList<Bus>> getBuses(){
        logger.info("inicio getBuses");
        logger.info("fin getBuses");
        return new ResponseEntity<>(busservice.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtiene un autobus por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe el autobus", content = @Content(schema = @Schema(implementation = Bus.class))),
            @ApiResponse(responseCode = "404", description = "El autobus no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @GetMapping(value = "/buses/{id}", produces = "application/json")
    public ResponseEntity<Bus> getBus(@PathVariable Integer id) {
        Bus bus = busservice.findById(id)
                .orElseThrow(() -> new BusNotFopundException(id));

        return new ResponseEntity<>(bus, HttpStatus.OK);
    }

    @Operation(summary = "Almacena un autobus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Autobus almacenado", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @PostMapping(value = "/buses", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Bus> addBus(@RequestBody Bus bus){
        logger.info(bus.toString());
        return new ResponseEntity<>(busservice.save(bus), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un autobus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se elimina el autobus", content = @Content(schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "404", description = "El autobus no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @DeleteMapping(value = "/products/{id}", produces = "application/json")
    public ResponseEntity<Response> deleteBus(@PathVariable Integer id) {
        busservice.deleteById(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }


    @ExceptionHandler(BusNotFopundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handleException(BusNotFopundException bnfe) {
        Response response = Response.errorResonse(NOT_FOUND, bnfe.getMessage());
        logger.error(bnfe.getMessage(), bnfe);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }



}
