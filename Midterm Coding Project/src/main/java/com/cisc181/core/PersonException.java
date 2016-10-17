package com.cisc181.core;

public class PersonException extends Exception {
	Person a;

	   public PersonException(Person a, String message) {
		super(message);
		this.a = a;
	}

}