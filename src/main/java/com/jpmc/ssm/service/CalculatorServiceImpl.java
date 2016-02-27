package com.jpmc.ssm.service;

import com.jpmc.ssm.calculators.CalculateParameter;
import com.jpmc.ssm.calculators.OtherCalculator;
import com.jpmc.ssm.calculators.StockCalculator;

public class CalculatorServiceImpl implements CalculatorServie {
	private StockCalculator dividendYieldCalculator; 
	private StockCalculator peRatioCalculator;
	private StockCalculator volumWeightedeStockPriceCalculator;
	private OtherCalculator gbceAllShareIndexCalculator;

	public CalculatorServiceImpl(StockCalculator dividendYieldCalculator, StockCalculator peRatioCalculator,
			StockCalculator volumWeightedeStockPriceCalculator, OtherCalculator gbceAllShareIndexCalculator) {
		this.dividendYieldCalculator = dividendYieldCalculator;
		this.peRatioCalculator = peRatioCalculator;
		this.volumWeightedeStockPriceCalculator = volumWeightedeStockPriceCalculator;
		this.gbceAllShareIndexCalculator = gbceAllShareIndexCalculator;
	}

	@Override
	public double calculateDividendYied(CalculateParameter parameters) throws Exception {
		return dividendYieldCalculator.calculate(parameters);
	}

	@Override
	public double calculatePERatio(CalculateParameter parameters) throws Exception {
		return peRatioCalculator.calculate(parameters);
	}

	@Override
	public double calculateVolumeWeightStockPrice(CalculateParameter parameters) throws Exception {
		return volumWeightedeStockPriceCalculator.calculate(parameters);
	}

	@Override
	public double calculateGBCEAllShareIndex() throws Exception {
		return gbceAllShareIndexCalculator.calculate();
	}

}
