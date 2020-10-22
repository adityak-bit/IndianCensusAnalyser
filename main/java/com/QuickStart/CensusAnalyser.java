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
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			Iterator<IndiaCensusCSV> censusCSVIterator = this.getCSVFileIterator(reader, IndiaCensusCSV.class);
			Iterable<IndiaCensusCSV> csvIterable = () -> censusCSVIterator;
			int numOfEntries = (int) StreamSupport
					                 .stream(csvIterable.spliterator(), false)
					                 .count();
			return numOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}

	public int loadIndiaCodeData(String csvFilePath) throws CensusAnalyserException, IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			Iterator<IndiaCodeCSV> censusCSVIterator = this.getCSVFileIterator(reader, IndiaCodeCSV.class);
			Iterable<IndiaCodeCSV> csvIterable = () -> censusCSVIterator;
			int numOfEntries = (int) StreamSupport
					                 .stream(csvIterable.spliterator(), false)
					                 .count();
			return numOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}

	private <E> Iterator<E> getCSVFileIterator(Reader reader, Class<E> csvClass) throws CensusAnalyserException {
		try {
			CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			CsvToBean<E> csvToBean = csvToBeanBuilder
					                 .withType(csvClass)
					                 .withIgnoreLeadingWhiteSpace(true).build();
			Iterator<E> CSVIterator = csvToBean.iterator();
			return csvToBean.iterator();
		} catch (RuntimeException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
		}
	}
}