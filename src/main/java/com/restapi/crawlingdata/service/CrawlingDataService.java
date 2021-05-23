package com.restapi.crawlingdata.service;

import com.restapi.crawlingdata.repository.*;
import com.restapi.crawlingdata.domain.CrawlingSetting;
import com.restapi.crawlingdata.domain.CrawlingSiteUrl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingDataService {

	private final JpaCrawlingDataRepository crawlingDataRepository;
	private final CrawlingSetting setting = new CrawlingSetting();

	public CrawlingDataService(JpaCrawlingDataRepository crawlingDataRepository) {
		this.crawlingDataRepository = crawlingDataRepository;
	}

	/**
	 * 정보 크롤링
	 */
	public void crawlingInfo() {
		crawlingDataRepository.save(null);
	}

	public void crawlingDataWeb(String keyword) {
		setting.setKeyword(keyword);
		setting.setUrl(CrawlingSiteUrl.JOBKOREA.getUrl());
		setting.addParameter("stext", "jquery");
		setting.addParameter("IsCoInfoSC", "false");
		setting.addParameter("IsRecruit", "false");
		setting.addParameter("ord", "1");
		setting.addParameter("Order", "1");
		setting.addParameter("page", "2");
		setting.addParameter("pageSize", "10");

		Document doc = setting.readWebPage();

		var elements = doc.select(".list-post .post .post-list-corp .name");
		
		for (Element element : elements) {
			System.out.println(element.text() + "\n");
		}
	}

}
