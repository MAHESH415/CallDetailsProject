package com.sathyatel.friend.service;

import java.util.List;

import com.sathyatel.friend.dto.FriendDTO;
import com.sathyatel.friend.dto.FriendListDTO;

public interface IFriendService {

	String addFriend(FriendDTO friendDTO);

	List<Long> getFriendsListPhoneNumbers(Long phoneNumber);
	
	FriendListDTO getFriendsContactList(Long phoneNumber);
	
	String saveFriend(FriendDTO friendDTO);
}
