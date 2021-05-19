package com.restapi.crawlingData.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.restapi.crawlingData.repository.CrawlingDataRepository;
import com.restapi.crawlingData.repository.JpaCrawlingDataRepository;

import org.springframework.context.annotation.Bean;


@Configuration
public class SpringConfig {
	
	private EntityManager em;
	
	@Autowired
	public SpringConfig(EntityManager em) {
		this.em = em;
	}
	
	
	@Bean
	public CrawlingDataRepository crawlingDataRepository() {
		return new JpaCrawlingDataRepository(em);
	}
}
