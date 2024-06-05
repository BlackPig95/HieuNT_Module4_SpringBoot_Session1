package com.ra.session1_springboot.service.design;

import com.ra.session1_springboot.model.entity.Employee;

import java.util.List;

public interface IEmployeeService
{
    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void delete(Employee employee);
}
