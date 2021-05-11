package com.restapi.JobKorea.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.jsoup.select.Elements;


import javax.persistence.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="JobKorea")
public class JobKorea implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String url;
	
	private Elements links;
}
