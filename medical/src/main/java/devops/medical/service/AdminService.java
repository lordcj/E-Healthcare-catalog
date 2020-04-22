package devops.medical.service;

import java.util.List;

import devops.medical.model.Admin;
import devops.medical.model.AdminLogin;
import devops.medical.model.Doctor;
import devops.medical.model.Lab;
import devops.medical.model.Patient;
public interface AdminService {
	
	
	Admin check(AdminLogin adminlogin);
	
	List<Doctor> getAllDoctors();
	
	Doctor validateDoctor(Doctor doctor);
	
	int registerDoctor(Doctor doctor);
	
	Doctor getDoctor(String id);
	
	int updateDoctor(Doctor doctor);
	 
	int deleteDoctor(String id);
	
	List<Lab> getAllLabs();
	
	Lab validateLab(Lab lab);
	
	int registerLab(Lab lab);
	
	Lab getLab(String id);
	
	int updateLab(Lab lab);
	
	int deleteLab(String id);
	
	
	
	

}
