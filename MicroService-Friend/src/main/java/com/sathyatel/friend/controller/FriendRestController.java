package com.sathyatel.friend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sathyatel.friend.dto.FriendDTO;
import com.sathyatel.friend.dto.FriendListDTO;
import com.sathyatel.friend.service.IFriendService;

@RestController
public class FriendRestController {

	@Autowired
	private IFriendService iFriendService;
	
	@PostMapping("/addFriend")
	public String addFriend(@RequestBody FriendDTO friendDTO) {
		return iFriendService.addFriend(friendDTO);
	}
	
	@GetMapping("/friends/{phoneNumber}")
	public List<Long> getFriendsListPhoneNumbers(@PathVariable Long phoneNumber){
		return iFriendService.getFriendsListPhoneNumbers(phoneNumber);
	}
	
	@GetMapping("/friendsNumbers/{phoneNumber}")
	public FriendListDTO getFriendList(@PathVariable Long phoneNumber) {
		return iFriendService.getFriendsContactList(phoneNumber);
	}
}
