package com.bootcamp.hql.controllers;

import com.bootcamp.hql.dtos.PasswordUpdate;
import com.bootcamp.hql.dtos.UserDTO;
import com.bootcamp.hql.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDTO save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/by/name")
    public UserDTO findByName(@RequestParam String name) {
        return userService.findByName(name);
    }

    @GetMapping("/by/password")
    public List<UserDTO> findByPassword(@RequestParam String password) {
        return userService.findByPassword(password);
    }

    @GetMapping("/by/name/password")
    public UserDTO findByNameAndPassword(UserDTO userDTO) {
        return userService.findByNameAndPassword(userDTO.getName(), userDTO.getPassword());
    }

    @PutMapping("/{id}")
    public UserDTO update(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        userDTO.setId(id);
        return userService.save(userDTO);
    }

    @PatchMapping("/{id}")
    public UserDTO updatePassowrd(@RequestBody PasswordUpdate password, @PathVariable Long id) {
        return userService.updatePassword(id, password.getPassword());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
