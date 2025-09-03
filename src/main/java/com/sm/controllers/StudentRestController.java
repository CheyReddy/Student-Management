package com.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.dto.Admin;
import com.sm.dto.Student;
import com.sm.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Student Management APIs", description = "CRUD APIs for Students and Admins")
public class StudentRestController {

    @Autowired
    private StudentService studentServiceImpl;

    @Operation(summary = "Fetch all students", description = "Returns a list of all students")
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentServiceImpl.fetchStudents();
    }

    @Operation(summary = "Fetch student by ID", description = "Returns student details by ID")
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentServiceImpl.fetchStudentById(id);
    }

    @Operation(summary = "Add a new student", description = "Creates a new student")
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {
        int inserted = studentServiceImpl.addStudent(student);
        return inserted == 1 ? "Student added successfully" : "Failed to add student";
    }

    @Operation(summary = "Update student", description = "Updates an existing student by ID")
    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        int updated = studentServiceImpl.updateStudent(student);
        return updated == 1 ? "Student updated successfully" : "Failed to update student";
    }

    @Operation(summary = "Delete student", description = "Deletes student by ID")
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentServiceImpl.deleteStudent(id);
        return "Student deleted successfully";
    }

    @Operation(summary = "Fetch all admins", description = "Returns a list of all admins")
    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return studentServiceImpl.fetchAdmins();
    }

    @Operation(summary = "Fetch admin by ID", description = "Returns admin details by ID")
    @GetMapping("/admins/{id}")
    public Admin getAdminById(@PathVariable int id) {
        return studentServiceImpl.fetchAdminById(id);
    }

    @Operation(summary = "Add new admin", description = "Creates a new admin")
    @PostMapping("/admins")
    public String addAdmin(@RequestBody Admin admin) {
        int inserted = studentServiceImpl.addAdmin(admin);
        return inserted == 1 ? "Admin added successfully" : "Failed to add admin";
    }

    @Operation(summary = "Update admin", description = "Updates an existing admin by ID")
    @PutMapping("/admins/{id}")
    public String updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
        admin.setAdminId(id);
        int updated = studentServiceImpl.updateAdmin(admin);
        return updated == 1 ? "Admin updated successfully" : "Failed to update admin";
    }

    @Operation(summary = "Delete admin", description = "Deletes admin by ID")
    @DeleteMapping("/admins/{id}")
    public String deleteAdmin(@PathVariable int id) {
        studentServiceImpl.deleteAdmin(id);
        return "Admin deleted successfully";
    }
}
