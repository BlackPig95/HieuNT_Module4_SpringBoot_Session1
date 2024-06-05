package com.ra.session1_springboot.repository;

import com.ra.session1_springboot.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepo extends JpaRepository<Department, Integer>
{
}
