package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.UserRoles;
import com.metacube.training.repository.UserRoleRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleRepository<UserRoles> userRoleRepository;
	
	@Override
	public List<UserRoles> getUserRoleByUserName(String username) {
		return (List<UserRoles>) userRoleRepository.findByUserName(username);
	}

	/* (non-Javadoc)
	 * @see com.metacube.training.SpringSecurity.service.UserRoleService#findAll()
	 */
	@Override
	public List<UserRoles> findAll() {
		return userRoleRepository.findAll();
	}
	
	

}
