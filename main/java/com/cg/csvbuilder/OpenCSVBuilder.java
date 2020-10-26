package com.cg.csvbuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.*;

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

	@Override
	public List<E> getCSVFileList(Reader reader, Class<E> csvClass) throws CSVBuilderException {
		CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
		CsvToBean<E> csvToBean = csvToBeanBuilder
				                 .withType(csvClass)
				                 .withIgnoreLeadingWhiteSpace(true).build();
		List<E> CSVIterator = (List<E>) csvToBean.iterator();
		return (List<E>) csvToBean.iterator();
	}
	
}
