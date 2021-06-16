package com.restapi.crawling.controller;



import com.restapi.crawling.domain.CrawlingData;
import com.restapi.crawling.domain.CrawlingDataDto;
import com.restapi.crawling.service.CrawlingDataService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CrawlingDataController {
	
	@Autowired
	private final CrawlingDataService crawlingDataservice;
	
	
	@PostMapping("/crawlingData")
	public ResponseEntity<List<CrawlingDataDto>> saveCrawlingData(@RequestParam("userid") Long userId, @RequestParam("keyword") String keyword) {
		crawlingDataservice.startCrawlingDataWeb(userId, keyword);
		log.info("crawling keyword : {}" , keyword);
		List<CrawlingData> crawlingList = crawlingDataservice.fincCrawlingDataByUserId(userId);
		List<CrawlingDataDto> resultList = new ArrayList<>();
		for(CrawlingData data : crawlingList) {
			CrawlingDataDto dataDto = CrawlingDataDto.builder()
					.idx(data.getIdx())
					.userId(data.getUserId())
					.title(data.getTitle())
					.siteName(data.getSiteName())
					.searchDateAt(data.getSearchDateAt())
					.searchTimeAt(data.getSearchTimeAt())
					.build();
			resultList.add(dataDto);
		}
		
		return new ResponseEntity<>(resultList, HttpStatus.OK);
	}
	
	@GetMapping("/crawlingData")
	public List<CrawlingDataDto> getCrawlingData(@RequestParam("userid") Long userId, final Pageable pageable) {
		List<CrawlingData> crawlingList = crawlingDataservice.fincCrawlingDataByUserId(userId, pageable);
		List<CrawlingDataDto> resultList = new ArrayList<>();
		for(CrawlingData data : crawlingList) {
			CrawlingDataDto dataDto = CrawlingDataDto.builder()
					.idx(data.getIdx())
					.userId(data.getUserId())
					.title(data.getTitle())
					.siteName(data.getSiteName())
					.searchDateAt(data.getSearchDateAt())
					.searchTimeAt(data.getSearchTimeAt())
					.build();
			resultList.add(dataDto);
		}
		return resultList;
	}
	
}
