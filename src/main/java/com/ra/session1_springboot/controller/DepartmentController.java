package com.ra.session1_springboot.controller;

import com.ra.session1_springboot.model.entity.Department;
import com.ra.session1_springboot.model.entity.Employee;
import com.ra.session1_springboot.service.design.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController
{
    private final IDepartmentService departmentService;

    @GetMapping("/list")
    public String list(Model model)
    {
        List<Department> departmentList = departmentService.findAll();
        model.addAttribute("list", departmentList);
        return "department/list";
    }

    @GetMapping("/initAdd")
    public String initAdd(Model model)
    {
        model.addAttribute("department", new Department());
        return "department/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("department") Department department)
    {
        departmentService.save(department);
        return "redirect:/department/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model)
    {
        List<Department> departmentList = departmentService.findAll();
        model.addAttribute("department", departmentService.findById(id));
        return "department/update";
    }

    @PostMapping("/update")
    public String updateEm(@ModelAttribute("department") Department department)
    {
        departmentService.save(department);
        return "redirect:/department/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
    {
        departmentService.delete(departmentService.findById(id));
        return "redirect:/department/list";
    }
}
