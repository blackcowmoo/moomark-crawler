package com.restapi.crawling.service;

import com.restapi.crawling.domain.CrawlingData;
import com.restapi.crawling.domain.CrawlingSiteUrl;
import com.restapi.crawling.domain.JobkoreaCrawlingSetting;
import com.restapi.crawling.repository.CrawlingDataRepositoryInterface;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CrawlingDataService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final JobkoreaCrawlingSetting setting = new JobkoreaCrawlingSetting();
	
	@Autowired
	private final CrawlingDataRepositoryInterface crawlingDataRepository;


	/**
	 * ũ�Ѹ��� ������ DB�� ����
	 */
	private void saveCrawlingInfo(CrawlingData crawlingData) {
		crawlingDataRepository.save(crawlingData);
	}
	
	
	/**
	 * Crawling ���� �Լ�
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
	 * USER ID ����� crawlingData ã��
	 * @param userId
	 * @return
	 */
	public List<CrawlingData> fincCrawlingDataByUserId(Long userId) {
		return crawlingDataRepository.findByUserId(userId);
	}
	
	public List<CrawlingData> fincCrawlingDataByUserId(Long userId, Pageable pageable) {
		return crawlingDataRepository.findByUserId(userId, pageable);
	}
	
	public List<CrawlingData> fincCrawlingDataByIdx(Long idx) {
		log.info("find Crawling Data idx is : {}", idx);
		return crawlingDataRepository.findById(idx).stream().collect(Collectors.toList());
	}
	
}
