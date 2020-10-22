package com.QuickStart;

import java.io.Reader;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder<E> implements ICSVBuilder<E> {

	@Override
	public Iterator<E> getCSVFileIterator(Reader reader, Class<E> csvClass) throws CSVBuilderException {
		CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
		CsvToBean<E> csvToBean = csvToBeanBuilder
				                 .withType(csvClass)
				                 .withIgnoreLeadingWhiteSpace(true).build();
		Iterator<E> CSVIterator = csvToBean.iterator();
		return csvToBean.iterator();
	}
	
}
