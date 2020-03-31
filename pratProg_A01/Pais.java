package pratProg_A01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Pais {
	private int Id;
	private String Nome, maiorPop, menorArea;
	private long populacao;
	private double area;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public Pais(int Id, String Nome, long populacao, double area) {
		setId(Id);
		setNome(Nome);
		setPopulacao(populacao);
		setArea(area);
	}

	public Pais() {
	}

	// Obtém conexão com o banco de dados
	public Connection obtemConexao() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost:3306/atividade?user=root&password=allan&useSSL=false");
	}
	public void criar() {
		String sqlInsert = "INSERT INTO Pais (nome, populacao, area) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void atualizar() {
		String sqlUpdate = "UPDATE Pais SET nome=?, populacao=?, area= ? WHERE id = ? ";

		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.setInt(4, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir() {

		String sqlDelete = "DELETE FROM Pais WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void carregar() {
		String sqlSelect = "SELECT nome, populacao, area FROM Pais WHERE Pais.id =?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
					setArea(rs.getDouble("area"));
				} else {
					setId(-1);
					setNome("");
					setPopulacao(0);
					setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
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
		if(nome.length() > 0) {
			Nome = nome;
		}else {
			Nome = "";
		}
		
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
	
	
	public void MaiorPopulacao() {
		String sqlSelect = "SELECT  Nome, max(populacao) FROM Pais group by id order by populacao desc;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setMaiorPop(rs.getString("Nome"));
				} else {

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}

	public void MenorArea() {
		String sqlSelect = "SELECT  id, nome, MIN(area) FROM Pais GROUP BY id ORDER BY area ASC;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setMenorArea(rs.getString("Nome"));
				} else {

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}

	public ArrayList<Pais> CriaVetor() {
		ArrayList<Pais>  pais = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, populacao , area FROM Pais ;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				for(int i = 0; i < 3; i++) {
					if (rs.next()) {
						Pais p = new Pais();
						p.setId(rs.getInt("id"));
						p.setNome(rs.getString("Nome"));
						p.setPopulacao(rs.getLong("populacao"));
						p.setArea(rs.getDouble("area"));
						pais.add(p);
					} 

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pais;
	}



	@Override
	public String toString() {
		return "Id " + getId() + " Nome " + getNome() + " populacao " + getPopulacao() + " area " + getArea();
	}


}
