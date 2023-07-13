package tech.getarrays.employeemanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.dto.EmployeeDto;
import tech.getarrays.employeemanager.mapper.EmployeeMapper;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repository.EmployeeRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    public Employee findById(UUID id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee addEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.dtoToModel(employeeDto);
        employee.setId(UUID.randomUUID());
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }


    public Employee updateEmployee(EmployeeDto dto) {
        Employee employee = employeeRepository.findById(dto.getId()).orElse(null);

        if (dto.getEmail() != null) {
            employee.setEmail(dto.getEmail());
        }

        if (dto.getName() != null) {
            employee.setName(dto.getName());
        }

        if (dto.getPhone() != null) {
            employee.setPhone(dto.getPhone());
        }


        if (dto.getImageUrl() != null) {

            employee.setImageUrl(dto.getImageUrl());
        }

        if (dto.getJobTitle() != null) {

            employee.setJobTitle(dto.getJobTitle());
        }

        return employeeRepository.save(employee);

    }


    public void deleteById(UUID id) {
        employeeRepository.deleteById(id);
    }


    public List<Employee> findByNameAndJobTitle(Specification<Employee> where) {
        return employeeRepository.findAll(where);
    }

    public List<Employee> findByName(Specification<Employee> where) {
        return employeeRepository.findAll(where);
    }

}
