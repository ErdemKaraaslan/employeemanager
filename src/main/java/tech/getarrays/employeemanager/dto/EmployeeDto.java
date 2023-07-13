package tech.getarrays.employeemanager.dto;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
public class EmployeeDto {

    @Id
    private UUID id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    //private String employeeCode;

}
