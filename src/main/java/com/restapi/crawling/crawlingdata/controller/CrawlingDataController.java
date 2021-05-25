package com.restapi.crawling.crawlingdata.controller;


import org.springframework.web.bind.annotation.RestController;

import com.restapi.crawling.crawlingdata.service.CrawlingDataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RestController
@RequestMapping("/search")
public class CrawlingDataController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final CrawlingDataService crawlingDataservice;
	
	@Autowired
	public CrawlingDataController(CrawlingDataService crawlingDataService) {
		this.crawlingDataservice = crawlingDataService;
	}
	
	@RequestMapping(value = "index")
	public String hello() {
		logger.info("Log this : {}", "index");
		return "hello CrawlingServer";
	}
	
}
