package com.jpmc.ssm.repository;

import java.util.List;

import com.jpmc.ssm.model.Stock;
import com.jpmc.ssm.model.Trade;

public interface SimpleStockMarketRepository {
	public void addStock(Stock stock);
	public boolean recordTrade(String stockSymbol, Trade trade) throws Exception;
	public List<Trade> getTrades(String stockSymbol);
	public Stock getStockBySymbol(String stockSymbol);
	public List<Stock> getStocks();
}
