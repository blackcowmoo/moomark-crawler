package com.restapi.crawlingData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.crawlingData.domain.CrawlingData;

import java.util.List;
import java.util.Optional;

public interface CrawlingDataVoRepository extends JpaRepository<CrawlingData, Long>{
	public Optional<CrawlingData> findByIdx(Long idx);
	public Optional<CrawlingData> findByUserId(Long userId);
	public Optional<CrawlingData> findBySiteName(String siteName);
	public List<CrawlingData> findAll();
}
