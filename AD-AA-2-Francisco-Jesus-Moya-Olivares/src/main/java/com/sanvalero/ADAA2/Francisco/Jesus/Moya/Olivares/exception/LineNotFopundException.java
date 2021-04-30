package com.sanvalero.ADAA2.Francisco.Jesus.Moya.Olivares.exception;

public class LineNotFopundException extends RuntimeException{

    public LineNotFopundException(Integer id){super("Line not found: " + id);}

}
