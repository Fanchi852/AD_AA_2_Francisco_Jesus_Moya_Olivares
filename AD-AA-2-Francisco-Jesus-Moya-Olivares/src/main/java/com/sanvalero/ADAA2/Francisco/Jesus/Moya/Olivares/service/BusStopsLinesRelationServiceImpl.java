package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.service;

import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.BusStopsLinesRelation;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.repository.BusStopsLinesRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BusStopsLinesRelationServiceImpl implements BusStopsLinesRelationService{

    @Autowired
    private BusStopsLinesRelationRepository busstopslinesrelationrepository;

    @Override
    public ArrayList<BusStopsLinesRelation> findAll() {
        return busstopslinesrelationrepository.findAll();
    }

    @Override
    public Optional<BusStopsLinesRelation> findById(Integer id) {
        return busstopslinesrelationrepository.findById(id);
    }

    @Override
    public BusStopsLinesRelation save(BusStopsLinesRelation busstopslinesrelation) {
        return busstopslinesrelationrepository.save(busstopslinesrelation);
    }

    @Override
    public BusStopsLinesRelation modifyBusStopsLinesRelation(BusStopsLinesRelation busstopslinesrelation) {
        return busstopslinesrelationrepository.modifyBusStopsLinesRelation(busstopslinesrelation);
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public long count() {
        return busstopslinesrelationrepository.count();
    }
}
