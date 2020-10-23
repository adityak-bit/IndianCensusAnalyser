package com.cg;

import com.opencsv.bean.CsvBindByName;

public class IndiaCodeCSV {

	@CsvBindByName(column = "SrNo", required = true)
	int srNo;
	@CsvBindByName(column = "State Name", required = true)
	String stateName;
	@CsvBindByName(column = "TIN", required = true)
	int TIN;
	@CsvBindByName(column = "StateCode", required = true)
	String stateCode;
	
	@Override
	public String toString() {
		return "IndiaCodeCSV [srNo=" + srNo + ", stateName=" + stateName + ", TIN=" + TIN + ", stateCode=" + stateCode
				+ "]";
	}
}
