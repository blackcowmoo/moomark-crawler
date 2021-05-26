package com.restapi.crawling.crawlingdata.service;

import com.restapi.crawling.crawlingdata.repository.CrawlingDataRepository;
import com.restapi.crawling.crawlingdata.domain.JobkoreaCrawlingSetting;
import com.restapi.crawling.crawlingdata.domain.CrawlingData;
import com.restapi.crawling.crawlingdata.domain.CrawlingSiteUrl;

import java.io.IOException;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrawlingDataService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final JobkoreaCrawlingSetting setting = new JobkoreaCrawlingSetting();

	@Autowired
	private final CrawlingDataRepository crawlingDataRepository;

	@Autowired
	public CrawlingDataService(CrawlingDataRepository crawlingDataRepository) {
		this.crawlingDataRepository = crawlingDataRepository;
	}

	/**
	 * 크롤링한 데이터 DB에 저장
	 */
	public void saveCrawlingInfo(CrawlingData crawlingData) {
		crawlingDataRepository.save(crawlingData);
	}
	
	
	/**
	 * Crawling 시작 함수
	 * @param userId
	 * @param keyword
	 */
	public void startCrawlingDataWeb(Long userId, String keyword) {
		setting.setKeword(keyword);
		Elements elements = null;
		
		try {
			elements = setting.startCrawling();
		} catch (IOException e) {
			logger.error("crawling is error", e);
		}
		
		for (Element element : elements) {
			var crawlingData = CrawlingData.builder()
					.userId(userId)
					.siteName(CrawlingSiteUrl.JOBKOREA.getUrl())
					.title(element.toString())
					.url(element.getElementsByAttribute("href").attr("href")).build();
			
			saveCrawlingInfo(crawlingData);
		}
	}
	
	/**
	 * USER ID 기반의 crawlingData 찾기
	 * @param userId
	 * @return
	 */
	public java.util.Optional<CrawlingData> fincCrawlingDataByUserId(Long userId) {
		return crawlingDataRepository.findByUserId(userId);
	}

}
