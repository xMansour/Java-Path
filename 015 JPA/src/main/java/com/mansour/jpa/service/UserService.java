package com.mansour.jpa.service;

import java.util.List;

import com.mansour.jpa.model.User;

public interface UserService {

    List<User> getUsers();

    User getUser(Long id);

    User createUser(User user);

    User updateUser(User user);

    User deleteUser(Long id);

    List<User> findByDepartmentName(String name);

    List<User> filter(String name);

    List<User> filterNativeQuery(String name);

}
