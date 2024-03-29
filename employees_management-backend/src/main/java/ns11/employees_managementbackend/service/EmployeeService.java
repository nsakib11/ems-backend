package ns11.employees_managementbackend.service;
import ns11.employees_managementbackend.dto.EmployeeDto;
import java.util.List;


public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    void deleteEmployee(Long employeeId); // Existing method

    }

