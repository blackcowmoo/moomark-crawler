package com.restapi.crawling.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CrawlingDataDto {
	private Long idx;
	
	private Long userId;
	
	private String siteName;
	
	private String title;
	
	private String url;

	private LocalDateTime searchTimeAt;
	
	private LocalDate searchDateAt;
}
