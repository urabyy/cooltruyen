package com.uraby.cooltruyen.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
	//private Integer id;
	private String title;
	private List<Integer> categoryIds;
	private List<Integer> authorIds;
}
