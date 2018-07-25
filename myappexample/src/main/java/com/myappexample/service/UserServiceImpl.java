package com.myappexample.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myappexample.entity.User;
import com.myappexample.repository.UserRepository;
import com.myappexample.vos.Simulate;

/**
 * @author diego.lopes.da.costa
 * Coment: Classe que implementa os métodos de serviço
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	/**
	 * Método utilizado para criar um novo cliente
	 * 
	 */
	@Override
	public void createUser(Map<String, User> params) {
		userRepository.save(params.get("data"));
	}
	
	/**
	 *  Método utilizado para listar os clientes
	 * @return liste de clientes ordenados pelo mais recente
	 */
	@Override
	public List <User> getAllUsers(){
		return userRepository.findAll(sortByIdDesc());
	}
	
	private Sort sortByIdDesc() {
        return new Sort(Sort.Direction.DESC, "id");
    }
	
	/**
	 *  Método utilizado para remover um cliente
	 * 
	 */
	@Override
	public void deleteUser(Map<String, User> params) {
		userRepository.deleteById(params.get("data").getId());
	}

	/**
	 *  Método utilizado para atualizar um clientee
	 * 
	 */
	@Override
	public void updateUser(Map<String, User> params) {
		
		Optional<User> u = userRepository.findById(params.get("data").getId());
		u.get().setNome(params.get("data").getNome());
		u.get().setRendimento(params.get("data").getRendimento());
		u.get().setEndereco(params.get("data").getEndereco());
		u.get().setRisco(params.get("data").getRisco());
		u.get().setTipo(params.get("data").getTipo());
		u.get().setEmpregado(params.get("data").getEmpregado());
		u.get().setPatrimonio(params.get("data").getPatrimonio());
		u.get().setDivida(params.get("data").getDivida());
		userRepository.save(u.get());
	}
	
	/**
	 *  Método utilizado para calcular o juros de um empéstimo para cada cliente baseado no seu risco
	 *  Fórmula utilizada: M  =  6000.(1+0,035)12  =  6000. (1,035)12 = 9066,41
	 * @return double valor do empréstimo
	 */
	@Override
	public double simulate(Simulate objData) {
		
		double valor_emprestimo = objData.getEmprestimo();
		int meses = objData.getMeses();
		String risco = objData.getRisco();
		double result;
		double taxa = 0.0;
		
		if("A".equals(risco)){
			taxa = 0.019;
		}else if("B".equals(risco)){
			taxa = 0.05;
		}else if("C".equals(risco)){
			taxa = 0.1;
		}
	
		result = valor_emprestimo*(Math.pow((1+taxa), meses));
		
		return result;
	}
}
	

