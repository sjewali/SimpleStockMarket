package com.jpmc.ssm.calculators;

import java.util.List;

import com.jpmc.ssm.model.Stock;
import com.jpmc.ssm.repository.SimpleStockMarketRepository;

public class GBCEAllShareIndexCalculator implements OtherCalculator {
	private SimpleStockMarketRepository tradeStockRepository;

	public GBCEAllShareIndexCalculator(SimpleStockMarketRepository tradeStockRepository) {
		this.tradeStockRepository = tradeStockRepository;
	}

	@Override
	public double calculate() {
		double allShareIndex = 0.0;
		double price = 1;
		List<Stock> stocks = tradeStockRepository.getStocks();
		for (Stock stock : stocks) {
			price *= stock.getTickerPrice();
		}

		allShareIndex = Math.pow(price, 1.0 / stocks.size());
		return allShareIndex;
	}
}