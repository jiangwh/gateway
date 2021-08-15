package com.jiangwh.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;

	@Column(unique = true)
	private String isbn;

	public Book() {
	}

	public Book(String title, String isbn) {
		this.title = title;
		this.isbn = isbn;
	}
}

