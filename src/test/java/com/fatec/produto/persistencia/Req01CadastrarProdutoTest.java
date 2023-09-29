package com.fatec.produto.persistencia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.produto.model.Produto;
import com.fatec.produto.model.ProdutoRepository;

@SpringBootTest
class Req01CadastrarProdutoTest {

	@Autowired
	ProdutoRepository repository;
	
	@Test
	void cdt01_cadastrar_produto_com_sucesso() {
		/*
		 * dado que não existe nenhum registro cadastrado,
		 * quando o usuario cadastra um produto,
		 * entao o produto fica disponivel para consulta
		 *  
		 */
		repository.deleteAll();
		Produto produto = new Produto();
		produto.setDescricao("Eletrobomba 110v para maquina de lavar");
		produto.setCategoria("Maquina de Lavar");
		produto.setCusto(51.66);
		produto.setQuantidadeNoEstoque(10);
		Produto p = repository.save(produto);
		assertEquals(1, repository.count());
		assertNotNull(p);
	}

	@Test
	void ct02_cadastrar_produto_com_descricao_invalida() {
		try {
			Produto produto = new Produto();
			produto.setDescricao("");
			fail("Deveria disparar uma exception");
		} 
		
		catch (IllegalArgumentException e) {
			assertEquals("A descricao nao pode ser em branca", e.getMessage());
		}
	}
}
