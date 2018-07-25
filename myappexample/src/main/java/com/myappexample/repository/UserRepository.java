package com.myappexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myappexample.entity.User;


/**
 * @author diego.lopes.da.costa
 * Coment: Classe de interface do repositório de cliente
 * 
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}
