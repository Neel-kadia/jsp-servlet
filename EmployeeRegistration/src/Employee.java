import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;  

@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String contactNumber;

}