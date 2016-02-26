package com.jpmc.ssm.calculators;

import com.jpmc.ssm.model.Stock;
import com.jpmc.ssm.model.StockType;
import com.jpmc.ssm.repository.SimpleStockMarketRepository;

public class DividendYieldCalculator implements StockCalculator {
	private SimpleStockMarketRepository tradeStockRepository;

	public DividendYieldCalculator(SimpleStockMarketRepository tradeStockRepository) {
		this.tradeStockRepository = tradeStockRepository;
	}

	@Override
	public double calculate(CalculateParameter parameters)
			throws Exception {
		double dividendYield = -1.0;

		Stock stock = tradeStockRepository.getStockBySymbol(parameters.stockSymbol);

		if (parameters.tickerPrice > 0.0) {
			if (stock.getStockType() == StockType.COMMON) {
				dividendYield = stock.getLastDividend() / parameters.tickerPrice;
			} else {
				dividendYield = (stock.getFixedDividend() * stock.getParValue())
						/ parameters.tickerPrice;
			}
		}

		return dividendYield;
	}
}
