package com.mansour.jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mansour.jpa.model.User;
import com.mansour.jpa.model.UserStatisticProjection;
import com.mansour.jpa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Long id) {
        User user = getUser(id);
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public List<User> findByDepartmentName(String name) {
        return userRepository.findByDepartmentName(name);
    }

    @Override
    public List<User> filter(String name, Direction direction, String sortingProperty) {
        return userRepository.filter(name, Sort.by(direction, sortingProperty));
    }

    @Override
    public List<User> filterNativeQuery(String name) {
        return userRepository.filterNativeQuery(name);
    }

    @Override
    public UserStatisticProjection getUserStatisticProjection() {
        return userRepository.getUserStatisticProjection();
    }

    @Override
    public Page<User> getUsersPagable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

}
