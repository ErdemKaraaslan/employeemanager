package tech.getarrays.employeemanager.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.getarrays.employeemanager.dto.EmployeeDto;
import tech.getarrays.employeemanager.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID>, JpaSpecificationExecutor<Employee> {


   /* @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> findAll();*/

    //Optional<Object> idi , hata verdi ben de değiştirdim.aşağısı için
    //Optional<Employee> idi , hata verdi ben de değiştirdim.aşağısı için
    /*@Query(value = "SELECT * FROM employee e WHERE e.id = :id", nativeQuery = true)
    Employee findEmployeeById(@Param("id") UUID id);*/


    /*@Modifying
    @Transactional
    @Query(value =
            //"""

            //nativequery olmadan yaz.

            //"""
            "INSERT INTO employee VALUES " +
                    "( " +
                    ":#{#employee.id}, " +
                    ":#{#employee.email}, " +
                    ":#{#employee.employeeCode}, " +
                    ":#{#employee.imageUrl}, " +
                    ":#{#employee.jobTitle}, " +
                    ":#{#employee.name}, " +
                    ":#{#employee.phone})", nativeQuery = true)
    Employee addEmployee(@Param("employee") Employee employee);*/


  /*  @Modifying
    @Transactional
    @Query(value = "update employee e set e.email =:#{#employee.email} where e.id =:#{#employee.id}", nativeQuery = true)
    void updateEmployee(@Param("employee") Employee employee);*/

    /*@Modifying
    @Query(value = "delete from employee e WHERE e.id = :id", nativeQuery = true)
    Employee deleteEmployeeById(@Param("id") UUID id);*/


}
