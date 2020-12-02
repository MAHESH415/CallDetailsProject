package com.sathyatel.friend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friend {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Long phoneNumber;

	private Long friendPhoneNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getFriendPhoneNumber() {
		return friendPhoneNumber;
	}

	public void setFriendPhoneNumber(Long friendPhoneNumber) {
		this.friendPhoneNumber = friendPhoneNumber;
	}

}
