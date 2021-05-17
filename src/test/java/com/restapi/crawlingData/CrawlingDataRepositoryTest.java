package com.restapi.crawlingData;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.restapi.crawlingData.domain.CrawlingData;
import com.restapi.crawlingData.repository.CrawlingDataRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class CrawlingDataRepositoryTest {
	
	@Autowired
	CrawlingDataRepository crawlingDataRepository;
	
	@After
	public void cleanup() {
		crawlingDataRepository.deleteAll();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void startTest() {
		//given
		Long userId = (long) 123;
		String title = "testTitle";
		String testUrl = "www.naver.com";
		crawlingDataRepository.save(CrawlingData.builder()
			.userId(userId)
			.title(title)
			.userId(userId)
			.url(testUrl)
			.build());
		//when
		List<CrawlingData> dataList = crawlingDataRepository.findAll();
		
		//then
		CrawlingData data = dataList.get(0);
		assertThat(data.getTitle()).equals(title);
		assertThat(data.getUrl()).equals(testUrl);
	}
}
