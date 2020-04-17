package devops.medical.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import devops.medical.model.Admin;
import devops.medical.model.AdminLogin;

public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Admin check(AdminLogin adminlogin) {
		String sql = "select * from Admin where id ='"+adminlogin.getId()+"' and password='"+adminlogin.getPassword()+"'";
		List<Admin> admins = jdbcTemplate.query(sql, new AdminMapper());
		return admins.size()>0?admins.get(0):null;
	}
}
class AdminMapper implements RowMapper<Admin>{
	public Admin mapRow(ResultSet rs, int arg1) throws SQLException{
		Admin admin = new Admin();
		admin.setId(rs.getString("id"));
		admin.setUsername(rs.getString("name"));
		admin.setPassword(rs.getString("password"));
		
		return admin;
	}
}
	
	


