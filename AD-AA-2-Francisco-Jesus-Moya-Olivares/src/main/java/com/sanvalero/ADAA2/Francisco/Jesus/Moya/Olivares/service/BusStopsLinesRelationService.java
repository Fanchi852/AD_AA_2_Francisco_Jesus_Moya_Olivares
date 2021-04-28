package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.service;

import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.Bus;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.BusStopsLinesRelation;

import java.util.ArrayList;
import java.util.Optional;

public interface BusStopsLinesRelationService {

    ArrayList<BusStopsLinesRelation> findAll();
    Optional<BusStopsLinesRelation> findById(Integer id);
    BusStopsLinesRelation save(BusStopsLinesRelation busstopslinesrelation);
    BusStopsLinesRelation modifyBusStopsLinesRelation(BusStopsLinesRelation busstopslinesrelation);
    void deleteById(Integer id);
    void deleteAll();
    long count();

}
