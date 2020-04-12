package devops.medical.dao;

import devops.medical.model.Doctor;
import devops.medical.model.DoctorLogin;

public interface DoctorDao {
	
	int register(Doctor doctor);
	
	Doctor validateDoctor(Doctor doctor);
	
	Doctor check(DoctorLogin doctorlogin);
}
