package com.jpmc.ssm.calculators;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

import com.jpmc.ssm.model.Trade;
import com.jpmc.ssm.predicate.StockPredicate;
import com.jpmc.ssm.repository.SimpleStockMarketRepository;

public class VolumWeightedeStockPriceCalculator implements StockCalculator {
	private static final int TIME_INTERVALFOR_VWSP_15 = 15;
	private SimpleStockMarketRepository tradeStockRepository;

	public VolumWeightedeStockPriceCalculator(
			SimpleStockMarketRepository tradeStockRepository) {
		this.tradeStockRepository = tradeStockRepository;
	}

	@Override
	public double calculate(CalculateParameter parameters)
			throws Exception {
		double stockPrice = 0.0;

		stockPrice = calculateStockPriceinRange(parameters.stockSymbol, TIME_INTERVALFOR_VWSP_15);

		return stockPrice;	}

	private double calculateStockPriceinRange(final String stockSymbol, final int minutesRange) throws Exception{
		double stockPrice = 0.0;
		@SuppressWarnings("unchecked")
		Collection<Trade> trades = CollectionUtils.select(tradeStockRepository.getTrades(stockSymbol), new StockPredicate(stockSymbol, minutesRange));
		double shareQuantityAcum = 0.0;
		double tradePriceAcum = 0.0;
		for(Trade trade : trades){
			tradePriceAcum += (trade.getPrice() * trade.getSharesQuantity());
			shareQuantityAcum += trade.getSharesQuantity();
		}
		if(shareQuantityAcum > 0.0){
			stockPrice = tradePriceAcum / shareQuantityAcum;	
		}
		return stockPrice;
	}
}
