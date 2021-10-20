package org.example.service;

import org.example.dto.LoginDto;
import org.example.dto.UserDto;
import org.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginService {

    private final List<User> list = new ArrayList<>();

    private final Map<String, String> tokenMap = new HashMap<>();

    public UserDto signUp(User user) {
        boolean notContainsUser = list.stream()
                .noneMatch(userFromList -> userFromList.getLogin().equals(user.getLogin()));
        if (notContainsUser) {
            list.add(user);
            return new UserDto(user.getName());
        }
        throw new RuntimeException("User already exists");
    }

    public String signIn(LoginDto loginDto) {
        Optional<User> userOptional = list.stream()
                .filter(user -> user.getLogin().equals(loginDto.getLogin()))
                .filter(user -> user.getPassword().equals(loginDto.getPassword()))
                .findAny();
        if (userOptional.isPresent()) {
            String token = UUID.randomUUID().toString();
            tokenMap.put(token, loginDto.getLogin());
            return token;
        }
        throw new RuntimeException("Login or password incorrect");
    }

    public void checkAuthorization(String token) {
        String login = tokenMap.get(token);
        if (login == null){
            throw new RuntimeException("Wrong token");
        }
    }
}
