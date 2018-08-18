package carparking;

import java.sql.Date;
import java.sql.Time;

public class PH
{
	String veh;
	String type;
	String mob;
	String floor;
	Date indate;
	Time intime;
	Date outdate;
	Time outtime;
	String amount;
	Integer status;
	
	public PH()
	{
		
	}

	public PH(String veh, String type, String mob, String floor, Date indate, Time intime, Date outdate,
			Time outtime, String amount, Integer status) {
		super();
		this.veh = veh;
		this.type = type;
		this.mob = mob;
		this.floor = floor;
		this.indate = indate;
		this.intime = intime;
		this.outdate = outdate;
		this.outtime = outtime;
		this.amount = amount;
		this.status = status;
	}

	public String getVeh() {
		return veh;
	}

	public void setVeh(String veh) {
		this.veh = veh;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public Time getIntime() {
		return intime;
	}

	public void setIntime(Time intime) {
		this.intime = intime;
	}

	public Date getOutdate() {
		return outdate;
	}

	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}

	public Time getOuttime() {
		return outtime;
	}

	public void setOuttime(Time outtime) {
		this.outtime = outtime;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	}
