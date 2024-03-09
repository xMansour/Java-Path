package com.mansour.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mansour.demo.models.User;
import com.mansour.demo.services.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/count")
    public int getCount() {
        return userService.count();
    }

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") long id) {
        return userService.getUser(id);
    }

    // @PostMapping("/")
    // public void addUser(@RequestParam("userName") String userName, @RequestParam("gender") String gender, @RequestParam("age") int age) {
    //     userService.createUser(new User(userName, gender, age));
    // }

    @PostMapping()
    public void addUser(@RequestBody User user) {
        userService.createUser(new User(user.getName(), user.getGender(), user.getAge()));
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        return userService.updatUser(user);
    }


    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") long id){
        return userService.deleteUser(id);
    }
    
}
