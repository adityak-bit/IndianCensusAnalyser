package com.cg;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cg.commonscsv.CSVBuilderException;

public class CodeAnalyserTest {
	private static final String STATE_CODE_CSV_FILE_PATH = "IndiaStateCode.csv";
	private static final String STATE_CODE_WRONG_CSV_FILE_PATH = "IndiaStateCensusData.csv";
	private static final String STATE_CODE_WRONG_TYPE_FILE_PATH = "Data.txt";
	private static final String STATE_CODE_WRONG_HEADER_CSV_FILE_PATH = "IndiaStateCodeHeader.csv";
	private static final String STATE_CODE_WRONG_DELIMITER_CSV_FILE_PATH = "IndiaStateCodeDelimiter.csv";

	@Test
	public void givenIndianCodeCSVFile_CheckNumberOfRecordMatches() throws IOException, CSVBuilderException {
		try {
			CensusAnalyser analyser = new CensusAnalyser();
			int numOfRecords = analyser.loadIndiaCodeData(STATE_CODE_CSV_FILE_PATH);
			Assert.assertEquals(38, numOfRecords);
		} catch (CensusAnalyserException e) {
		}
	}

	@Test
	public void givenIndianCodeCSVFile_IfIncorrectReturnsCustomException() throws IOException, CSVBuilderException {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(STATE_CODE_WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
		}
	}

	@Test
	public void givenIndianCodeCSVFile_WhenCorrect_ButHeaderIncorrectReturnsCustomException() throws IOException, CSVBuilderException {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(STATE_CODE_WRONG_HEADER_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
		}
	}

	@Test
	public void givenIndianCodeCSVFile_WhenCorrect_ButDelimiterIncorrectReturnsCustomException() throws IOException, CSVBuilderException {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(STATE_CODE_WRONG_DELIMITER_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
		}
	}

	@Test
	public void givenIndianCodeCSVFile_WhenCorrect_ButTypeIncorrectReturnsCustomException() throws IOException, CSVBuilderException {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(STATE_CODE_WRONG_TYPE_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
		}
	}
}
