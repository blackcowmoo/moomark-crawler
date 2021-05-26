package com.restapi.crawling.crawlingdata.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.restapi.crawling.crawlingdata.domain.CrawlingData;


import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
class CrawlingDataRepositoryTest{
	
	@Autowired
	private CrawlingDataRepository crawlingDataRepository;
	
	
	@Test
	void crawlingDataSaveTest() {
		CrawlingData crawlingData = CrawlingData.builder()
				.siteName("Naver")
				.title("CrawlingTest")
				.url("wwww.naver.com")
				.userId(Long.valueOf(1123))
				.build();
		
		crawlingDataRepository.save(crawlingData);
		
		
		CrawlingData findData = crawlingDataRepository.findBySiteName("Naver").get();
		
		Assertions.assertSame(crawlingData, findData);
	}
}
