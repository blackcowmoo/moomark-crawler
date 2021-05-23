package com.restapi.crawlingdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


 class CrawlingDataServiceTest {

	
	@Autowired
	CrawlingDataService crawlingDataService;
	
	@BeforeEach
	void beforeEach() {
	
	}
	
	@Test
	void readWebSite () {
		
		//given
		String keyword = "jquery";
		
		//when
		
		//then
		crawlingDataService.crawlingDataWeb(keyword);
		
	}
}
