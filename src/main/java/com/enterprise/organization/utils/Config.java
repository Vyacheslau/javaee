package com.enterprise.organization.utils;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Config {
	
	private static final Logger logger = Logger.getLogger(Config.class);
	private static MessageSource messageSource;

	@Autowired
	public void setMessageSource(final MessageSource messageSource) {
		Config.messageSource = messageSource;
	}

	public static String getValue(final String key) {
			return messageSource.getMessage(key, null, Locale.US);
	}
}
