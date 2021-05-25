package com.restapi.crawling.crawlingdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;

import com.restapi.crawling.crawlingdata.domain.CrawlingData;
import com.restapi.crawling.crawlingdata.repository.CrawlingDataRepository;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@RestClientTest(CrawlingDataService.class)
class CrawlingDataServiceTest {

	
	@Autowired
	CrawlingDataRepository craw;
	 
	@Autowired
	CrawlingDataService crawlingDataService;
	
	@BeforeEach
	void beforeEach() {
		crawlingDataService = new CrawlingDataService(craw);
	}
	
	@Test
	void readWebSite () {
		
		//given
		String keyword = "jquery";
		Long userId = Long.valueOf(12345);
		
		//when
		crawlingDataService.crawlingDataWeb(userId ,keyword);
		Optional<CrawlingData> data = craw.findByUserId(userId);
		//then
		Assertions.assertTrue(data.isPresent());
		
	}
}
