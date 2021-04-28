package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.service;

import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.Bus;

import java.util.ArrayList;
import java.util.Optional;

public interface BusService {

    ArrayList<Bus> findAll();
    Optional<Bus> findById (Integer id);
    ArrayList<Bus> findAllByCode(String code);
    ArrayList<Bus> findByLine (Integer line);
    Bus save(Bus bus);
    void deleteById(Integer id);
    void deleteAll();
    long count();

}
