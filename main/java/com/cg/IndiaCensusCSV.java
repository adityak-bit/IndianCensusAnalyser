package com.cg;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCSV {

	@CsvBindByName(column = "State", required = true)
	public String state;
	@CsvBindByName(column = "Population", required = true)
	public long population;
	@CsvBindByName(column = "AreaInSqKm", required = true)
	public long areaInSqKm;
	@CsvBindByName(column = "DensityPerSqKm", required = true)
	public int densityPerSqKm;

	@Override
	public String toString() {
		return "StateCensusCSV [state=" + state + ", population=" + population + ", areaInSqKm=" + areaInSqKm
				+ ", densityPerSqKm=" + densityPerSqKm + "]";
	}
}
