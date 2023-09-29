package com.fatec.produto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.produto.model.Produto;

@SpringBootTest
class ProdutoApplicationTests {

	@Test
	void contextLoads() {
		Produto produto = new Produto();
		produto.setDescricao(null);
	}

}
