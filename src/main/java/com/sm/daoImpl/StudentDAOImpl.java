package com.sm.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sm.dao.StudentDAO;
import com.sm.dto.Admin;
import com.sm.dto.Student;
import com.sm.resultsetextractor.AdminResultSetExtractor;
import com.sm.resultsetextractor.StudentResultSetExtractor;
import com.sm.rowmapper.AdminRowMapper;
import com.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> fetchStudents() {
		String fetchAllStudents = "select * from students";

		List<Student> studentsList = jdbcTemplate.query(fetchAllStudents, new StudentResultSetExtractor());

		return studentsList;
	}

	@Override
	public int addStudent(Student student) {
		String insertStudent = "insert into students (name,mobile,country,dob,gender,email,parentsmobile)values(?,?,?,?,?,?,?)";
		Object[] arg = { student.getName(), student.getMobile(), student.getCountry(), student.getDob(), student.getGender(), student.getEmail(), student.getParentsMobile()};
		return jdbcTemplate.update(insertStudent, arg);
	}

	@Override
	public int deleteStudent(int id) {
		String deleteStudent = "delete from students where id=?";
		return jdbcTemplate.update(deleteStudent, id);
	}

	@Override
	public int updateStudent(Student student) {
		String updateStudent = "update students set name=?, mobile=?, country=? , dob=?, email=?, gender=?, parentsmobile=? where id=?";
		Object[] arg = { student.getName(), student.getMobile(), student.getCountry(), student.getDob(), student.getEmail(), student.getGender(), student.getParentsMobile(), student.getId() };
		return jdbcTemplate.update(updateStudent, arg);
	}

	@Override
	public Student fetchStudentById(int id) {
		String fetchStudentById = "select * from students where id=?";
		Student student = jdbcTemplate.queryForObject(fetchStudentById, new StudentRowMapper(), id);
		return student;
	}

	@Override
	public Admin getEmailAndPassword(Admin userLogin) {
		String getLoginCred = "select adminname,adminemail, adminpassword from admins where adminemail = ? and adminpassword = ?";

		Admin dbAdmin;
		try {
			dbAdmin = jdbcTemplate.queryForObject(getLoginCred,
					new Object[] {userLogin.getAdminEmail(), userLogin.getAdminPassword()}, (rs, nowNum) -> {
						Admin admin = new Admin();
						admin.setAdminEmail(rs.getString("adminemail"));
						admin.setAdminPassword(rs.getString("adminpassword"));
						admin.setAdminName(rs.getString("adminname"));
						return admin;
					});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return dbAdmin;
	}


	// Admin Section

	@Override
	public int addAdmin(Admin admin) {
		String insertStudent = "insert into admins (adminname,adminemail,adminpassword)values(?,?,?)";
		Object[] arg = { admin.getAdminName(),admin.getAdminEmail(),admin.getAdminPassword() };
		return jdbcTemplate.update(insertStudent, arg);
	}

	@Override
	public Admin fetchAdminById(int id) {
		String fetchAdminById = "select * from admins where adminid=?";
		return jdbcTemplate.queryForObject(fetchAdminById, new AdminRowMapper(), id);
	}

	@Override
	public List<Admin> fetchAdmins() {
		String fetchAllAdmins = "select * from admins";
		return jdbcTemplate.query(fetchAllAdmins,new AdminResultSetExtractor());
	}

	@Override
	public int updateAdmin(Admin admin) {
		String updateAdmin = "update admins set adminname=?, adminemail=?, adminpassword=? where adminid=?";
		Object[] arg = { admin.getAdminName(), admin.getAdminEmail(), admin.getAdminPassword(), admin.getAdminId() };
		return jdbcTemplate.update(updateAdmin, arg);
	}

	@Override
	public int deleteAdmin(int adminId) {
		String deleteAdmin = "delete from admins where adminid=?";
		return jdbcTemplate.update(deleteAdmin, adminId);
	}

}
