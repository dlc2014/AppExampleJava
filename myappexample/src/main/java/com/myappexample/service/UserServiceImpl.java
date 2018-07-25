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

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	



	@Override
	public void createUser(Map<String, User> params) {
		System.out.println(">>> Service -  createUser");
		userRepository.save(params.get("data"));
	}
	
	@Override
	public List <User> getAllUsers(){
		System.out.println(">>> Service - getAllUsers");
		return userRepository.findAll(sortByIdDesc());
	}
	
	private Sort sortByIdDesc() {
        return new Sort(Sort.Direction.DESC, "id");
    }
	
	@Override
	public void deleteUser(Map<String, User> params) {
		System.out.println(">>> Service -  deleteUser");
		userRepository.deleteById(params.get("data").getId());
	}

	@Override
	public void updateUser(Map<String, User> params) {
		System.out.println(">>> Service -  updateUser");
		
		
		
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

	
	@Override
	public double simulate(Simulate objData) {
		System.out.println(">>> Service -  simulate");
		
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

		System.out.println("resultado = "+result);
		
// Fórmula utilizada:
//				P = R$6.000,00
//				t = 1 ano = 12 meses
//				i = 3,5 % a.m. = 0,035
//				M = ?
//
//				Usando a fórmula M=P.(1+i)n, obtemos:
//
//				M  =  6000.(1+0,035)12  =  6000. (1,035)12 = 9066,41
		
		return result;
		
	}
	
	
	
}
	

