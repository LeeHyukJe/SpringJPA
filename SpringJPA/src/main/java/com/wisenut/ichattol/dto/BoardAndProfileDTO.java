package com.wisenut.ichattol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BoardAndProfileDTO {

	//"select b.bno, b.title, b.writer , p.seqno, p.name from Board b left outer join b.seqno p"
	private Long bno;
	private String title;
	private String writer;
	private Long seqno;
	private String name;
}
