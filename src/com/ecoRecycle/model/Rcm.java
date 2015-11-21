package com.ecoRecycle.model;

import javax.persistence.*;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.HashSet;

import com.ecoRecycle.helper.RcmStatus;

@Entity
@Table(name = "RCM")
public class Rcm extends Observable{
	@Id 
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "locationId")
	private Location location;
	
	@Column(name = "totalCapacity")
	private double totalCapacity;
	
	@Column(name = "totalCashValue")
	private double totalCashValue;
	
	@Column(name = "currentCapacity")
	private double currentCapacity;
	
	@Column(name = "currentCashValue")
	private double currentCashValue;
	
	@Column(name = "currentCouponValue")
	private double currentCouponValue; // Might not need this
	
	@Column(name="status", columnDefinition="enum('Active','Inactive', 'Removed')")
	@Enumerated(EnumType.STRING)
	public RcmStatus status;
	
	@Column(name = "lastEmptied")
	private Date lastEmptied;
	
	@Column(name = "createDateTime")
	private Date createDateTime;
	
	@Column(name = "updateDateTime")
	private Date updateDateTime;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(double totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public double getTotalCashValue() {
		return totalCashValue;
	}

	public void setTotalCashValue(double totalCashValue) {
		this.totalCashValue = totalCashValue;
	}

	public double getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(double currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public double getCurrentCashValue() {
		return currentCashValue;
	}

	public void setCurrentCashValue(double currentCashValue) {
		this.currentCashValue = currentCashValue;
	}

	public double getCurrentCouponValue() {
		return currentCouponValue;
	}

	public void setCurrentCouponValue(double currentCouponValue) {
		this.currentCouponValue = currentCouponValue;
	}

	public RcmStatus getStatus() {
		return status;
	}

	public void setStatus(RcmStatus status) {
		this.status = status;
	}

	public Date getLastEmptied() {
		return lastEmptied;
	}

	public void setLastEmptied(Date lastEmptied) {
		this.lastEmptied = lastEmptied;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
	// Rcm has rmos
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinTable(name = "RmosRcm")
//	public Rmos getRmos() {
//		
//	}
	
	@Override
	public String toString() {
		return "Rcm [id=" + id + ", name=" + name + ", location=" + location
				+ ", totalCapacity=" + totalCapacity + ", totalCashValue="
				+ totalCashValue + ", currentCapacity=" + currentCapacity
				+ ", currentCashValue=" + currentCashValue + ", status="
				+ status + ", lastEmptied=" + lastEmptied + "]";
	}

	

}
