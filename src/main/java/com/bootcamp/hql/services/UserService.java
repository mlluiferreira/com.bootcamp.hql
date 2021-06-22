package com.bootcamp.hql.services;

import com.bootcamp.hql.dtos.UserDTO;
import com.bootcamp.hql.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO save(UserDTO user) {
        return userRepository.save(user);
    }

    public UserDTO findByName(String name) {
        return userRepository.findByUserName(name);
    }

    public List<UserDTO> findByPassword(String password) {
        return userRepository.findByUserPassword(password);
    }

    public UserDTO findByNameAndPassword(String name, String password) {
        return userRepository.findByUserNameAndPassword(name, password);
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll();
    }
}
