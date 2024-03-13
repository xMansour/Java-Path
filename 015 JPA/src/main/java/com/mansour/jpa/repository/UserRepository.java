package com.mansour.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mansour.jpa.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByDepartmentName(String name);

    // JPQL
    @Query(value = "select user from User user where user.name like :name")
    List<User> filter(@Param(value = "name") String name);

    //Native Query
    @Query(value = "select * from user where user.name like :name", nativeQuery = true)
    List<User> filterNativeQuery(@Param(value = "name") String name);

}
