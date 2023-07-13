package tech.getarrays.employeemanager.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.dto.EmployeeDto;
import tech.getarrays.employeemanager.mapper.EmployeeMapper;
import tech.getarrays.employeemanager.repository.EmployeeRepository;
import tech.getarrays.employeemanager.service.EmployeeService;

import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.Specification.where;
import static tech.getarrays.employeemanager.specifications.EmployeeSpecification.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> findAll() {
        return new ResponseEntity<>(employeeMapper.modelsToDtos(employeeService.findAll()), HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable(value = "id") UUID id) {
        return new ResponseEntity<>(employeeMapper.modelToDto(employeeService.findById(id)), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeMapper.modelToDto(employeeService.addEmployee(employeeDto)), HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeMapper.modelToDto(employeeService.updateEmployee(employeeDto)), HttpStatus.OK);
    }


    @Transactional
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(value = "id") UUID id) {
        employeeService.deleteById(id);
    }

    @GetMapping("/{name}/{jobTitle}")
    public List<EmployeeDto> findByNameAndJobTitle(@PathVariable("name") String name, @PathVariable("jobTitle") String jobTitle) {

        return employeeMapper.modelsToDtos(employeeService.findByNameAndJobTitle(where(hasName(name).and(hasJobTitle(jobTitle)))));

    }

    @GetMapping("/{name}")
    public List<EmployeeDto> findByName(@PathVariable("name") String name) {


        return employeeMapper.modelsToDtos(employeeService.findByName(containsName(name)));
    }


}






