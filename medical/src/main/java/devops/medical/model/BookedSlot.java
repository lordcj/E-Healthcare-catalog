package devops.medical.model;

public class BookedSlot {
	private String bookedslot;
	private String id;
	private String patientid;
	
	public String getBookedslot() {
		return bookedslot;
	}
	public void setBookedslot(String bookedslot) {
		this.bookedslot = bookedslot;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
}
