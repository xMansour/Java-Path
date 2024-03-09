package com.mansour.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mansour.demo.models.User;
import com.mansour.demo.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public int count() {
        return userRepository.count();
    }

    @Override
    public User getUser(long id) {
        return userRepository.getUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public void createUser(User user) {
        userRepository.createUser(user);
    }

    @Override
    public User updatUser(User user) {
        return userRepository.updatUser(user);
    }

    @Override
    public User deleteUser(long id) {
        return userRepository.deleteUser(id);
    }


}
