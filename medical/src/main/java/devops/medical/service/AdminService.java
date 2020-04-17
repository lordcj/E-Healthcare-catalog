package devops.medical.service;

import devops.medical.model.Admin;
import devops.medical.model.AdminLogin;
public interface AdminService {
	
	
	Admin check(AdminLogin adminlogin);
	

}
