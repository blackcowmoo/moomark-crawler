package com.restapi.crawling.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum CrawlingSiteUrl {
	JOBKOREA("http://www.jobkorea.co.kr/Search/?"), NAVER("http://www.naver.com");
	private final String url;
}
