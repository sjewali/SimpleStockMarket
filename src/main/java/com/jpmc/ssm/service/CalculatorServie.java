package com.jpmc.ssm.service;

import com.jpmc.ssm.calculators.CalculateParameter;

public interface CalculatorServie {
	public double calculateDividendYied(CalculateParameter parameters) throws Exception;
	
	public double calculatePERatio(CalculateParameter parameters) throws Exception;
	
	public double calculateVolumeWeightStockPrice(CalculateParameter parameters) throws Exception;
	
	public double calculateGBCEAllShareIndex() throws Exception;
}
