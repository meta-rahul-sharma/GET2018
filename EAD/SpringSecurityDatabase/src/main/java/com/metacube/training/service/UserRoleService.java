package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.UserRoles;

public interface UserRoleService {
	List<UserRoles> getUserRoleByUserName(String username);
	List<UserRoles> findAll();
}
