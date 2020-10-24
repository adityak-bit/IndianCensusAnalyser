package com.cg.commonscsv;

public class CSVBuilderFactory {
	public static <E> ICSVBuilder<E> createCSVBuilder() {
		return new CommonCSVBuilder<E>();
	}
}
