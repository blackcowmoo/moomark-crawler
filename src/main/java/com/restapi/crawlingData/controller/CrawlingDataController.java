package com.restapi.crawlingData.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/search/")
public class CrawlingDataController {

	@RequestMapping(value = "/")
	public String hello() {
		return "hello CrawlingServer";
	}
	
}
