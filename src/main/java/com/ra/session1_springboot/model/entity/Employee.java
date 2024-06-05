package com.ra.session1_springboot.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee
{
    //    -	EmpId
//-	Fullname
//-	DepartId (foreign key)
//-	Gender
//-	Birtday
//-	Position
//-	Salary
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;
    @Column(name = "gender")
    private Boolean gender;
    @Column(name = "birthday", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;
    @Column(name = "position", length = 50)
    private String position;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "avatar")
    private String avatar;
    @ManyToOne
    @JoinColumn(name = "depart_id", referencedColumnName = "department_id")
    private Department department;
}
