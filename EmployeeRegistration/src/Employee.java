import lombok.AllArgsConstructor;  
import lombok.Getter;  
import lombok.NoArgsConstructor;  
import lombok.Setter;  

@NoArgsConstructor  
@AllArgsConstructor  
public class Employee {

	private @Getter @Setter int id;
	private @Getter @Setter String firstName;
	private @Getter @Setter String lastName;
	private @Getter @Setter String username;
	private @Getter @Setter String password;
	private @Getter @Setter String address;
	private @Getter @Setter String contactNumber;

}