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
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		
		if(descricao == null) {
			throw new IllegalArgumentException("A descrição não pode ser em branca");
		}	
		else {
			if(descricao.isBlank()) throw new IllegalArgumentException("A descricao nao pode ser em branca");
			else {
				this.descricao = descricao;
			}
		}
			
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public double getCusto() {
		return custo;
	}
	
	public void setCusto(double custo) {
		this.custo = custo;
	}
	
	public int getQuantidadeNoEstoque() {
		return quantidadeNoEstoque;
	}
	
	public void setQuantidadeNoEstoque(int quantidadeNoEstoque) {
		this.quantidadeNoEstoque = quantidadeNoEstoque;
	}

	
}
