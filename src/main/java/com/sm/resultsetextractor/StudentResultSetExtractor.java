package com.sm.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.sm.dto.Student;

public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>> {

	@Override
	public List<Student> extractData(ResultSet res) throws SQLException, DataAccessException {
		ArrayList<Student> studentsList = new ArrayList<>();
		while(res.next()) {
			Student newStudent = new Student();
			newStudent.setId(res.getInt("id"));
			newStudent.setName(res.getString("name"));
			newStudent.setMobile(res.getString("mobile"));
			newStudent.setCountry(res.getString("country"));
			studentsList.add(newStudent);
		}
		return studentsList;
	}

}
