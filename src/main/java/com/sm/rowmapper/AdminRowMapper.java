package com.sm.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sm.dto.Admin;

public class AdminRowMapper implements RowMapper<Admin> {

	@Override
	public Admin mapRow(ResultSet res, int rowNum) throws SQLException {

		Admin admin = new Admin();
		admin.setAdminId(res.getInt("adminid"));
		admin.setAdminName(res.getString("adminname"));
		admin.setAdminEmail(res.getString("adminemail"));
		admin.setAdminPassword(res.getString("adminpassword"));
		return admin;
	}

}
