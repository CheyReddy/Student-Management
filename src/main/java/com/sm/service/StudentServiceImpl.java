package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.StudentDAO;
import com.sm.dto.Admin;
import com.sm.dto.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAOImpl;

	@Override
	public List<Student> fetchStudents() {
		return studentDAOImpl.fetchStudents();
	}

	@Override
	public int addStudent(Student student) {
		return studentDAOImpl.addStudent(student);
	}

	@Override
	public int deleteStudent(int id) {
		return studentDAOImpl.deleteStudent(id);
	}

	@Override
	public int updateStudent(Student student) {
		return studentDAOImpl.updateStudent(student);
	}

	@Override
	public Student fetchStudentById(int id) {
		return studentDAOImpl.fetchStudentById(id);
	}

	@Override
	public Admin getEmailAndPassword(Admin admin) {
		return studentDAOImpl.getEmailAndPassword(admin);
	}

	// Admin section

	@Override
	public int addAdmin(Admin admin) {
		return studentDAOImpl.addAdmin(admin);
	}

	@Override
	public Admin fetchAdminById(int id) {
		return studentDAOImpl.fetchAdminById(id);
	}

	@Override
	public List<Admin> fetchAdmins() {
		return studentDAOImpl.fetchAdmins();
	}

	@Override
	public int updateAdmin(Admin admin) {
		return studentDAOImpl.updateAdmin(admin);
	}

	@Override
	public int deleteAdmin(int adminId) {
		return studentDAOImpl.deleteAdmin(adminId);
	}

}
