package com.restapi.crawlingdata.service;

import com.restapi.crawlingdata.repository.*;


public class CrawlingDataService{
	
	private final CrawlingDataRepository crawlingDataRepository;
	
	public CrawlingDataService(CrawlingDataRepository crawlingDataRepository) {
		this.crawlingDataRepository = crawlingDataRepository;
	}
	
	/**
	 * 정보 크롤링
	 */
	public void crawlingInfo() {
		
	}

}
