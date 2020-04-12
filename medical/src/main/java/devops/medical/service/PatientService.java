package devops.medical.service;

import java.util.List;

import devops.medical.model.Doctor;
import devops.medical.model.DoctorSlots;
import devops.medical.model.Patient;
import devops.medical.model.PatientLogin;

public interface PatientService {
	
	int register(Patient patient);
	
	Patient validatePatient(Patient Patient);
	
	Patient check(PatientLogin patientlogin);
	
	List<DoctorSlots> getAllPatient(String patient_id);
	
	List<Doctor> getAllDoctors();
}
