package com.mansour.demo.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mansour.demo.mappers.UserMapper;
import com.mansour.demo.models.User;

@Repository
public class UserRepositoryJDBCImpl implements UserRepository {
    private JdbcTemplate jdbcTemplate;

    

    public UserRepositoryJDBCImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USER", Integer.class);
    }

    @Override
    public User getUser(long id) {
        return jdbcTemplate.query("SELECT * FROM USER WHERE ID = ?", new UserMapper(), new Object[]{id}).get(0);
    }

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM USER", new UserMapper());
    }

    @Override
    public void createUser(User user) {
        jdbcTemplate.update("INSERT INTO USER (NAME, GENDER, AGE) VALUES (?, ?, ?)",
                new Object[] { user.getName(), user.getGender(), user.getAge() });
    }

    @Override
    public User updatUser(User user) {
        jdbcTemplate.update("UPDATE USER SET NAME = ?, GENDER = ?, AGE = ? WHERE ID = ?", user.getName(),
                user.getGender(), user.getAge(), user.getId());
        return getUser(user.getId());
    }

    @Override
    public User deleteUser(long id) {
        User user = getUser(id);
        jdbcTemplate.update("DELETE FROM USER WHERE ID = ?", id);
        return user;
    }

}
