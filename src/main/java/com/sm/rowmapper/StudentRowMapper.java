package com.sm.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sm.dto.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet res, int rowNum) throws SQLException {
		Student newStudent = new Student();
		newStudent.setId(res.getInt("id"));
		newStudent.setName(res.getString("name"));
		newStudent.setMobile(res.getLong("mobile"));
		newStudent.setCountry(res.getString("country"));
		newStudent.setDob(res.getDate("dob"));
		newStudent.setEmail(res.getString("email"));
		newStudent.setGender(res.getString("gender"));
		newStudent.setParentsMobile(res.getLong("parentsmobile"));
		return newStudent;
	}

}
