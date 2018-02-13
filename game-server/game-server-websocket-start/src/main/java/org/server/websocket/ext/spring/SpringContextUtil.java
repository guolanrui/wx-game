package org.server.websocket.ext.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;

	private SpringContextUtil() {
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		if (SpringContextUtil.applicationContext == null) {
			SpringContextUtil.applicationContext = applicationContext;
		}
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}
	public static <T> T getBean(String beanName,Class<T> clazz) {
		return getApplicationContext().getBean(beanName,clazz);
	}
}
