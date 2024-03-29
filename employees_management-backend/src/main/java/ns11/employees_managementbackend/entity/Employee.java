package ns11.employees_managementbackend.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE) // Use TemporalType.DATE for storing date only without time
    private Date dateOfBirth;

    @Column(name = "mobile", unique = true)
    private String mobile;

    @Column(name = "city")
    private String city;


    @Column(name = "street1")
    private String street1;

    @Column(name = "street2")
    private String street2;

    @Column(name = "state")
    private String state;

    @Column(name = "postal")
    private String postal;
}
