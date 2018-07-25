package com.myappexample;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myappexample.entity.User;
import com.myappexample.repository.UserRepository;


/**
 * @author Diego Costa
 * Last Update: 22/07/2018
 * Coment: Classe exemplo responssável por testar a interface JPA do usuário
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	@Rule
	public ExpectedException trhown = ExpectedException.none();
	
	/**
	 *Testa a criação de um usuário através da interface JPA 
	 */
	@Test
	public void createUserPersistDataTest(){
		User userTest = new User("Usuário Teste","Rua 10, casa 100",1500.58,"A","Comum", "Sim", 21345.67, 12345.10);
		this.userRepository.save(userTest);
		
		
		Assertions.assertThat(userTest.getId()).isNotNull();
		Assertions.assertThat(userTest.getNome()).isEqualTo("Usuário Teste");
		Assertions.assertThat(userTest.getEndereco()).isEqualTo("Rua 10, casa 100");
		Assertions.assertThat(userTest.getRendimento()).isEqualTo(1500.58);
		Assertions.assertThat(userTest.getRisco()).isEqualTo("A");
		Assertions.assertThat(userTest.getTipo()).isEqualTo("Comum");
		Assertions.assertThat(userTest.getEmpregado()).isEqualTo("Sim");
		Assertions.assertThat(userTest.getPatrimonio()).isEqualTo(21345.67);
		Assertions.assertThat(userTest.getDivida()).isEqualTo(12345.10);
		
		//Após a validação remove o registro de teste
		userRepository.delete(userTest);
	}
	

	/**
	 *Testa a exclusão de um usuário através da interface JPA 
	 */
	@Test
	public void deleteUserDataTest(){
		User userTest = new User("Usuário Teste 2","Rua 10, casa 100",1500.58,"A","Comum", "Sim", 21345.67, 12345.10);
		this.userRepository.save(userTest);
		userRepository.delete(userTest);
		
		Assertions.assertThat(userRepository.findById(userTest.getId())).isEmpty();
	}
	
	/**
	 *Testa a atualização de um usuário através da interface JPA 
	 */
	@Test
	public void updateUserDataTest(){
		User userTest = new User("Usuário Teste 2","Rua 10, casa 100",1500.58,"A","Comum", "Sim", 21345.67, 12345.10);
		this.userRepository.save(userTest);


		userTest.setNome("Usuário updated");
		userTest.setEndereco("Rua 200, casa 2B");
		userTest.setRendimento(3500.00);
		userTest.setRisco("B");
		userTest.setTipo("Potencial");
		userTest.setEmpregado("Não");
		userTest.setPatrimonio(30000.67);
		userTest.setDivida(500.00);
		
		userTest = this.userRepository.save(userTest);
		
		Assertions.assertThat(userTest.getNome()).isEqualTo("Usuário updated");
		Assertions.assertThat(userTest.getEndereco()).isEqualTo("Rua 200, casa 2B");
		Assertions.assertThat(userTest.getRendimento()).isEqualTo(3500.00);
		Assertions.assertThat(userTest.getRisco()).isEqualTo("B");
		Assertions.assertThat(userTest.getTipo()).isEqualTo("Potencial");
		Assertions.assertThat(userTest.getEmpregado()).isEqualTo("Não");
		Assertions.assertThat(userTest.getPatrimonio()).isEqualTo(30000.67);
		Assertions.assertThat(userTest.getDivida()).isEqualTo(500.00);
	}
	
	
}
