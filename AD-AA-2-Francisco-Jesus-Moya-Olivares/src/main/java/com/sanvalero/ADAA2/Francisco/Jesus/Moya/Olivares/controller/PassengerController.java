package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.controller;

import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.Bus;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.Passenger;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.exception.BusNotFopundException;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.exception.PassengerNotFopundException;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.repository.PassengerRepository;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.service.PassengerService;
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

public class PassengerController {

    private final Logger logger = LoggerFactory.getLogger(PassengerController.class);

    @Autowired
    private PassengerService passengerservice;

    @Operation(summary = "Obtiene el listado de pasajeros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de pasajeros",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Passenger.class)))),
    })
    @GetMapping(value = "/passengers", produces = "application/json")
    public ResponseEntity<ArrayList<Passenger>> getPassenger(){
        logger.info("inicio getPassengers");
        logger.info("fin getPassengers");
        return new ResponseEntity<>(passengerservice.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtiene un pasajero por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe el pasajero", content = @Content(schema = @Schema(implementation = Passenger.class))),
            @ApiResponse(responseCode = "404", description = "El pasajero no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @GetMapping(value = "/passengers/{id}", produces = "application/json")
    public ResponseEntity<Passenger> getPassenger(@PathVariable Integer id) {
        Passenger passenger = passengerservice.findById(id)
                .orElseThrow(() -> new PassengerNotFopundException(id));

        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }

    @Operation(summary = "Almacena un pasajero")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "pasajero almacenado", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @PostMapping(value = "/passengers", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger){
        logger.info(passenger.toString());
        return new ResponseEntity<>(passengerservice.save(passenger), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un pasajero")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se elimino el pasajero", content = @Content(schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "404", description = "El pasajeo no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @DeleteMapping(value = "/passengers/{id}", produces = "application/json")
    public ResponseEntity<Response> deletePassenger(@PathVariable Integer id) {
        passengerservice.deleteById(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }


    @ExceptionHandler(PassengerNotFopundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handleException(PassengerNotFopundException pnfe) {
        Response response = Response.errorResonse(NOT_FOUND, pnfe.getMessage());
        logger.error(pnfe.getMessage(), pnfe);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
