package com.cos.board.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data -> Getter, Setter 합쳐진 것
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder //빌더 패턴
@ToString
@Entity// ORM
public class Board {
	@Id //프라이머리키를 알려줌
	@GeneratedValue(strategy = GenerationType.IDENTITY)// 해당 데이터베이스 번호 증가 전략을 따라가기
	private int id;
	private String title;
	private String content;
	private int readCount;
	@CreationTimestamp
	private Timestamp createDate; 
	
	public String getCreateDate() {
		
		return createDate.toString().substring(0, 10);
	} 
}
