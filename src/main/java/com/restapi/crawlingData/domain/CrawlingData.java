package com.restapi.crawlingData.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import org.jsoup.select.Elements;
import org.springframework.util.Assert;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity(name="data")
public class CrawlingData{
	
	@Id
	@Column(name = "idx")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	private Long userId;
	
	@Column(length = 500, nullable = false)
	private String siteName;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(length = 500, nullable = false)
	private String url;
//	private String searchInfo;
	private LocalDateTime searchTimeAt;
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
