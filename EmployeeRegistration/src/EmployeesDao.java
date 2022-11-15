import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {

	private DbConnection dbconnection ;

	public void insertEmployee(Employee employee) throws SQLException {
		try (Connection connection = dbconnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(dbconnection.insertquery);) {
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUsername());
			preparedStatement.setString(4, employee.getPassword());
			preparedStatement.setString(5, employee.getAddress());
			preparedStatement.setString(6, employee.getContactNumber());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Employee selectEmployee(int id) {
		Employee employee = null;
		try (Connection connection = dbconnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(dbconnection.selectById);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String contactNumber = rs.getString("contactnumber");
				employee = new Employee(id, firstName, lastName, username, password, address, contactNumber);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public List < Employee > selectAllEmployees() {
		List < Employee > employees = new ArrayList < > ();
		try (Connection connection = dbconnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(dbconnection.selectAllEmployee);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String contactNumber = rs.getString("contactnumber");
				employees.add(new Employee( id, firstName, lastName, username, password, address, contactNumber));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public boolean deleteEmployee(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = dbconnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(dbconnection.deleteEmployee);) {
			preparedStatement.setInt(1,id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateEmployee(Employee employee) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = dbconnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(dbconnection.updateEmployee);) {
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUsername());
			preparedStatement.setString(4, employee.getPassword());
			preparedStatement.setString(5, employee.getAddress());
			preparedStatement.setString(6, employee.getContactNumber());
			preparedStatement.setInt(7, employee.getId());
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}