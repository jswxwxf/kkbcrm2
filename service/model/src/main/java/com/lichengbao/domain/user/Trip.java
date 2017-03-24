/**
 * 
 */
package com.lichengbao.domain.user;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.lichengbao.domain.common.Vehicle;

/**
 * @author jwang
 *
 */
@Entity
@Table(name="trips")
public class Trip implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3147543690703007367L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Vehicle vehicle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private User user;
	
	@AttributeOverrides({
		@AttributeOverride(name = "name", column = @Column(name = "start_loc_name") ),
		@AttributeOverride(name = "nickname", column = @Column(name = "start_loc_nickname") ),
		@AttributeOverride(name = "lat", column = @Column(name = "start_loc_lat") ),
		@AttributeOverride(name = "lon", column = @Column(name = "start_loc_lon") ),
		@AttributeOverride(name = "accuracy", column = @Column(name = "start_loc_accu") ),
		@AttributeOverride(name = "epochTime", column = @Column(name = "start_epoch_time") )	
	})
	private LocationInfo startLoc;
	
	@AttributeOverrides({
		@AttributeOverride(name = "name", column = @Column(name = "end_loc_name") ),
		@AttributeOverride(name = "nickname", column = @Column(name = "end_loc_nickname") ),
		@AttributeOverride(name = "lat", column = @Column(name = "end_loc_lat") ),
		@AttributeOverride(name = "lon", column = @Column(name = "end_loc_lon") ),
		@AttributeOverride(name = "accuracy", column = @Column(name = "end_loc_accu") ),
		@AttributeOverride(name = "epochTime", column = @Column(name = "end_epoch_time") )	
	})
	private LocationInfo endLoc;
	
	private String parkedLocLat;
	
	private String parkedLocLon;
	
	private String path;
	
	private String pathDetails;
	
	private String distance;
	
	private String duration;
	
	private String fuelCost;
	
	private String fuelPrice;
	
	private String fuelVolume;
	
	private String avgLpkm;
	
	private String avgLpkmEpa;
	
	private Integer suddenAcce;
	
	private Integer suddenBrake;
	
	private Integer suddenTurn;
	
	private Integer overspeed;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar deletedAt;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the startLoc
	 */
	public LocationInfo getStartLoc() {
		return startLoc;
	}

	/**
	 * @param startLoc the startLoc to set
	 */
	public void setStartLoc(LocationInfo startLoc) {
		this.startLoc = startLoc;
	}

	/**
	 * @return the endLoc
	 */
	public LocationInfo getEndLoc() {
		return endLoc;
	}

	/**
	 * @param endLoc the endLoc to set
	 */
	public void setEndLoc(LocationInfo endLoc) {
		this.endLoc = endLoc;
	}

	/**
	 * @return the parkedLocLat
	 */
	public String getParkedLocLat() {
		return parkedLocLat;
	}

	/**
	 * @param parkedLocLat the parkedLocLat to set
	 */
	public void setParkedLocLat(String parkedLocLat) {
		this.parkedLocLat = parkedLocLat;
	}

	/**
	 * @return the parkedLocLon
	 */
	public String getParkedLocLon() {
		return parkedLocLon;
	}

	/**
	 * @param parkedLocLon the parkedLocLon to set
	 */
	public void setParkedLocLon(String parkedLocLon) {
		this.parkedLocLon = parkedLocLon;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the pathDetails
	 */
	public String getPathDetails() {
		return pathDetails;
	}

	/**
	 * @param pathDetails the pathDetails to set
	 */
	public void setPathDetails(String pathDetails) {
		this.pathDetails = pathDetails;
	}

	/**
	 * @return the distance
	 */
	public String getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(String distance) {
		this.distance = distance;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * @return the fuelCost
	 */
	public String getFuelCost() {
		return fuelCost;
	}

	/**
	 * @param fuelCost the fuelCost to set
	 */
	public void setFuelCost(String fuelCost) {
		this.fuelCost = fuelCost;
	}

	/**
	 * @return the fuelPrice
	 */
	public String getFuelPrice() {
		return fuelPrice;
	}

	/**
	 * @param fuelPrice the fuelPrice to set
	 */
	public void setFuelPrice(String fuelPrice) {
		this.fuelPrice = fuelPrice;
	}

	/**
	 * @return the fuelVolume
	 */
	public String getFuelVolume() {
		return fuelVolume;
	}

	/**
	 * @param fuelVolume the fuelVolume to set
	 */
	public void setFuelVolume(String fuelVolume) {
		this.fuelVolume = fuelVolume;
	}

	/**
	 * @return the avgLpkm
	 */
	public String getAvgLpkm() {
		return avgLpkm;
	}

	/**
	 * @param avgLpkm the avgLpkm to set
	 */
	public void setAvgLpkm(String avgLpkm) {
		this.avgLpkm = avgLpkm;
	}

	/**
	 * @return the avgLpkmEpa
	 */
	public String getAvgLpkmEpa() {
		return avgLpkmEpa;
	}

	/**
	 * @param avgLpkmEpa the avgLpkmEpa to set
	 */
	public void setAvgLpkmEpa(String avgLpkmEpa) {
		this.avgLpkmEpa = avgLpkmEpa;
	}

	/**
	 * @return the suddenAcce
	 */
	public Integer getSuddenAcce() {
		return suddenAcce;
	}

	/**
	 * @param suddenAcce the suddenAcce to set
	 */
	public void setSuddenAcce(Integer suddenAcce) {
		this.suddenAcce = suddenAcce;
	}

	/**
	 * @return the suddenBrake
	 */
	public Integer getSuddenBrake() {
		return suddenBrake;
	}

	/**
	 * @param suddenBrake the suddenBrake to set
	 */
	public void setSuddenBrake(Integer suddenBrake) {
		this.suddenBrake = suddenBrake;
	}

	/**
	 * @return the suddenTurn
	 */
	public Integer getSuddenTurn() {
		return suddenTurn;
	}

	/**
	 * @param suddenTurn the suddenTurn to set
	 */
	public void setSuddenTurn(Integer suddenTurn) {
		this.suddenTurn = suddenTurn;
	}

	/**
	 * @return the overspeed
	 */
	public Integer getOverspeed() {
		return overspeed;
	}

	/**
	 * @param overspeed the overspeed to set
	 */
	public void setOverspeed(Integer overspeed) {
		this.overspeed = overspeed;
	}

	/**
	 * @return the createdAt
	 */
	public Calendar getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Calendar getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the deletedAt
	 */
	public Calendar getDeletedAt() {
		return deletedAt;
	}

	/**
	 * @param deletedAt the deletedAt to set
	 */
	public void setDeletedAt(Calendar deletedAt) {
		this.deletedAt = deletedAt;
	}

}
