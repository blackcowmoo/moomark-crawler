package com.restapi.crawling.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.crawling.domain.CrawlingData;


public interface CrawlingDataRepositoryInterface extends JpaRepository<CrawlingData, Long>{
	
	public List<CrawlingData> findByUserId(Long userId);
	
	public List<CrawlingData> findByUserId(Long userId, Pageable pageable);

	public List<CrawlingData> findBySiteName(String string);
	
	public List<CrawlingData> findAll();
}
