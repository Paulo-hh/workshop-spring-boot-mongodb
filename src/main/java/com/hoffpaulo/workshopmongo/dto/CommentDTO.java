package com.hoffpaulo.workshopmongo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CommentDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String text;
	private LocalDate data;
	private AuthorDTO author;
	
	public CommentDTO() {
	}

	public CommentDTO(String text, LocalDate data, AuthorDTO author) {
		this.text = text;
		this.data = data;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
}
