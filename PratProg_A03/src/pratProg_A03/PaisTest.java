package pratProg_A03;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runners.MethodSorters;




@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PaisTest {
	Pais pais, copia;
	ServicePais Service;
	static int id = 0;

	@Before
	public void setUp() throws Exception {
		System.out.println("Configurando");
		pais = new Pais(id, "China", 203040400, 12399459);
		copia = new Pais(id, "China", 203040400, 12399459);
		System.out.println(id);
		System.out.println(pais);
		System.out.println(copia);
	}

	@Test
	public void test00Carregar() {
		System.out.println("Carregando");
		Pais fixture = new Pais(1, "China", 203040400, 12399459);
		ServicePais novoService = new ServicePais();
		Pais novo = novoService.carregar(1);
		assertEquals("Testa ", fixture.toString(),novo.toString());

	}

	@Test
	public void test01Criar() {
		System.out.println("Criar");
		Pais fixture = new Pais(1, "China", 203040400, 12399459);
		ServicePais novoService = new ServicePais();
		int id = novoService.criar(fixture);
		Pais novo = novoService.carregar(id);
		assertEquals("teste Criando pais", fixture.toString(), novo.toString());

	}


	@Test
	public void test02Atualizar() {
		Pais fixture = new Pais(1, "China", 203040400, 12399459);
		ServicePais novoService = new ServicePais();
		int id = novoService.criar(fixture);
		Pais novo = novoService.carregar(id);
		System.out.println("Atualizando");
		novo.setNome("Bolivia");
		fixture.setNome("Bolivia");
		novoService.atualizar(fixture);
		fixture = novoService.carregar(id);
		assertEquals("Testa atualização", novo.toString(),fixture.toString());
	}


	@Test
	public void test03Excluir() {
		Pais pais = new Pais(id, "China", 203040400, 12399459);
		Pais copia = new Pais();
		System.out.println("=======================");
		System.out.println("Excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		ServicePais novoService = new ServicePais();
		id = novoService.criar(pais);
		novoService.excluir(id);
		pais = novoService.carregar(pais.getId());
		assertEquals("Testa atualização",copia.toString(),pais.toString());

	}

	@Test
	public void test04MaiorPopulacao() {
		Pais pais = new Pais();
		ServicePais novoService = new ServicePais();

		pais = novoService.maiorPopulacao();
		System.out.println(pais.toString());
		assertEquals("Maior população", "Id 6 Nome India populacao 1379302771 area 9596961", pais.toString());

	}



	@Test
	public void test05MenorArea() {
		Pais pais = new Pais();
		ServicePais novoService = new ServicePais();

		pais = novoService.menorArea();
		System.out.println(pais.toString());
		assertEquals("Maior população", "Id 10 Nome Japão populacao 126440000 area 377975.0", pais.toString());

	}

	
}
