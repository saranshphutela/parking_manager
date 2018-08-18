package carparking;

public class PP 
{
	String floor;
	String slot;
	String type;
	String booked;
	String free;
	
	public PP()
	{
		
	}
	
	public PP(String floor, String slot, String type, String booked, String free) {
		super();
		this.floor = floor;
		this.slot = slot;
		this.type = type;
		this.booked = booked;
		this.free = free;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBooked() {
		return booked;
	}

	public void setBooked(String booked) {
		this.booked = booked;
	}

	public String getFree() {
		return free;
	}

	public void setFree(String free) {
		this.free = free;
	}

	}
