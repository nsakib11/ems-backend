package ns11.employees_managementbackend.repository;

import ns11.employees_managementbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
