package tech.getarrays.employeemanager.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import tech.getarrays.employeemanager.model.Employee;

@Component
public class EmployeeSpecification {

    public static Specification<Employee> hasName(String name){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"),name));
    }

    public static Specification<Employee> hasJobTitle(String jobTitle){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("jobTitle"),jobTitle));
    }

    public static Specification<Employee> containsName(String name){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"),"%"+ name + "%"));
    }
}
