package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cat {
	private Integer id;
	private String fullname;
	private Date dateOfBirth;
	private Boolean sex;
	
	public Cat() {}

	public Cat(Integer id, String fullname, Date dateOfBirth, Boolean sex) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
	}

	@Id // primary key
	@GeneratedValue // auto increment
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Cat [id=" + id + ", fullname=" + fullname + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + "]";
	}
	
	
}
