package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.repository;

import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.BusStop;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.Line;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface LineRepository extends CrudRepository<Line,Integer> {

    ArrayList<Line> findAll();
    Optional<Line> findById(Integer id);
    Line findByName(String name);
    Line save(Line line);
    void deleteById(Integer id);
    void deleteAll();
    long count();

}
