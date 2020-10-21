package com.QuickStart;

public class CensusAnalyserException extends Exception {

	enum ExceptionType {
		WRONG_TYPE, WRONG_INTERNAL_DATA
	}

	ExceptionType type;

	public CensusAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}
