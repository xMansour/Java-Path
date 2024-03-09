package com.mansour.demo.repositories;

import java.util.List;

import com.mansour.demo.models.User;

public interface UserRepository {
    int count();

    User getUser(long id);

    List<User> getUsers();

    void createUser(User user);

    User updatUser(User user);

    User deleteUser(long id);
}
