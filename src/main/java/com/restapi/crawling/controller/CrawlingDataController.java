package com.restapi.crawling.controller;



import com.restapi.crawling.service.CrawlingDataService;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CrawlingDataController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private final CrawlingDataService crawlingDataservice;
	
	
	@GetMapping("/search/new")
	public String hello() {
		logger.info("Log this : {}", "index");
		return "hello CrawlingServer";
	}
	
}
