package com.myappexample;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myappexample.service.UserService;
import com.myappexample.vos.Simulate;

/**
 * @author Diego Costa
 * Last Update: 22/07/2018
 * Coment: Classe exemplo responssável por testar a lógica de cálculo do empréstimo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;
	@Rule
	public ExpectedException trhown = ExpectedException.none();
	
	/**
	 *Testa exemplo de simulação de empréstimo 
	 */
	@Test
	public void loanSimulationTest(){

		Simulate objData = new Simulate(1000,12,"A");
		
		double valueResult = this.userService.simulate(objData);		
		
		Assertions.assertThat(valueResult).isEqualTo(1253.4014941522253);
		
		
	}
	
	
}
