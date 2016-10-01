package com.facade;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FacadeFactory {
	
	@Bean
	public CarFacade getCarFacade() {
		return new CarFacade();
	}

}
