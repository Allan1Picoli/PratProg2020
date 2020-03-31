package pratProg_A02;

import java.io.Serializable;


public class Pais implements Serializable{
	 
    private static final long serialVersionUID = 1L;
	private int Id;
	private String Nome, maiorPop, menorArea;
	private long populacao;
	private double area;

	

	public Pais(int Id, String Nome, long populacao, double area) {
		setId(Id);
		setNome(Nome);
		setPopulacao(populacao);
		setArea(area);
	}

	public Pais() {
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		
			Nome = nome;
		
		
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		if(populacao > 0) {
			this.populacao = populacao;
		}else {
			this.populacao = 0;
		}
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		if(area > 0) {
			this.area = area;
		}else {
			this.area = 0;
		}
	}
	
	public void setMaiorPop(String pais) {
		maiorPop = pais;
	}
	public String getMaiorPop() {
		return maiorPop;
	}

	public void setMenorArea(String pais) {
		menorArea = pais;
	}
	public String getMenorArea() {
		return menorArea;
	}
	


	@Override
	public String toString() {
		return "Id " + getId() + " Nome " + getNome() + " populacao " + getPopulacao() + " area " + getArea();
	}


}
