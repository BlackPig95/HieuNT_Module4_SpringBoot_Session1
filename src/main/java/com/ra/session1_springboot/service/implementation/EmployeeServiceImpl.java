package com.ra.session1_springboot.service.implementation;

import com.ra.session1_springboot.model.entity.Employee;
import com.ra.session1_springboot.repository.IEmployeeRepo;
import com.ra.session1_springboot.service.design.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService
{
    private final IEmployeeRepo employeeRepo;

    @Override
    public List<Employee> findAll()
    {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(Integer id)
    {
        if (id != null)
        {
            return employeeRepo.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public Employee save(Employee employee)
    {
        if (employee.getAvatar() == null)
        {
            employee.setAvatar(findById(employee.getEmployeeId()).getAvatar());
        }
        return employeeRepo.save(employee);
    }

    @Override
    public void delete(Employee employee)
    {
        employeeRepo.delete(employee);
    }
}
