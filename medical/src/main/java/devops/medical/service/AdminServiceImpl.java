package devops.medical.service;

import org.springframework.beans.factory.annotation.Autowired;

import devops.medical.model.Admin;
import devops.medical.model.AdminLogin;
import devops.medical.dao.AdminDao;

public class AdminServiceImpl implements AdminService{
	
	@Autowired
	public AdminDao AdminDao;
	
	public Admin check(AdminLogin adminlogin) {
		return AdminDao.check(adminlogin);
	}

}
