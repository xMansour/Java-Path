package com.mansour.springdatajdbc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mansour.springdatajdbc.models.User;


public interface UserRepository extends CrudRepository<User, Long>{

}
