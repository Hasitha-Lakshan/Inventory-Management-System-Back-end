package com.cbl.backend.exception;

public class EmployeeNotFoundException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7966652360911974612L;

	public EmployeeNotFoundException(String message)
	{
		super(message);
	}
	

}
