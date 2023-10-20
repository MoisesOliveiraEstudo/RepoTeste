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
		produto.setQuantidadeNoEstoque(11);
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
	
	
	@Test
	void ct03_cadastrar_produto_com_descricao_nula() {
		try {
			Produto produto = new Produto();
			produto.setDescricao(new String());
			fail("Deveria disparar uma exception");
		} 
		
		catch (IllegalArgumentException e) {
			assertEquals("A descricao nao pode ser em branca", e.getMessage());
		}
	}
	
	
	@Test
	void ct04_cadastrar_com_custo_insuficiente() {
		try {
			Produto produto = new Produto();
			produto.setCusto(5);
			fail("Deveria ser maior que 10");
		}
		catch (Exception e) {
			assertEquals("Custo deve estar entre 10 e 9999", e.getMessage());
		}
	}
	
	void ct05_cadastrar_com_custo_invalido() {
		try {
			Produto produto = new Produto();
			produto.setCusto(99999);
			fail("Deveria ser menor que 9999");
		} 
		
		catch (Exception e) {
			assertEquals("Custo deve estar entre 10 e 9999", e.getMessage());
		}
	}
	
	@Test
	void ct06_cadastrar_com_qtde_insuficiente() {
		try {
			Produto produto = new Produto();
			produto.setQuantidadeNoEstoque(3);
			fail("Deveria ser maior ou igual a 10");
		}
		catch(Exception e) {
			assertEquals("Quantidade deve ser maior ou igual a 10", e.getMessage());
		}
	}
	
	@Test
	void ct07_cadastrar_com_categoria_invalida() {
		try {
			Produto produto = new Produto();
			produto.setCategoria(new String());
			fail("Deveria falhar com categoria nula");
		} 
		
		catch (Exception e) {
			assertEquals("Categoria nao pode estar em branco", e.getMessage());
		}
	}
}
