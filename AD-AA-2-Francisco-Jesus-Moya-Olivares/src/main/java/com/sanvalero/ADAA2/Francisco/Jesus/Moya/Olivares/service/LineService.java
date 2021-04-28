package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.service;

import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.Line;

import java.util.ArrayList;
import java.util.Optional;

public interface LineService {

    ArrayList<Line> findAll();
    Optional<Line> findById(Integer id);
    Line save(Line line);
    void deleteById(Integer id);
    void deleteAll();
    long count();

}
