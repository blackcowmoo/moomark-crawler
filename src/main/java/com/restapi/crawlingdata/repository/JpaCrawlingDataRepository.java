package com.restapi.crawlingdata.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.crawlingdata.domain.CrawlingData;

public interface JpaCrawlingDataRepository extends JpaRepository<CrawlingData, Long>, CrawlingDataRepository{

	@Override
	Optional<CrawlingData> findByIdx(Long idx);
}
