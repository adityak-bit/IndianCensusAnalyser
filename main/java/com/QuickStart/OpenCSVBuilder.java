package com.QuickStart;

import java.io.Reader;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder<E> implements ICSVBuilder {

	public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CensusAnalyserException {
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
