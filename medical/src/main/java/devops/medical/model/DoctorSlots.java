package devops.medical.model;
import java.util.Date;


public class DoctorSlots {
	private String id;
	private Date timing;
	private String patient_id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTiming() {
		return timing;
	}
	public void setTiming(Date timing) {
		this.timing = timing;
	}
	public String getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
	
}
