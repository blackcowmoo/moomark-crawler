package com.restapi.crawling.crawlingdata.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.util.Assert;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="data")
public class CrawlingData{
	
	@Id
	@Column(name = "idx")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(length = 500, nullable = false, name="sitename")
	private String siteName;
	
	@Column(length = 500, nullable = false, name="title")
	private String title;
	
	@Column(length = 500, nullable = false, name="url")
	private String url;

	@Column(nullable = false, name = "search_time")
	private LocalDateTime searchTimeAt;
	
	@Column(nullable = false, name = "search_date")
	private LocalDate searchDateAt;

	@Builder
	public CrawlingData(Long userId, String siteName, String title, String url) {
		Assert.hasText(siteName, "siteName must not be empty");
		Assert.hasText(title, "title must not be empty");
		Assert.hasText(url, "url must not be empty");
		this.userId = userId;
		this.siteName = siteName;
		this.title = title;
		this.url = url;
		this.searchTimeAt = LocalDateTime.now();
		this.searchDateAt = LocalDate.now();
	}
	
}
