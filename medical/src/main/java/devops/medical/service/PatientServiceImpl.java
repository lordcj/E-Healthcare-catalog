package devops.medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import devops.medical.model.Doctor;
import devops.medical.model.DoctorSlots;
import devops.medical.model.Patient;
import devops.medical.dao.PatientDao;
import devops.medical.model.PatientLogin;

public class PatientServiceImpl implements PatientService {
	
	@Autowired
	public PatientDao PatientDao;
	
	public int register(Patient patient) {
		return PatientDao.register(patient);
	}
	
	public Patient validatePatient(Patient patient) {
		return PatientDao.validatePatient(patient);
	}
	
	public Patient check(PatientLogin patientlogin) {
		return PatientDao.check(patientlogin);
	}
	
	public List<DoctorSlots> getAllPatient(String patient_id){
		return PatientDao.getAllPatient(patient_id);
	}
	
	public List<Doctor> getAllDoctors(){
		return PatientDao.getAllDoctors();
	}
	
}
