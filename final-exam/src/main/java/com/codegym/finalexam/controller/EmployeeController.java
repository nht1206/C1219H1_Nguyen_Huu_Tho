package com.codegym.finalexam.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.codegym.finalexam.dao.EmployeeRepository;
import com.codegym.finalexam.model.Employee;
import com.codegym.finalexam.model.EmployeeGroup;
import com.codegym.finalexam.service.EmployeeGroupService;
import com.codegym.finalexam.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    EmployeeService employeeService;
    EmployeeGroupService employeeGroupService;
    EmployeeRepository employeeRepository;

    /**
     * @param employeeService the employeeService to set
     */
    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * @param employeeGroupService the employeeGroupService to set
     */
    @Autowired
    public void setEmployeeGroupService(EmployeeGroupService employeeGroupService) {
        this.employeeGroupService = employeeGroupService;
    }

    /**
     * @param employeeRepository the employeeRepository to set
     */
    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @ModelAttribute("employeeGroups")
    public List<EmployeeGroup> employeeGroups() {
        return employeeGroupService.findAll();
    }

    @GetMapping
    public String dashboard() {
        return "index";
    }

    @GetMapping(value = "/employees")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employee/list";
    }

    @GetMapping(value = "/create")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping(value = "/create")
    public String processCreateEmployee(@ModelAttribute @Valid Employee employee, BindingResult result) {
        if (result.hasFieldErrors()) {
            return "employee/create";
        }
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping(value = "/edit/{id}")
    public String editEmployee(Model model, @PathVariable String id) {
        if (!employeeService.findById(id).isPresent()) {
            return "redirect:/employees";
        }
        model.addAttribute("employee", employeeService.findById(id).orElse(null));
        return "employee/edit";
    }

    @PostMapping(value = "/update")
    public String processEditEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult result) {
        if (result.hasFieldErrors())
            return "employee/edit";
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        if (id.isEmpty())
            return "redirect:/employees";
        else {
            if (!employeeService.findById(id).isPresent()) {
                return "redirect:/employees";
            }
        }
        employeeService.remove(id);
        return "redirect:/employees";
    }

    @GetMapping(value = "/search")
    public String processSearch(Model model, 
        @RequestParam(name = "employeeCode", required = false, defaultValue = "") String employeeCode,
        @RequestParam(name = "idCardNumber", required = false, defaultValue = "") String idCardNumber,
        @RequestParam(name = "dateOfBirth", required = false, defaultValue = "") 
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date dateOfBirth
    ) {
        List<Employee> employees; 
        if (dateOfBirth == null) {
            employees = employeeRepository.findByEmployeeCodeContainingAndIdCardNumberContaining(employeeCode, idCardNumber);
        } else {
            employees = employeeRepository.findByEmployeeCodeContainingAndIdCardNumberContainingAndDateOfBirth(employeeCode, idCardNumber, dateOfBirth);
        }
        model.addAttribute("employees", employees);
        return "employee/list";
    }
    
    
    
}