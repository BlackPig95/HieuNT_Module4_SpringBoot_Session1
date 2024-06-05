package com.ra.session1_springboot.controller;

import com.ra.session1_springboot.model.entity.Department;
import com.ra.session1_springboot.model.entity.Employee;
import com.ra.session1_springboot.service.design.IDepartmentService;
import com.ra.session1_springboot.service.design.IEmployeeService;
import com.ra.session1_springboot.util.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController
{
    private final IDepartmentService departmentService;
    private final IEmployeeService employeeService;
    private final FileUploadService fileUploadService;

    @GetMapping("/list")
    public String list(Model model)
    {
        model.addAttribute("listEmployee", employeeService.findAll());
        return "employee/list";
    }

    @GetMapping("/initAdd")
    public String initAdd(Model model)
    {
        model.addAttribute("employee", new Employee());
        List<Department> departmentList = departmentService.findAll();
        model.addAttribute("listDepartment", departmentList);
        return "employee/add";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model)
    {
        List<Department> departmentList = departmentService.findAll();
        model.addAttribute("listDepartment", departmentList);
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/update";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("employee") Employee employee, @RequestParam("avatarFile") MultipartFile file, Model model)
    {
        if (file.isEmpty())
        {
            model.addAttribute("employee", new Employee());
            List<Department> departmentList = departmentService.findAll();
            model.addAttribute("listDepartment", departmentList);
            return "employee/add";
        }
        String imageUrl = fileUploadService.uploadToLocal(file);
        employee.setAvatar(imageUrl);
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @PostMapping("/update")
    public String updateEm(@ModelAttribute("employee") Employee employee, @RequestParam("avatarFile") MultipartFile file, Model model)
    {
        if (!file.isEmpty())
        {
            String imageUrl = fileUploadService.uploadToLocal(file);
            employee.setAvatar(imageUrl);
        }
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
    {
        employeeService.delete(employeeService.findById(id));
        return "redirect:/employee/list";
    }
}
