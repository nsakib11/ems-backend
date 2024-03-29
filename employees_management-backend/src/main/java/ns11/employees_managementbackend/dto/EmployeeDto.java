package ns11.employees_managementbackend.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public Date dateOfBirth;
    public String mobile;
    public String city;
    public String street1;
    public String street2;
    public String state;
    public String postal;
}
