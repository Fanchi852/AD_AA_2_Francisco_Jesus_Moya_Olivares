package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.exception;

public class BusNotFopundException extends RuntimeException{

    public BusNotFopundException(Integer id){super("Bus not found: " + id);}

}
