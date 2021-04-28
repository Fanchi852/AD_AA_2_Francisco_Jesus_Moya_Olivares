package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.repository;


import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.BusStopsLinesRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface BusStopsLinesRelationRepository extends CrudRepository<BusStopsLinesRelation, Integer> {

    ArrayList<BusStopsLinesRelation> findAll();
    Optional<BusStopsLinesRelation> findById(Integer id);
    BusStopsLinesRelation save(BusStopsLinesRelation busstopslinesrelation);
    BusStopsLinesRelation modifyBusStopsLinesRelation(BusStopsLinesRelation busstopslinesrelation);
    void deleteById(Integer id);
    void deleteAll();
    long count();

}
