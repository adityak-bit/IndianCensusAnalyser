package com.cg.commonscsv;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder<E> {
	public Iterator<E> getCSVFileIterator(Reader reader, Class<E> csvClass) throws CSVBuilderException, IOException ;
	public List<E> getCSVFileList(Reader reader, Class<E> csvClass) throws CSVBuilderException, IOException ;
}
