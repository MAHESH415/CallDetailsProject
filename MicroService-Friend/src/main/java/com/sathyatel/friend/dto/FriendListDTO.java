package com.sathyatel.friend.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FriendListDTO {

	private List<Long> friendPhoneNumberList;
   
	private String errorMessage;

	public List<Long> getFriendPhoneNumberList() {
		return friendPhoneNumberList;
	}

	public void setFriendPhoneNumberList(List<Long> friendPhoneNumberList) {
		this.friendPhoneNumberList = friendPhoneNumberList;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}