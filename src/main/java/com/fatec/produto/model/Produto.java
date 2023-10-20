package com.fatec.produto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String descricao;
	private String categoria;
	private double custo;
	private int quantidadeNoEstoque;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		if(id > 0) {
			this.id = id;
		}
		else {
			throw new IllegalArgumentException("Id deve ser maior que 0");
		}
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		
		if(!descricao.isBlank() || !descricao.isEmpty()) {
			this.descricao = descricao;
		}	
		else {
			throw new IllegalArgumentException("A descricao nao pode ser em branca");
		}
			
	}
	
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		if(!categoria.isBlank() || !categoria.isEmpty()) {
			this.categoria = categoria;
		}
		
		else {
			throw new IllegalArgumentException("Categoria nao pode estar em branco");
		}
	}
	
	public double getCusto() {
		return custo;
	}
	
	public void setCusto(double custo) {
		if(custo > 10 && custo < 9999) {
			this.custo = custo;
		}
		else {
			throw new IllegalArgumentException("Custo deve estar entre 10 e 9999");
		}
	}
	
	public int getQuantidadeNoEstoque() {
		return quantidadeNoEstoque;
	}
	
	public void setQuantidadeNoEstoque(int quantidadeNoEstoque) {
		if(quantidadeNoEstoque > 10) {
			this.quantidadeNoEstoque = quantidadeNoEstoque;
		}
		else {
			throw new IllegalArgumentException("Quantidade deve ser maior ou igual a 10");
		}
	}

	
}
