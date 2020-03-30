package pratProg_A01;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {
	Pais pais, copia;
	static int id = 1;

	@Before
	public void setUp() throws Exception {
		System.out.println("Configurando");
		pais = new Pais(id, "Brasil", 210147125 ,8515767.00);
		copia = new Pais(id, "Brasil", 210147125 ,8515767.00);
		System.out.println("=================");
		System.out.println(pais);
		System.out.println(copia);
		System.out.println("=================");
		System.out.println(id);
		System.out.println("Pais"+pais.getId() + "copia:"+copia.getId());
	}


	@Test
	public void test00Carregar() {
		Pais fixture = new Pais(1, "Brasil", 210147125, 8515767.00);
		Pais novo = new Pais(1,"",0, 0.0);
		novo.carregar();
		assertEquals("Carregando", novo.toString(),fixture.toString());

	}

	@Test
public void test01Criar() {
		System.out.println("==============");
		System.out.println("Criar");
		pais.criar();
		id = pais.getId();
		copia.setId(id);
		assertEquals("Teste de inclusao", copia.toString(),pais.toString());
		System.out.println("==============");
	}




	@Test
	public void test02Atualizar() {
		System.out.println("=======================");
		System.out.println("Atualizar");
		pais.setArea(77.4);
		copia.setArea(77.4);
		pais.atualizar();
		pais.carregar();
		assertEquals("Testa atualização", copia.toString(),pais.toString());
	}

	@Test
public	void test03Excluir() {
		System.out.println("=======================");
		System.out.println("Excluir");
		copia.setId(-1);
		copia.setNome("");
		copia.setPopulacao(0);
		copia.setArea(0);
		pais.excluir();
		pais.carregar();
		assertEquals("Testa atualização",copia.toString(),pais.toString());
	}	

	

	@Test
	public void test04MaiorPopulacao() {
		pais.MaiorPopulacao();
		assertEquals("Testa Maior população", "China", pais.getMaiorPop());
		
	}
	

	@Test
public	void test05MenorArea() {
		pais.MenorArea();
		assertEquals("Testa menor Area: ", "Japão", pais.getMenorArea());
	}

	@Test
public	void test06CriaVetor() {
		String confere = "Id 1 Nome Brasil populacao 210147125 area 77.4\n" + 
				"Id 2 Nome Argentina populacao 43590368 area 2780400.0\n" + 
				"Id 3 Nome Paraguai populacao 7152703 area 406752.0";
		ArrayList<Pais> vetor = new ArrayList<>();
		vetor = pais.CriaVetor();
		String msg = "";
		 for (Pais vet : vetor) {
	            msg = msg+ vet+"\n";
	        }
		
		System.out.println(msg);
		assertEquals("Testa vetor: ",confere, msg );
	}
	 
}