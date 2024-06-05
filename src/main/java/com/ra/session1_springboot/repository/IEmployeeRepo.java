package com.ra.session1_springboot.repository;

import com.ra.session1_springboot.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Integer>
{
}
