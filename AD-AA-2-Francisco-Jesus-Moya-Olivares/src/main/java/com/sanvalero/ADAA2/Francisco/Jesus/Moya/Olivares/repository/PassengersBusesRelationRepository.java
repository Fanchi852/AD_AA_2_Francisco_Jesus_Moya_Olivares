package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.repository;


import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.PassengersBusesRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PassengersBusesRelationRepository extends CrudRepository<PassengersBusesRelation, Integer> {

    ArrayList<PassengersBusesRelation> findAll();
    Optional<PassengersBusesRelation> findById(Integer id);
    PassengersBusesRelation save(PassengersBusesRelation passengersbusesrelation);
    PassengersBusesRelation modifyPassengersBusesRelation(PassengersBusesRelation passengersbusesrelation);
    void deleteById(Integer id);
    void deleteAll();
    long count();

}
