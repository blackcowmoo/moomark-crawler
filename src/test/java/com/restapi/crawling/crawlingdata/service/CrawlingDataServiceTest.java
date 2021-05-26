package com.restapi.crawling.crawlingdata.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.restapi.crawling.crawlingdata.repository.CrawlingDataRepository;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class CrawlingDataServiceTest {

	@Mock
	private CrawlingDataRepository crawlingRepository;
	
	@InjectMocks
	CrawlingDataService crawlingDataService;
	
	@BeforeEach
	void beforeEach() {
		//given
		String keyword = "jquery";
		Long userId = Long.valueOf(12345);
		
		//when
		crawlingDataService.startCrawlingDataWeb(userId ,keyword);
	}
	
	@Test
	void readWebSite () {
	
		//then
		Assertions.assertEquals(crawlingDataService.fincCrawlingDataByUserId(Long.valueOf(12345)).isEmpty(), false);
		
	}
}
