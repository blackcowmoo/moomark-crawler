package com.restapi.crawlingdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.restapi.crawlingdata.repository.*;
import com.restapi.crawlingdata.service.CrawlingDataService;

import org.springframework.context.annotation.Bean;


@Configuration
public class SpringConfig {
	
	private final JpaCrawlingDataRepository crawlingDatarepository;
	
	@Autowired
	public SpringConfig(JpaCrawlingDataRepository crawlingDataRepository) {
		this.crawlingDatarepository = crawlingDataRepository;
	}
	
	
	@Bean
	public CrawlingDataService crawlingDataService() {
		return new CrawlingDataService(crawlingDatarepository);
	}
}
