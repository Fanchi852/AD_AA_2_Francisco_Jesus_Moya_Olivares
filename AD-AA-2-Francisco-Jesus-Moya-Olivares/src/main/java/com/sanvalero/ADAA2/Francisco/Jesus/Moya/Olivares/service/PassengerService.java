package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.service;

import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.Passenger;

import java.util.ArrayList;
import java.util.Optional;

public interface PassengerService {

    ArrayList<Passenger> findAll();
    Optional<Passenger> findById(Integer id);
    Passenger save(Passenger passenger);
    Passenger modifyPassenger(Passenger passenger);
    void deleteById(Integer id);
    void deleteAll();
    long count();

}
