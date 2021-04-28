package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.service;

import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.Bus;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService{

    @Autowired
    private BusRepository busrepository;

    public ArrayList<Bus> saveAll(ArrayList<Bus> buses){
        ArrayList<Bus> res = new ArrayList<>();
        busrepository.saveAll(buses).forEach(res::add);
        return res;
    }

    @Override
    public ArrayList<Bus> findAll() {
        return busrepository.findAll();
    }

    @Override
    public Optional<Bus> findById(Integer id) {
        return busrepository.findById(id);
    }

    @Override
    public ArrayList<Bus> findByCode(String code) {
        return busrepository.findByCode(code);
    }

    @Override
    public ArrayList<Bus> findByLine(Integer line) {
        return busrepository.findByLine(line);
    }

    @Override
    public Bus save(Bus bus) {
        return busrepository.save(bus);
    }

    @Override
    public Bus modifyBus(Bus bus) {
        return busrepository.modifyBus(bus);
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public long count() {
        return 0;
    }
}
