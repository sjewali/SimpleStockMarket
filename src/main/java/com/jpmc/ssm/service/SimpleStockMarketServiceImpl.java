package com.jpmc.ssm.service;

import com.jpmc.ssm.model.Trade;
import com.jpmc.ssm.repository.SimpleStockMarketRepository;

/**
 * Service class used to implement the Trade and Stock calculation functions.
 *
 */
public class SimpleStockMarketServiceImpl implements SimpleStockMarketService {

	private SimpleStockMarketRepository tradeStockRepository;

	public SimpleStockMarketServiceImpl(final SimpleStockMarketRepository tradeStockRepository){
		this.tradeStockRepository = tradeStockRepository;
	}

	public boolean recordTrade(final String stockSymbol, final Trade trade) throws Exception{
		boolean recordResult = false;
		try{
			recordResult = tradeStockRepository.recordTrade(stockSymbol, trade);
		}catch(Exception exception){
			throw new Exception("Error when trying to record a trade.", exception);
		}
		return recordResult;
	}
}
