package com.mansour.jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.mansour.jpa.model.User;
import com.mansour.jpa.model.UserStatisticProjection;

public interface UserService {

    List<User> getUsers();

    User getUser(Long id);

    Page<User> getUsersPagable(Pageable pageable);

    User createUser(User user);

    User updateUser(User user);

    User deleteUser(Long id);

    List<User> findByDepartmentName(String name);

    List<User> filter(String name, Direction direction, String sortingProperty);

    List<User> filterNativeQuery(String name);

    UserStatisticProjection getUserStatisticProjection();

}
