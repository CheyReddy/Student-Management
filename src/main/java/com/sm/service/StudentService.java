package com.sm.service;

import java.util.List;

import com.sm.dto.Admin;
import com.sm.dto.Student;

public interface StudentService {

	List<Student> fetchStudents();
	int addStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int id);
	Student fetchStudentById(int id);
	Admin getEmailAndPassword(Admin admin);

	int addAdmin(Admin admin);
	Admin fetchAdminById(int id);
	List<Admin> fetchAdmins();
	int updateAdmin(Admin admin);
	int deleteAdmin(int adminId);
}
