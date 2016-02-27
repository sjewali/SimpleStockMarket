package com.jpmc.ssm.contextloader;

public interface SimpleStockContextLoader {

	public SimpleStockContextLoader INSTANCE = SimpleStockContextLoaderImpl.getInstance();

	public <T extends Object> T getBean(String beanName, Class<T> objectClass);
}
