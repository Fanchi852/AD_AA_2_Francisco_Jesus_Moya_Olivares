package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.exception;

public class PassengerNotFopundException extends RuntimeException{

    public PassengerNotFopundException(Integer id){super("Passenger not found: " + id);}

}
