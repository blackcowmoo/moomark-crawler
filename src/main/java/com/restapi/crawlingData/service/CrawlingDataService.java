package com.restapi.crawlingData.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import com.restapi.crawlingData.domain.CrawlingData;
import com.restapi.crawlingData.repository.CrawlingDataRepository;

public class CrawlingDataService{
	
	private CrawlingDataRepository crawlingRepository;
	
	public Optional<CrawlingData> findByIdx(Long idx) {
		Optional<CrawlingData> data = findByIdx(idx);
		return data;
	}
	
	public Optional<CrawlingData> findByUserId(Long userId) {
		Optional<CrawlingData> data = crawlingRepository.findById(userId);
		return data;
	}
	
	public Optional<CrawlingData> findBySiteName(String siteName) {
		Optional<CrawlingData> data = crawlingRepository.findBySiteName(siteName);
		return data;
	}
	
	public List<CrawlingData> findAll() {
		List<CrawlingData> datas = new ArrayList<>();
		crawlingRepository.findAll().forEach(e -> datas.add(e));
		return datas;
	}
	
	public CrawlingData save(CrawlingData data) {
		crawlingRepository.save(data);
		return data;
	}
}
