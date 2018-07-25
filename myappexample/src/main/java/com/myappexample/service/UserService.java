package com.myappexample.service;

import java.util.List;
import java.util.Map;

import com.myappexample.entity.User;
import com.myappexample.vos.Simulate;

public interface UserService {

	

	
	public void createUser(Map<String, User> params);

	public List<User> getAllUsers();
	
	public void deleteUser(Map<String, User> params);
	
	public void updateUser(Map<String, User> params);

	public double simulate(Simulate objData);


	
	
}
