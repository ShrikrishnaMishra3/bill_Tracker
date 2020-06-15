package com.billTracker.exception;

@SuppressWarnings("serial")
public class BillAlreadyExistException extends RuntimeException {
public static  String message="user already exists !..please login";


public BillAlreadyExistException()
{
	
}
@SuppressWarnings("static-access")
public BillAlreadyExistException(String message)
{
	this.message=message;
}
}
