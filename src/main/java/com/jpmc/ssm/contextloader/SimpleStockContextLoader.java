package com.jpmc.ssm.contextloader;

public interface SimpleStockContextLoader {

	public <T extends Object> T getBean(String beanName, Class<T> objectClass);
}
