package com.verizon.tls.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Plans")
public class Plans {

	@Id
	public String title;
	
	public int maxSpeed;
	public int maxUsage;
	public int chargePerMonth;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getMaxUsage() {
		return maxUsage;
	}

	public void setMaxUsage(int maxUsage) {
		this.maxUsage = maxUsage;
	}

	public int getChargePerMonth() {
		return chargePerMonth;
	}

	public void setChargePerMonth(int chargePerMonth) {
		this.chargePerMonth = chargePerMonth;
	}
	
	
	
}
