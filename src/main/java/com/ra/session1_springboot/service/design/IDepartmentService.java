package com.ra.session1_springboot.service.design;

import com.ra.session1_springboot.model.entity.Department;

import java.util.List;

public interface IDepartmentService
{
    List<Department> findAll();

    Department findById(Integer id);

    Department save(Department department);

    void delete(Department department);
}
