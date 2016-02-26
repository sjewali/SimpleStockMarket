package com.jpmc.ssm.service;

import com.jpmc.ssm.model.Trade;

public interface SimpleStockMarketService {
	public boolean recordTrade(String stockSymbol, Trade trade) throws Exception;
}