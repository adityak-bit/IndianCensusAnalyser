package com.cg;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.StreamSupport;

import com.cg.commonscsv.CSVBuilderException;
import com.cg.commonscsv.CSVBuilderFactory;
import com.cg.commonscsv.ICSVBuilder;

public class CensusAnalyser {
	
	
	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException, IOException, CSVBuilderException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			ICSVBuilder<IndiaCensusCSV> csvBuilder = CSVBuilderFactory.createCSVBuilder();
			/*Iterator<IndiaCensusCSV> censusCSVIterator = csvBuilder
					                                     .getCSVFileIterator(reader, IndiaCensusCSV.class);*/
			List<IndiaCensusCSV> censusCSVList = csvBuilder
                                               .getCSVFileList(reader, IndiaCensusCSV.class);
			return censusCSVList.size();
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}catch(RuntimeException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
		}
	}

	public int loadIndiaCodeData(String csvFilePath) throws CensusAnalyserException, IOException, CSVBuilderException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			ICSVBuilder<IndiaCodeCSV> csvBuilder = CSVBuilderFactory.createCSVBuilder();
			/*Iterator<IndiaCodeCSV> stateCSVIterator = csvBuilder
					                                  .getCSVFileIterator(reader, IndiaCodeCSV.class);*/
			List<IndiaCodeCSV> stateCSVList = csvBuilder
                                            .getCSVFileList(reader, IndiaCodeCSV.class);
			return stateCSVList.size();
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}catch(RuntimeException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
		}
	}

	private <E> int getCount(Iterator<E> iterator) {
		/*Iterable<E> csvIterable = () -> iterator;
		int numOfEntries = (int) StreamSupport
				                 .stream(csvIterable.spliterator(), false)
				                 .count();*/
		List<E> csvList = new ArrayList<E>();
		int numOfEntries = (int) StreamSupport
				                 .stream(csvList.spliterator(), false)
				                 .count();
		return numOfEntries;
	}
	
}