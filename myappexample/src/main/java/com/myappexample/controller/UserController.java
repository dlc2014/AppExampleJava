package com.myappexample.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myappexample.entity.User;
import com.myappexample.service.UserService;
import com.myappexample.vos.Simulate;



@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String index() {
		
		System.out.println(">>>>>>>>>>>>>>INDEX");
		return "index";
	}
	
	
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody Map<String, User> params) {
		try {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>CHEGOU NO createUser");
			System.out.println("parâmetros - " + params.get("data").getNome());
			
			userService.createUser(params);
				
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			System.out.println(">>>ERRO - "+e.getMessage());;
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers() {
		try {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>CHEGOU GET ALL USERS");
			
			List<User> list = userService.getAllUsers();
			System.out.println(">>>> controller list - "+list);
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			System.out.println(">>>ERRO - "+e.getStackTrace().toString());;
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public String testContolador() {
		try {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>CHEGOU NO TESTE CONROLLER");
				
			return "OK";
			
		} catch (Exception e) {
			return "NOK";
		}
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public ResponseEntity<?> deleteUser(@RequestBody Map<String, User> params) {
		try {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>CHEGOU NO deleteUserById");
			System.out.println("parâmetros - " + params.get("data").getId());
			
			userService.deleteUser(params);
				
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			System.out.println(">>>ERRO - "+e.getStackTrace().toString());;
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResponseEntity<?> editUser(@RequestBody Map<String, User> params) {
		try {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>CHEGOU NO updateUser");
			System.out.println("parâmetros - " + params.get("data").getId());
			
			userService.updateUser(params);
				
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			System.out.println(">>>ERRO - "+e.getStackTrace().toString());;
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value = "/simulate", method = RequestMethod.POST)
	public ResponseEntity<?> simulate(@RequestBody Map<String, Simulate> params) {
		try {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>CHEGOU NO updateUser");
			System.out.println("parâmetros - " + params.get("data").getMeses());
			
			Simulate objData = new Simulate(params.get("data").getEmprestimo(), params.get("data").getMeses(), params.get("data").getRisco());
			
			double resultSimulate  = userService.simulate(objData);
				
			return ResponseEntity.ok(resultSimulate);
		} catch (Exception e) {
			System.out.println(">>>ERRO - "+e.getStackTrace().toString());;
			return ResponseEntity.badRequest().build();
		}
	}
	
	
}
