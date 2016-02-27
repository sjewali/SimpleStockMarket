package com.jpmc.ssm.contextloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Context loader to load the Stock details in Context
 * 
 */
public class SimpleStockContextLoaderImpl implements
		SimpleStockContextLoader {
	private static Logger logger = LoggerFactory.getLogger(SimpleStockContextLoaderImpl.class);
	
	private static final String SPRING_CONTEXT_LOADER = "classpath*:*simple-stock-service-repository.xml";

	private AbstractApplicationContext springContext = null;

	public SimpleStockContextLoaderImpl() {
		initializeContext();
	}

	private void initializeContext(){
		try {
			springContext = new ClassPathXmlApplicationContext(
					SPRING_CONTEXT_LOADER);
		} catch (Exception exception) {
			logger.error("Error occured when initializing the context", exception.getMessage());
		} finally {
			if (null != springContext) {
				springContext.registerShutdownHook();
			}
		}		
	}

	private static class SimpleStockContextHolder{
		private static final SimpleStockContextLoader INSTANCE = new SimpleStockContextLoaderImpl();
	}
	
	public static SimpleStockContextLoader getInstance(){
		return SimpleStockContextHolder.INSTANCE;
	}

	public <T> T getBean(String beanName, Class<T> objectClass) {
		return springContext.getBean(beanName, objectClass);
	}
}