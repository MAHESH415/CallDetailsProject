package com.sathyatel.friend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sathyatel.friend.entity.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {

	List<Friend> findByPhoneNumber(Long phoneNumber);

	boolean existsByFriendPhoneNumber(Long friendPhoneNumber);
	
	boolean existsByPhoneNumber(Long phoneNumber);
	
	@Query(value="SELECT COUNT(*) FROM FRIEND WHERE PHONE_NUMBER=? and FRIEND_PHONE_NUMBER=?",nativeQuery=true)
	Integer verifyPhoneNumber(Long phoneNumber,Long friendPhoneNumber);
}
