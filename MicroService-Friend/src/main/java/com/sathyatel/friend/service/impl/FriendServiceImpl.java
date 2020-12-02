package com.sathyatel.friend.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathyatel.friend.dto.FriendDTO;
import com.sathyatel.friend.dto.FriendListDTO;
import com.sathyatel.friend.entity.Friend;
import com.sathyatel.friend.repository.FriendRepository;
import com.sathyatel.friend.service.IFriendService;

@Service
public class FriendServiceImpl implements IFriendService {

	@Autowired
	private FriendRepository friendRepository;

	@Override
	public String addFriend(FriendDTO friendDTO) {
		if (Objects.nonNull(friendDTO)) {
			Long phoneNumber = friendDTO.getPhoneNumber();
			Long friendPhoneNumber = friendDTO.getFriendPhoneNumber();
			if (Objects.nonNull(phoneNumber) && Objects.nonNull(friendPhoneNumber)) {
				if (friendRepository.existsByFriendPhoneNumber(friendPhoneNumber)) {
					return "Friend number " + "already existed in the contact list";
				} else {
					Friend friend = new Friend();
					friend.setPhoneNumber(phoneNumber);
					friend.setFriendPhoneNumber(friendPhoneNumber);
					Friend friendSaved = friendRepository.save(friend);
					if (Objects.nonNull(friendSaved)) {
						return " Friend number  added successfully to contact list";
					} else {
						return "Error in adding friend number";
					}
				}
			} else {
				return "Phone number and friend number shoult not empty or null ";
			}
		}
		return "unable to perfrom adding friend phone number";
	}

	@Override
	public List<Long> getFriendsListPhoneNumbers(Long phoneNumber) {
		List<Friend> friendListFromDB = friendRepository.findByPhoneNumber(phoneNumber);
		List<Long> friendsPhoneNumberList = new ArrayList<>();
		for (Friend friend : friendListFromDB) {
			friendsPhoneNumberList.add(friend.getFriendPhoneNumber());
		}
		return friendsPhoneNumberList;
	}

	@Override
	public FriendListDTO getFriendsContactList(Long phoneNumber) {
		FriendListDTO friendListDTO = new FriendListDTO();
		if (Objects.nonNull(phoneNumber)) {
			boolean isPhoneNumberExisted = friendRepository.existsByPhoneNumber(phoneNumber);
			if (isPhoneNumberExisted) {
				List<Long> friendsPhoneNumberList = getFriendsListPhoneNumbers(phoneNumber);
				friendListDTO.setFriendPhoneNumberList(friendsPhoneNumberList);
			} else {
				friendListDTO.setErrorMessage("PhoneNumber not existed..Please provide correct number");
			}
		} else {
			friendListDTO.setErrorMessage("PhoneNumber not existed..Please provide correct number");
		}
		return friendListDTO;
	}

	@Override
	public String saveFriend(FriendDTO friendDTO) {
		if (Objects.nonNull(friendDTO)) {
			Long phoneNumber = friendDTO.getPhoneNumber();
			Long friendPhoneNumber = friendDTO.getFriendPhoneNumber();
			if (Objects.nonNull(phoneNumber) && Objects.nonNull(friendPhoneNumber)) {
				if (friendRepository.verifyPhoneNumber(phoneNumber, friendPhoneNumber) == 0) {
					Friend friend = new Friend();
					friend.setPhoneNumber(phoneNumber);
					friend.setFriendPhoneNumber(friendPhoneNumber);
					Friend friendSaved = friendRepository.save(friend);
					if (Objects.nonNull(friendSaved)) {
						return " Friend number  added successfully to contact list";
					} else {
						return "Error in adding friend number";
					}
				} else {
					return "Phone number and Friend number are already existed in the contact list";
				}
			} else {
				return "Phone number and friend number shoult not empty or null ";
			}
		}
		return "unable to perfrom adding friend phone number";

	}

}
