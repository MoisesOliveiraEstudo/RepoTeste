package com.fatec.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatec.produto.model.Produto;
import com.fatec.produto.model.ProdutoRepository;

@SpringBootApplication
public class ProdutoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}

}
