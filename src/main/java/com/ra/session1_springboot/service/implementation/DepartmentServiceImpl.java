package com.ra.session1_springboot.service.implementation;

import com.ra.session1_springboot.model.entity.Department;
import com.ra.session1_springboot.repository.IDepartmentRepo;
import com.ra.session1_springboot.service.design.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService
{
    private final IDepartmentRepo departmentRepo;

    @Override
    public List<Department> findAll()
    {
        return departmentRepo.findAll();
    }

    @Override
    public Department findById(Integer id)
    {
        if (id != null)
        {
            return departmentRepo.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public Department save(Department department)
    {
        return departmentRepo.save(department);
    }

    @Override
    public void delete(Department department)
    {
        departmentRepo.delete(department);
    }
}
