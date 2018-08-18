package com.vdellangela.swipejobs.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {
	private Boolean driverLicenseRequired;
	private List<String> requiredCertificates;
	private JobSearchAddress location;
	private String billRate;
	private Integer workersRequired;
	private LocalDateTime startDate;
	private String about;
	private String jobTitle;
	private String company;
	private String guid;
	private Integer jobId;

	public Job() {
	}

	public Boolean hasDriverLicenseRequired() {
		return driverLicenseRequired;
	}

	public void setDriverLicenseRequired(Boolean driverLicenseRequired) {
		this.driverLicenseRequired = driverLicenseRequired;
	}

	public List<String> getRequiredCertificates() {
		return requiredCertificates;
	}

	public void setRequiredCertificates(List<String> requiredCertificates) {
		this.requiredCertificates = requiredCertificates;
	}

	public JobSearchAddress getLocation() {
		return location;
	}

	public void setLocation(JobSearchAddress location) {
		this.location = location;
	}

	public String getBillRate() {
		return billRate;
	}

	public void setBillRate(String billRate) {
		this.billRate = billRate;
	}

	public Integer getWorkersRequired() {
		return workersRequired;
	}

	public void setWorkersRequired(Integer workersRequired) {
		this.workersRequired = workersRequired;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
}
