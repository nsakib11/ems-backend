package ns11.employees_managementbackend.mapper;

import ns11.employees_managementbackend.dto.EmployeeDto;
import ns11.employees_managementbackend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDateOfBirth(),
                employee.getMobile(),
                employee.getCity(),
                employee.getStreet1(),
                employee.getStreet2(),
                employee.getState(),
                employee.getPostal()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDateOfBirth(),
                employeeDto.getMobile(),
                employeeDto.getCity(),
                employeeDto.getStreet1(),
                employeeDto.getStreet2(),
                employeeDto.getState(),
                employeeDto.getPostal()
        );
    }
}