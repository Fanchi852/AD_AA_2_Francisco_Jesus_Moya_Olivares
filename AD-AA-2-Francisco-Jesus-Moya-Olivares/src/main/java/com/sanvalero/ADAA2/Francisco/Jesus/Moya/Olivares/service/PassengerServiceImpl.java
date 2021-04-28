package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.service;

import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.domain.Passenger;
import com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService{

    @Autowired
    private PassengerRepository passengerrepository;

    @Override
    public ArrayList<Passenger> findAll() {
        return passengerrepository.findAll();
    }

    @Override
    public Optional<Passenger> findById(Integer id) {
        return passengerrepository.findById(id);
    }

    @Override
    public Passenger save(Passenger passenger) {
        return passengerrepository.save(passenger);
    }

    @Override
    public Passenger modifyPassenger(Passenger passenger) {
        return passengerrepository.modifyPassenger(passenger);
    }

    @Override
    public void deleteById(Integer id) {}

    @Override
    public void deleteAll() {}

    @Override
    public long count() {
        return passengerrepository.count();
    }
}
