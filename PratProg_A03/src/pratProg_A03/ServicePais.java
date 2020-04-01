package pratProg_A03;

import java.util.ArrayList;

public class ServicePais {
	PaisDao dao = new PaisDao();

	public int criar(Pais pais) {
		return dao.criar(pais);
	}
	public Pais carregar(int Id) {
		return dao.carregar(Id);
	}
	
	public void atualizar(Pais pais) {
		dao.atualizar(pais);
	}

	public void excluir(int Id) {
		dao.excluir(Id);
	}

	
	public Pais maiorPopulacao() {
		return dao.MaiorPOP();
	}

	public Pais menorArea() {
		return dao.MenorArea();
	}


	public ArrayList<Pais> CriarVetor() {
		return dao.CriarVetor();
	}



}
