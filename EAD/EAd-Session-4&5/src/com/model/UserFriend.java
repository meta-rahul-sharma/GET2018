package com.model;

import java.util.ArrayList;
import java.util.List;

public class UserFriend {
	User user;
	List<User> friends = new ArrayList<User>();
	
	public UserFriend(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getFriends() {
		return friends;
	}
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	public void addFriends(User friend) {
		friends.add(friend);
	}
}
