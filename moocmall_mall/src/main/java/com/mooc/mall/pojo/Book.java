package com.mooc.mall.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="book")
public class Book implements Serializable{

	@Id
	private Long id;//


	
	private String name;//
	private String writer;//
	private String introduction;//

	
	public Long getId() {		
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getWriter() {		
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getIntroduction() {		
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", name='" + name + '\'' +
				", writer='" + writer + '\'' +
				", introduction='" + introduction + '\'' +
				'}';
	}
}
