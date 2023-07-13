package tech.getarrays.employeemanager.mapper;

import org.mapstruct.Mapper;
import tech.getarrays.employeemanager.dto.EmployeeDto;
import tech.getarrays.employeemanager.model.Employee;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto modelToDto (final Employee employee);

    //Optional<EmployeeDto> modelToDto (final Employee employee);

    List<EmployeeDto> modelsToDtos (final List<Employee> employeeList);

    Employee dtoToModel (final EmployeeDto employeeDto);
}
