package ns11.employees_managementbackend.service.impl;

import lombok.AllArgsConstructor;
import ns11.employees_managementbackend.dto.EmployeeDto;
import ns11.employees_managementbackend.entity.Employee;
import ns11.employees_managementbackend.exception.ResourceNotFoundException;
import ns11.employees_managementbackend.mapper.EmployeeMapper;
import ns11.employees_managementbackend.repository.EmployeeRepository;
import ns11.employees_managementbackend.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> findEmployeesByFirstName(String firstName) {
        List<Employee> employees = employeeRepository.findByFirstName(firstName);
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((EmployeeMapper::mapToEmployeeDto))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId)
        );
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setDateOfBirth(updatedEmployee.getDateOfBirth());
        employee.setMobile(updatedEmployee.getMobile());
        employee.setCity(updatedEmployee.getCity());
        employee.setStreet1(updatedEmployee.getStreet1());
        employee.setStreet2(updatedEmployee.getStreet2());
        employee.setState(updatedEmployee.getState());
        employee.setPostal(updatedEmployee.getPostal());

        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }

}
