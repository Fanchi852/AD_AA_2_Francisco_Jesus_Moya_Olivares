package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.exception;

public class BusStopNotFopundException extends RuntimeException{

    public BusStopNotFopundException(Integer id){super("BusStop not found: " + id);}

}
