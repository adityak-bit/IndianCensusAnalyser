package com.QuickStart;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {
	
	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException, IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))){
			CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);

			CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.withType(IndiaCensusCSV.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			Iterable<IndiaCensusCSV> csvIterable = () -> censusCSVIterator;
			int numOfEntries = (int)StreamSupport.stream(csvIterable.spliterator(), false).count();
			return numOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		} catch (RuntimeException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
		}
	}

	public int loadIndiaCodeData(String csvFilePath) throws CensusAnalyserException, IOException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBeanBuilder<IndiaCodeCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);

			CsvToBean<IndiaCodeCSV> csvToBean = csvToBeanBuilder.withType(IndiaCodeCSV.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			Iterator<IndiaCodeCSV> censusCSVIterator = csvToBean.iterator();
			Iterable<IndiaCodeCSV> csvIterable = () -> censusCSVIterator;
			int numOfEntries = (int)StreamSupport.stream(csvIterable.spliterator(), false).count();
			return numOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		} catch (RuntimeException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
		}
	}
}