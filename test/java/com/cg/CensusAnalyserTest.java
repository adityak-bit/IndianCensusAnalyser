package com.cg;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cg.csvbuilder.CSVBuilderException;
import com.cg.CensusAnalyser;

public class CensusAnalyserTest {

	private static final String STATE_CENSUS_CSV_FILE_PATH = "IndiaStateCensusData.csv";
	private static final String STATE_CENSUS_WRONG_CSV_FILE_PATH = "IndiaStateCode.csv";
	private static final String STATE_CENSUS_WRONG_TYPE_FILE_PATH = "Data.txt";
	private static final String STATE_CENSUS_WRONG_HEADER_CSV_FILE_PATH = "IndiaStateCensusHeader.csv";
	private static final String STATE_CENSUS_WRONG_DELIMITER_CSV_FILE_PATH = "IndiaStateCensusDelimiter.csv";

	@Test
	public void givenIndianCensusCSVFile_CheckNumberOfRecordMatches() throws IOException {
		try {
			CensusAnalyser analyser = new CensusAnalyser();
			int numOfRecords = analyser.loadIndiaCensusData(STATE_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
		} catch (CSVBuilderException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusCSVFile_IfIncorrectReturnsCustomException() throws IOException {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(STATE_CENSUS_WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
		} catch (CSVBuilderException e) {
		}
	}

	@Test
	public void givenIndianCensusCSVFile_WhenCorrect_ButHeaderIncorrectReturnsCustomException() throws IOException {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(STATE_CENSUS_WRONG_HEADER_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
		} catch (CSVBuilderException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusCSVFile_WhenCorrect_ButDelimiterIncorrectReturnsCustomException() throws IOException {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(STATE_CENSUS_WRONG_DELIMITER_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
		} catch (CSVBuilderException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusCSVFile_WhenCorrect_ButTypeIncorrectReturnsCustomException() throws IOException {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(STATE_CENSUS_WRONG_TYPE_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
		} catch (CSVBuilderException e) {
			e.printStackTrace();
		}
	}
}