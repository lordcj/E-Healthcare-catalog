package devops.medical.dao;

import java.util.List;

import devops.medical.model.Doctor;
import devops.medical.model.DoctorSlots;
import devops.medical.model.Patient;
import devops.medical.model.PatientLogin;

public interface PatientDao {
	int register(Patient patient);
	
	Patient validatePatient(Patient patient);
	
	Patient check(PatientLogin patientlogin);
	
	List<DoctorSlots> getAllPatient(String patient_id);
	
	List<Doctor> getAllDoctors();
}
