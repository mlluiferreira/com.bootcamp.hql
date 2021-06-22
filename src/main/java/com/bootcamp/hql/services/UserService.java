package com.bootcamp.hql.services;

import com.bootcamp.hql.dtos.UserDTO;
import com.bootcamp.hql.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO save(UserDTO user) {
        return userRepository.save(user);
    }

    @Transactional
    public UserDTO updatePassword(Long id, String password) {
        userRepository.updatePassword(id, password);
        return userRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) { userRepository.deleteById(id); }

    public UserDTO findByName(String name) {
        return userRepository.findByUserName(name);
    }

    public List<UserDTO> findByPassword(String password) {
        return userRepository.findByUserPassword(password);
    }

    public UserDTO findByNameAndPassword(String name, String password) { return userRepository.findByUserNameAndPassword(name, password); }

    public List<UserDTO> findAll() {
        return userRepository.findAll();
    }
}
