package com.sm.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
		Object[] arg = { student.getName(), student.getMobile(), student.getCountry(), student.getDob(),
				student.getGender(), student.getEmail(), student.getParentsMobile() };
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
		Object[] arg = { student.getName(), student.getMobile(), student.getCountry(), student.getDob(),
				student.getEmail(), student.getGender(), student.getParentsMobile(), student.getId() };
		return jdbcTemplate.update(updateStudent, arg);
	}

	@Override
	public Student fetchStudentById(int id) {
		String fetchStudentById = "select * from students where id=?";
		Student student = jdbcTemplate.queryForObject(fetchStudentById, new StudentRowMapper(), id);
		return student;
	}

	// Admin Section

	@Override
	public Admin getEmailAndPassword(Admin userLogin) {
//		String getLoginCred = "select adminname,adminemail, adminpassword from admins where adminemail = ? and adminpassword = ?";
//
//		Admin dbAdmin;
//		try {
//			dbAdmin = jdbcTemplate.queryForObject(getLoginCred,
//					new Object[] { userLogin.getAdminEmail(), userLogin.getAdminPassword() }, (rs, nowNum) -> {
//						Admin admin = new Admin();
//						admin.setAdminEmail(rs.getString("adminemail"));
//						admin.setAdminPassword(rs.getString("adminpassword"));
//						admin.setAdminName(rs.getString("adminname"));
//						return admin;
//					});
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//
//		return dbAdmin;

		String getLoginCred = "SELECT adminname, adminemail, adminpassword FROM admins WHERE adminemail = ?";

		try {
			Admin dbAdmin = jdbcTemplate.queryForObject(getLoginCred, new Object[] { userLogin.getAdminEmail() },
					(rs, rowNum) -> {
						Admin admin = new Admin();
						admin.setAdminEmail(rs.getString("adminemail"));
						admin.setAdminPassword(rs.getString("adminpassword"));
						admin.setAdminName(rs.getString("adminname"));
						return admin;
					});

			// Check password match
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(userLogin.getAdminPassword(), dbAdmin.getAdminPassword())) {
				return dbAdmin;
			} else {
				return null;
			}

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int addAdmin(Admin admin) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(admin.getAdminPassword());
		String insertAdmin = "insert into admins (adminname, adminemail, adminpassword) values (?, ?, ?)";
		Object[] args = { admin.getAdminName(), admin.getAdminEmail(), encodedPassword };
		return jdbcTemplate.update(insertAdmin, args);
	}

	@Override
	public Admin fetchAdminById(int id) {
		String fetchAdminById = "select * from admins where adminid=?";
		return jdbcTemplate.queryForObject(fetchAdminById, new AdminRowMapper(), id);
	}

	@Override
	public List<Admin> fetchAdmins() {
		String fetchAllAdmins = "select * from admins";
		return jdbcTemplate.query(fetchAllAdmins, new AdminResultSetExtractor());
	}

	@Override
	public int updateAdmin(Admin admin) {
//		String updateAdmin = "update admins set adminname=?, adminemail=?, adminpassword=? where adminid=?";
//		Object[] arg = { admin.getAdminName(), admin.getAdminEmail(), admin.getAdminPassword(), admin.getAdminId() };
//		return jdbcTemplate.update(updateAdmin, arg);

		PasswordEncoder encoder = new BCryptPasswordEncoder();

		// Encrypt only if password is not empty
		String encodedPassword = admin.getAdminPassword();
		if (encodedPassword != null && !encodedPassword.trim().isEmpty()) {
			encodedPassword = encoder.encode(admin.getAdminPassword());
		} else {
			String oldPassword = jdbcTemplate.queryForObject("SELECT adminpassword FROM admins WHERE adminid=?",
					String.class, admin.getAdminId());
			encodedPassword = oldPassword;
		}

		String updateAdmin = "UPDATE admins SET adminname=?, adminemail=?, adminpassword=? WHERE adminid=?";
		Object[] args = { admin.getAdminName(), admin.getAdminEmail(), encodedPassword, admin.getAdminId() };

		return jdbcTemplate.update(updateAdmin, args);

	}

	@Override
	public int deleteAdmin(int adminId) {
		String deleteAdmin = "delete from admins where adminid=?";
		return jdbcTemplate.update(deleteAdmin, adminId);
	}

}
