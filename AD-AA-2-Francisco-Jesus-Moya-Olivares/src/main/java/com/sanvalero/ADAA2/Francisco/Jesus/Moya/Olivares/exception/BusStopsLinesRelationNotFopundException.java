package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.exception;

public class BusStopsLinesRelationNotFopundException extends RuntimeException{

    public BusStopsLinesRelationNotFopundException(Integer id){super("BusStopsLinesRelation not found: " + id);}

}
