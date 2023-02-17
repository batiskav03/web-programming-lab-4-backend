package web.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import web.model.User;

@Service
public class UserService {

    private final UserDetailsManager users;

    public UserService(UserDetailsManager users) {
        this.users = users;
    }

    public void registerUser(User user, HttpServletRequest request) throws ServletException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        String result = "{bcrypt}" + encoder.encode(user.getPassword());
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(user.getLogin())
                .password(result)
                .roles("USER")
                .build();
        users.createUser(userDetails);

        request.login(user.getLogin(), result);
    }
}
