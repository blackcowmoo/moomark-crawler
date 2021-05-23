package com.restapi.crawlingdata.domain;

import java.util.HashMap;
import java.util.Map;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingSetting {

	private String url;
	private String keyword;
	private HashMap<String, String> parameters = new HashMap<String, String>();

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public void addParameter(String name, String key) {
		this.parameters.put(name, key);
	}

	public String viewWebPage(Document doc) {
		String value = null;
		try {
			value = doc.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public Document getConnectInfo() throws IOException {
		return Jsoup.connect(makeUrl()).get();
	}

	public Document readWebPage() {
		Document result = null;
		try {
			result = getConnectInfo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
