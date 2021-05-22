package com.restapi.crawlingdata.controller;


import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/search")
public class CrawlingDataController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value = "index")
	public String hello() {
		logger.info("Log this : {}", "index");
		return "hello CrawlingServer";
	}
	
}
