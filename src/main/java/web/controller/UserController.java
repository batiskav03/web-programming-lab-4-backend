package web.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.sql.DataSource;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
     this.service = service;
    }

    @PostMapping("/register")
    public void createUser(@RequestBody User user, HttpServletRequest request) throws ServletException {
        service.registerUser(user, request);
    }

}
