package devops.medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import devops.medical.model.Admin;
import devops.medical.model.AdminLogin;
import devops.medical.model.Doctor;
import devops.medical.model.Lab;
import devops.medical.model.Patient;
import devops.medical.dao.AdminDao;

public class AdminServiceImpl implements AdminService{
	
	@Autowired
	public AdminDao AdminDao;
	
	public Admin check(AdminLogin adminlogin) {
		return AdminDao.check(adminlogin);
	}
	
	public List<Doctor> getAllDoctors(){
		return AdminDao.getAllDoctors();
	}
	
	public Doctor validateDoctor(Doctor doctor) {
		return AdminDao.validateDoctor(doctor);
	}
	
	public int registerDoctor(Doctor doctor) {
		return AdminDao.registerDoctor(doctor);
	}
	
	public Doctor getDoctor(String id) {
		return AdminDao.getDoctor(id);
	}
	
	public int updateDoctor(Doctor doctor) {
		return AdminDao.updateDoctor(doctor);
	}
	
	public int deleteDoctor(String id) {
		return AdminDao.deleteDoctor(id);
	}
	
	
	
	public List<Lab> getAllLabs(){
		return AdminDao.getAllLabs();
	}
	
	public Lab validateLab(Lab lab) {
		return AdminDao.validateLab(lab);
	}
	
	public int registerLab(Lab lab) {
		return AdminDao.registerLab(lab);
	}
	
	public Lab getLab(String id) {
		return AdminDao.getLab(id);
	}
	
	public int updateLab(Lab lab) {
		return AdminDao.updateLab(lab);
	}
	
	public int deleteLab(String id) {
		return AdminDao.deleteLab(id);
	}
	
	
	
	

	

}
