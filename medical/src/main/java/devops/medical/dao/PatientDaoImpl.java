package devops.medical.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import devops.medical.model.Doctor;
import devops.medical.model.DoctorSlots;
import devops.medical.model.Patient;
import devops.medical.model.PatientLogin;


public class PatientDaoImpl implements PatientDao {
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int register(Patient patient) {
		String sql = "insert into Patient values (?,?,?)";
		
		return jdbcTemplate.update(sql, new Object[] {patient.getId(), patient.getUsername(), patient.getPassword()});
	}
	
	public Patient validatePatient(Patient patient) {
		String sql = "select * from Patient where id='"+patient.getId()+"'";
		List<Patient> patients = jdbcTemplate.query(sql, new PatientMapper());
		
		return patients.size() > 0 ? patients.get(0) : null;
	}
	
	public Patient check(PatientLogin patientlogin) {
		String sql = "select * from Patient where id='"+patientlogin.getId()+"' and password='"+patientlogin.getPassword()+"'";
		List<Patient> patients = jdbcTemplate.query(sql, new PatientMapper());
		return patients.size()>0?patients.get(0):null;
	}
	
	public List<DoctorSlots> getAllPatient(String patient_id){
		String sql = "select * from DoctorSlots where patient_id='"+patient_id+"'";
		List<DoctorSlots> meetings = jdbcTemplate.query(sql, new DoctorSlotsMapper());
		
		return meetings;
	}
	
	public List<Doctor> getAllDoctors(){
		String sql = "select * from Doctor";
		List<Doctor> doctors = jdbcTemplate.query(sql, new DoctorMapper());
		System.out.println(doctors.size());
		return doctors;
	}
	
}

class PatientMapper implements RowMapper<Patient>{
	public Patient mapRow(ResultSet rs, int arg1) throws SQLException {
		Patient patient = new Patient();
		patient.setId(rs.getString("id"));
		patient.setUsername(rs.getString("name"));
		patient.setPassword(rs.getString("password"));
		
		return patient;
	}
}

class DoctorSlotsMapper implements RowMapper<DoctorSlots>{
	public DoctorSlots mapRow(ResultSet rs, int arg1) throws SQLException {
		DoctorSlots meeting = new DoctorSlots();
		meeting.setId(rs.getString("id"));
		meeting.setPatient_id(rs.getString("patient_id"));
		Date timing = new Date(rs.getTimestamp("timing").getTime());
		meeting.setTiming(timing);
		
		return meeting;
	}
}