import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/")
public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EmployeesDao employeesDao;

	public void init() {
		employeesDao = new EmployeesDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					insertEmployee(request, response);
					break;
				case "/delete":
					deleteEmployee(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/update":
					updateEmployee(request,response);
					break;
				default:
					listEmployee(request, response);
					break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List < Employee > listEmployee = employeesDao.selectAllEmployees();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("EmployeeForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existingEmployee = employeesDao.selectEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeForm.jsp");
		request.setAttribute("user", existingEmployee);
		dispatcher.forward(request, response);
	}

	private void insertEmployee(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contactNumber = request.getParameter("contactnumber");
		Employee nEmployee = new Employee(firstName, lastName, username, password, address, contactNumber);
		employeesDao.insertEmployee(nEmployee);
		response.sendRedirect("list");
	}

	private void updateEmployee(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contactNumber = request.getParameter("contactnumber");
		Employee employee = new Employee(id, firstName, lastName, username, password, address, contactNumber);
		employeesDao.updateEmployee(employee);
		response.sendRedirect("list");
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		employeesDao.deleteEmployee(id);
		response.sendRedirect("list");
	}

}