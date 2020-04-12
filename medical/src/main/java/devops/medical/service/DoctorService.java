package devops.medical.service;

import devops.medical.model.Doctor;
import devops.medical.model.DoctorLogin;

public interface DoctorService {
	
	int register(Doctor doctor);
	Doctor validateDoctor(Doctor doctor);
	Doctor check(DoctorLogin doctorlogin);
}
