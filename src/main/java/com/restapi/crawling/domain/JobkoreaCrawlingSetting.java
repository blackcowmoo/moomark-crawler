package com.restapi.crawling.domain;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JobkoreaCrawlingSetting implements CrawlingSetDefault {
	private final String url = CrawlingSiteUrl.JOBKOREA.getUrl();
	private String keyWord;
	private HashMap<String, String> parameters = new HashMap<>();

	@Override
	public String getUrl() {
		return this.url;
	}

	@Override
	public void setKeword(String keyword) {
		this.keyWord = keyword;
	}

	@Override
	public String getKeword() {
		return this.keyWord;
	}

	@Override
	public void setParameter(String key, String data) {
		this.parameters.put(key, data);
	}

	public Elements startCrawling() throws IOException {
		setParameter("stext", keyWord);
		setParameter("IsCoInfoSC", "false");
		setParameter("IsRecruit", "false");
		setParameter("ord", "1");
		setParameter("Order", "1");
		setParameter("page", "2");
		setParameter("PageSize", "10");
		setParameter("pageType", "HRP");
		Document doc = Jsoup.connect(makeUrl()).get();
		return doc.select(".list-post .post .post-list-info .title");
	}

	public String makeUrl() {
		var result = new StringBuilder();
		result.append(url);
		for (Map.Entry<String, String> entry : parameters.entrySet()) {
			String parameter = entry.getKey();
			result.append(parameter);
			result.append("=");
			result.append(parameters.get(parameter) + "&");
		}
		return result.substring(0, result.length() - 1);
	}
}
