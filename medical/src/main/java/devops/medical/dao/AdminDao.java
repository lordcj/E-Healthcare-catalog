package devops.medical.dao;

import devops.medical.model.Admin;
import devops.medical.model.AdminLogin;

public interface AdminDao {
	
	Admin check(AdminLogin adminlogin);

}
