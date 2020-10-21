package com.QuickStart;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class CodeAnalyserTest {
	private static final String STATE_CODE_CSV_FILE_PATH = "IndiaStateCode.csv";
	private static final String STATE_CODE_WRONG_CSV_FILE_PATH = "IndiaStateCensusData.csv";
	private static final String STATE_CODE_WRONG_TYPE_FILE_PATH = "Data.txt";
	private static final String STATE_CODE_WRONG_HEADER_CSV_FILE_PATH = "IndiaStateCodeHeader.csv";
	private static final String STATE_CODE_WRONG_DELIMITER_CSV_FILE_PATH = "IndiaStateCodeDelimiter.csv";

	@Test
	public void givenIndianCodeCSVFile_CheckNumberOfRecordMatches() throws IOException {
		try {
			CensusAnalyser analyser = new CensusAnalyser();
			int numOfRecords = analyser.loadIndiaCodeData(STATE_CODE_CSV_FILE_PATH);
			Assert.assertEquals(37, numOfRecords);
		} catch (CensusAnalyserException e) {
		}
}
}