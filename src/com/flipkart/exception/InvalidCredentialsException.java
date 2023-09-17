package com.flipkart.exception;

public class InvalidCredentialsException extends Exception {
	public InvalidCredentialsException() {
		super("Invalid Credentials Username or Password is wrong");
	}
}
