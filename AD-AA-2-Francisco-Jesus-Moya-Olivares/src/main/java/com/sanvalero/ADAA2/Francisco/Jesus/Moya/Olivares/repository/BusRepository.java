package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.repository;

import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.Bus;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;


public interface BusRepository extends CrudRepository<Bus, Integer>  {

    ArrayList<Bus> findAll();
    Optional<Bus> findById (Integer id);
    ArrayList<Bus> findAllByCode(String code);
    ArrayList<Bus> findByLine (Integer line);
    Bus save(Bus bus);
    void deleteById(Integer id);
    void deleteAll();
    long count();

}
