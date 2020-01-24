package example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "ParkingEntry")
public class ParkingEntry {
	
	@Id
	@GeneratedValue
	long code;
	
	long time;

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getCode() {
		return code;
	}
	
}