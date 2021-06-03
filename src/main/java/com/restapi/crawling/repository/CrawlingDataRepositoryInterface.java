package com.restapi.crawling.repository;

import java.util.List;
import java.util.Optional;

import com.restapi.crawling.domain.CrawlingData;


public interface CrawlingDataRepositoryInterface{

	public void save(CrawlingData crawlingData);
	
	public List<CrawlingData> findByUserId(String userId);

	public List<CrawlingData> findBySiteName(String string);
	
	public Optional<CrawlingData> findById(Long idx);
	
	public List<CrawlingData> findAll();
}
