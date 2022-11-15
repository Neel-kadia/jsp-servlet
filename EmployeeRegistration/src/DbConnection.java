import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private String dbUrl = "jdbc:mysql://localhost:3306/employees";
	private String dbUsername = "root";
	private String dbPassword = "root";
	private String dbsql = "com.mysql.cj.jdbc.Driver";
	public String insertquery = "INSERT INTO employee (firstname, lastname, username, password, address, contactnumber) VALUES (?, ?, ?, ?, ?, ?);";
	public String selectById = "SELECT id, firstname, lastname, username, password, address, contactnumber FROM employee WHERE id = ?";
	public String selectAllEmployee = "SELECT * FROM employee";
	public String deleteEmployee = "DELETE FROM employee WHERE id = ?";
	public String updateEmployee = "UPDATE employee SET firstname = ?, lastname = ?, username = ?, password = ?, address = ?, contactnumber = ? WHERE id =?; ";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(dbsql);
			connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

}