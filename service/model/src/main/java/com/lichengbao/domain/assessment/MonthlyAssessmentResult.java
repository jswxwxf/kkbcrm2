/**
 * 
 */
package com.lichengbao.domain.assessment;

import java.io.Serializable;
import java.util.Set;

/**
 * @author jwang
 *
 */
public class MonthlyAssessmentResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7763284736016296390L;
	
	private String imei;
	
	private String days;
	
	private String validDays;
	
	private String scores;
	
	private String level;
	
	private String duration;
	
	private String reportPeriod;
	
	private String gradeLevel;
	
	private String gradeText;
	
	private String gradeComments;
	
	private Set<String> tags;
	
	private String acce;
	
	private String acceComments;
	
	private String brake;
	
	private String brakeComments;
	
	private String turn;
	
	private String turnComments;
	
	private String speeding;
	
	private String speedingComments;
	
	private String abtComments;
	
	private String timerange;
	
	private String timerangeComments;
	
	private String mileage;
	
	private String mileageComments;
	
	private String jam;
	
	private String jamPercent;
	
	private String jamComments;
	
	private String familiarRoadsComments;
	
	private String familiarRoadsPercent;
	
	private String mate;
	
	private String mateLicenseNo;

	/**
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * @return the days
	 */
	public String getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(String days) {
		this.days = days;
	}

	/**
	 * @return the validDays
	 */
	public String getValidDays() {
		return validDays;
	}

	/**
	 * @param validDays the validDays to set
	 */
	public void setValidDays(String validDays) {
		this.validDays = validDays;
	}

	/**
	 * @return the scores
	 */
	public String getScores() {
		return scores;
	}

	/**
	 * @param scores the scores to set
	 */
	public void setScores(String scores) {
		this.scores = scores;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
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
	 * @return the reportPeriod
	 */
	public String getReportPeriod() {
		return reportPeriod;
	}

	/**
	 * @param reportPeriod the reportPeriod to set
	 */
	public void setReportPeriod(String reportPeriod) {
		this.reportPeriod = reportPeriod;
	}

	/**
	 * @return the gradeLevel
	 */
	public String getGradeLevel() {
		return gradeLevel;
	}

	/**
	 * @param gradeLevel the gradeLevel to set
	 */
	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	/**
	 * @return the gradeText
	 */
	public String getGradeText() {
		return gradeText;
	}

	/**
	 * @param gradeText the gradeText to set
	 */
	public void setGradeText(String gradeText) {
		this.gradeText = gradeText;
	}

	/**
	 * @return the gradeComments
	 */
	public String getGradeComments() {
		return gradeComments;
	}

	/**
	 * @param gradeComments the gradeComments to set
	 */
	public void setGradeComments(String gradeComments) {
		this.gradeComments = gradeComments;
	}

	/**
	 * @return the tags
	 */
	public Set<String> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	/**
	 * @return the acce
	 */
	public String getAcce() {
		return acce;
	}

	/**
	 * @param acce the acce to set
	 */
	public void setAcce(String acce) {
		this.acce = acce;
	}

	/**
	 * @return the acceComments
	 */
	public String getAcceComments() {
		return acceComments;
	}

	/**
	 * @param acceComments the acceComments to set
	 */
	public void setAcceComments(String acceComments) {
		this.acceComments = acceComments;
	}

	/**
	 * @return the brake
	 */
	public String getBrake() {
		return brake;
	}

	/**
	 * @param brake the brake to set
	 */
	public void setBrake(String brake) {
		this.brake = brake;
	}

	/**
	 * @return the brakeComments
	 */
	public String getBrakeComments() {
		return brakeComments;
	}

	/**
	 * @param brakeComments the brakeComments to set
	 */
	public void setBrakeComments(String brakeComments) {
		this.brakeComments = brakeComments;
	}

	/**
	 * @return the turn
	 */
	public String getTurn() {
		return turn;
	}

	/**
	 * @param turn the turn to set
	 */
	public void setTurn(String turn) {
		this.turn = turn;
	}

	/**
	 * @return the turnComments
	 */
	public String getTurnComments() {
		return turnComments;
	}

	/**
	 * @param turnComments the turnComments to set
	 */
	public void setTurnComments(String turnComments) {
		this.turnComments = turnComments;
	}

	/**
	 * @return the speeding
	 */
	public String getSpeeding() {
		return speeding;
	}

	/**
	 * @param speeding the speeding to set
	 */
	public void setSpeeding(String speeding) {
		this.speeding = speeding;
	}

	/**
	 * @return the speedingComments
	 */
	public String getSpeedingComments() {
		return speedingComments;
	}

	/**
	 * @param speedingComments the speedingComments to set
	 */
	public void setSpeedingComments(String speedingComments) {
		this.speedingComments = speedingComments;
	}

	/**
	 * @return the abtComments
	 */
	public String getAbtComments() {
		return abtComments;
	}

	/**
	 * @param abtComments the abtComments to set
	 */
	public void setAbtComments(String abtComments) {
		this.abtComments = abtComments;
	}

	/**
	 * @return the timerange
	 */
	public String getTimerange() {
		return timerange;
	}

	/**
	 * @param timerange the timerange to set
	 */
	public void setTimerange(String timerange) {
		this.timerange = timerange;
	}

	/**
	 * @return the timerangeComments
	 */
	public String getTimerangeComments() {
		return timerangeComments;
	}

	/**
	 * @param timerangeComments the timerangeComments to set
	 */
	public void setTimerangeComments(String timerangeComments) {
		this.timerangeComments = timerangeComments;
	}

	/**
	 * @return the mileage
	 */
	public String getMileage() {
		return mileage;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	/**
	 * @return the mileageComments
	 */
	public String getMileageComments() {
		return mileageComments;
	}

	/**
	 * @param mileageComments the mileageComments to set
	 */
	public void setMileageComments(String mileageComments) {
		this.mileageComments = mileageComments;
	}

	/**
	 * @return the jam
	 */
	public String getJam() {
		return jam;
	}

	/**
	 * @param jam the jam to set
	 */
	public void setJam(String jam) {
		this.jam = jam;
	}

	/**
	 * @return the jamPercent
	 */
	public String getJamPercent() {
		return jamPercent;
	}

	/**
	 * @param jamPercent the jamPercent to set
	 */
	public void setJamPercent(String jamPercent) {
		this.jamPercent = jamPercent;
	}

	/**
	 * @return the jamComments
	 */
	public String getJamComments() {
		return jamComments;
	}

	/**
	 * @param jamComments the jamComments to set
	 */
	public void setJamComments(String jamComments) {
		this.jamComments = jamComments;
	}

	/**
	 * @return the familiarRoadsComments
	 */
	public String getFamiliarRoadsComments() {
		return familiarRoadsComments;
	}

	/**
	 * @param familiarRoadsComments the familiarRoadsComments to set
	 */
	public void setFamiliarRoadsComments(String familiarRoadsComments) {
		this.familiarRoadsComments = familiarRoadsComments;
	}

	/**
	 * @return the familiarRoadsPercent
	 */
	public String getFamiliarRoadsPercent() {
		return familiarRoadsPercent;
	}

	/**
	 * @param familiarRoadsPercent the familiarRoadsPercent to set
	 */
	public void setFamiliarRoadsPercent(String familiarRoadsPercent) {
		this.familiarRoadsPercent = familiarRoadsPercent;
	}

	/**
	 * @return the mate
	 */
	public String getMate() {
		return mate;
	}

	/**
	 * @param mate the mate to set
	 */
	public void setMate(String mate) {
		this.mate = mate;
	}

	/**
	 * @return the mateLicenseNo
	 */
	public String getMateLicenseNo() {
		return mateLicenseNo;
	}

	/**
	 * @param mateLicenseNo the mateLicenseNo to set
	 */
	public void setMateLicenseNo(String mateLicenseNo) {
		this.mateLicenseNo = mateLicenseNo;
	}
	
}