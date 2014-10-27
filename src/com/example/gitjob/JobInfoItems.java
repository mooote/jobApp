package com.example.gitjob;

// all listed items
public class JobInfoItems {
	private String jobTitle;
	private String location;
	private String type;
	private String company;
	private String createdAt;
	private String description;
	private String howToApply;
	private String companyUrl;
	private String logo;
	
	// for detail info 
	public JobInfoItems(String jobTitle, String location, String type, String company, String createdAt, String description,
			String howToApply, String companyUrl, String logo) {
		this.jobTitle = jobTitle;
		this.location = location;
		this.type = type;
		this.company=company;
		this.createdAt=createdAt;
		this.description=description;
		this.howToApply=howToApply;
		this.companyUrl=companyUrl;
		this.logo=logo;
	}

	
	public String getjobTitle() {
		return jobTitle;
	}

	public String getLocation() {
		return location;
	}

	public String getType() {
		return type;
	}
	public String getCompany(){
		return company;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getHowToApply(){
		return howToApply;
	}
	
	public String getCompanyUrl(){
		return companyUrl;
	}
	
	public String getLogo(){
		return logo;
	}

}