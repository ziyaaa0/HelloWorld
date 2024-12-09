package com.yedam.vo;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * VO: value Object
 * Lombok 사용 1. Lombok 다운로드 설치
 * 	          2. Lombok 라이브러리 다운로드
 *           3. eclipse 재실행
 *           
 */

//@Getter
//@Setter
//@ToString

//Data 하나로 getter setter toString 다 가져와짐
@Data
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private int viewCnt;
	private Date creationDate;
	private Date updateDate;
}
