package com.sm.dao;

import java.util.List;

import com.sm.dto.Admin;
import com.sm.dto.Student;

public interface StudentDAO {
	List<Student> fetchStudents();
	int addStudent(Student student);
	int deleteStudent(int id);
	int updateStudent(Student student);
	Student fetchStudentById(int id);
	Admin getEmailAndPassword(Admin userLogin);


	int addAdmin(Admin admin);
	Admin fetchAdminById(int id);
	List<Admin> fetchAdmins();
	int updateAdmin(Admin admin);
	int deleteAdmin(int adminId);
}
