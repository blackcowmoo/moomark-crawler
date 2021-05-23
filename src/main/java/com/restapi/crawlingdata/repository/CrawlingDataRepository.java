package com.restapi.crawlingdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restapi.crawlingdata.domain.CrawlingData;

import java.util.List;
import java.util.Optional;

public interface CrawlingDataRepository extends JpaRepository<CrawlingData, Long>{
	
	public Optional<CrawlingData> findByIdx(Long idx);
	
	public Optional<CrawlingData> findByUserId(Long userId);
	
	public Optional<CrawlingData> findBySiteName(String siteName);
	
	public Optional<CrawlingData> findByUserIdAndSiteName(Long userId, String siteName);
	
	public List<CrawlingData> findAll();
}
