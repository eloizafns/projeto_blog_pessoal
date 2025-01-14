package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity                       // indicar que a classe é uma tabela
@Table(name = "tb_postagens") // indica o nome da tabela no bd
public class Postagem {
	
	@Id //Ele é a chave primária(PRIMARY KEY)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
	private Long id; 
	
	@NotBlank(message = "Esse campo é obrigatório!") //parecido com NOT NULL
	@Size(min = 5, max = 100, message = "Digite no mínimo 5 e no máximo 100 caracteres.")
	private String titulo;
	
	@NotBlank(message = "Esse campo é obrigatório!") //parecido com NOT NULL
	@Size(min = 10, max = 1000, message = "Digite no mínimo 10 e no máximo 1000 caracteres.")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data; //10/10/25 10:23:28
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	

}
