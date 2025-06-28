package com.sm.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.sm.dto.Admin;

public class AdminResultSetExtractor implements ResultSetExtractor<List<Admin>> {

	@Override
	public List<Admin> extractData(ResultSet res) throws SQLException, DataAccessException {
		ArrayList<Admin> adminList = new ArrayList<>();
		while(res.next()) {
			Admin newAdmin = new Admin();
			newAdmin.setAdminId(res.getInt("adminid"));
			newAdmin.setAdminName(res.getString("adminname"));
			newAdmin.setAdminEmail(res.getString("adminemail"));
			newAdmin.setAdminPassword(res.getString("adminpassword"));
			adminList.add(newAdmin);
		}
		return adminList;
	}

}
