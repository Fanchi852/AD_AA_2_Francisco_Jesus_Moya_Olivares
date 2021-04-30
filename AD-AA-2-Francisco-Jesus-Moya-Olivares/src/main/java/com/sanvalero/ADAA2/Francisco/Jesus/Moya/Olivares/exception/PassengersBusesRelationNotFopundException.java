package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.exception;

public class PassengersBusesRelationNotFopundException extends RuntimeException{

    public PassengersBusesRelationNotFopundException(Integer id){super("PassengersBusesRelation not found: " + id);}

}
