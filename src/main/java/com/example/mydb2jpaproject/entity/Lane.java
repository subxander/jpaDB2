package com.example.mydb2jpaproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lane")
public class Lane {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "LANE")
	private String lane;

	@Column(name = "CONTROLD")
	private String controld;

	@Column(name = "TESTTYPE")
	private String testtype;

	@Column(name = "JOBLIST")
	private String joblist;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getControld() {
		return controld;
	}

	public void setControld(String controld) {
		this.controld = controld;
	}

	public String getTesttype() {
		return testtype;
	}

	public void setTesttype(String testtype) {
		this.testtype = testtype;
	}

	public String getJoblist() {
		return joblist;
	}

	public void setJoblist(String joblist) {
		this.joblist = joblist;
	}

	@Override
	public String toString() {
		return "Lane [id=" + id + ", login=" + login + ", lane=" + lane + ", controld=" + controld + ", testtype="
				+ testtype + ", joblist=" + joblist + "]";
	}
}
