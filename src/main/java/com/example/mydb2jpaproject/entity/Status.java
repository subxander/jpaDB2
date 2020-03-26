package com.example.mydb2jpaproject.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "LANE")
	private String lane;

	@Column(name = "JOBNAME")
	private String jobname;
	
	@Column(name = "SEQ_NUM")
	private String seqnum;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "RUNDATE")
	private Date rundate;
	
	@Column(name = "RTRN_CD")
	private String rtrncd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public String getSeqnum() {
		return seqnum;
	}

	public void setSeqnum(String seqnum) {
		this.seqnum = seqnum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRundate() {
		return rundate;
	}

	public void setRundate(Date rundate) {
		this.rundate = rundate;
	}

	public String getRtrncd() {
		return rtrncd;
	}

	public void setRtrncd(String rtrncd) {
		this.rtrncd = rtrncd;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", lane=" + lane + ", jobname=" + jobname + ", seqnum=" + seqnum + ", status="
				+ status + ", rundate=" + rundate + ", rtrncd=" + rtrncd + "]";
	}
}
