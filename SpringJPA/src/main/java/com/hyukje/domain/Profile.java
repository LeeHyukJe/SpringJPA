package com.hyukje.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_profile")
@NoArgsConstructor
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seqno;
	
	private String name;
	private String title;
	
	@ManyToOne
	private Board board;
	
}
