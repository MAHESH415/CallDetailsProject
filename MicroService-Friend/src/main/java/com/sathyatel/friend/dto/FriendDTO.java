package com.sathyatel.friend.dto;

import javax.validation.constraints.NotEmpty;

public class FriendDTO {

	@NotEmpty
	private Long phoneNumber;

	@NotEmpty
	private Long friendPhoneNumber;

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
