package com.cg.commonscsv;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import com.cg.IndiaCodeCSV.Header;

public class CommonCSVBuilder<E> implements ICSVBuilder<E> {
	@Override
	public Iterator<E> getCSVFileIterator(Reader reader, Class<E> csvClass) throws CSVBuilderException, IOException {
	
		CSVParser csvParser = CSVParser.parse(
				                        reader,
				                        CSVFormat.DEFAULT.withHeader(Header.class));
		Iterator<E> CSVIterator = (Iterator<E>) csvParser.iterator();
		return (Iterator<E>) csvParser.iterator();
	}

	@Override
	public List<E> getCSVFileList(Reader reader, Class<E> csvClass) throws CSVBuilderException, IOException {
		CSVParser csvParser = CSVParser.parse(
                reader,
                CSVFormat.DEFAULT.withHeader(Header.class));
        List<E> CSVList =  (List<E>) csvParser.iterator();
        return (List<E>) csvParser.iterator();
	}
	
}
