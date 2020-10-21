package com.QuickStart;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {

	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException, IOException {
		if(! csvFilePath.contains(".csv")) {
			throw new CensusAnalyserException("Not .csv file", CensusAnalyserException
					.ExceptionType.WRONG_TYPE);
		}
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);

			CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.withType(IndiaCensusCSV.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			int numOfEntries = 0;
			while (censusCSVIterator.hasNext()) {
				numOfEntries++;
				IndiaCensusCSV censusData = censusCSVIterator.next();
			}
			return numOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.WRONG_CSV);
		} catch (RuntimeException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.WRONG_INTERNAL_DATA);
		}
	}
}