package com.kha.exceptions;

public class EvenNumberException extends Exception{
	@Override
	public String getMessage() {
		return "Even numbers not allowed.";
	}
}
