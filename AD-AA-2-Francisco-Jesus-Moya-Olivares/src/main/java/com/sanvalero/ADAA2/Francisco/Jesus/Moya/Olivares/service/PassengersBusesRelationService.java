package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.service;

import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.Bus;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.Passenger;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.PassengersBusesRelation;

import java.util.ArrayList;
import java.util.Optional;

public interface PassengersBusesRelationService {

    ArrayList<PassengersBusesRelation> findAll();
    Optional<PassengersBusesRelation> findById(Integer id);
    PassengersBusesRelation save(PassengersBusesRelation passengersbusesrelation);
    PassengersBusesRelation modifyPassengersBusesRelation(PassengersBusesRelation passengersbusesrelation);
    void deleteById(Integer id);
    void deleteAll();
    long count();

}
