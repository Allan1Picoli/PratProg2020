package pratProg_A02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
static {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
throw new RuntimeException(e);
}
}
// Obtémconexãocom o bancodedados
public static Connection obtemConexao() throws SQLException {
return DriverManager.getConnection("jdbc:mysql://localhost/mydb?user=root&password=allan&useTimezone=true&serverTimezone=UTC");
}
}