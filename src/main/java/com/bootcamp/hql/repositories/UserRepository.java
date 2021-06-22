package com.bootcamp.hql.repositories;

import com.bootcamp.hql.dtos.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserDTO, Long> {

    @Query("SELECT user FROM UserDTO user WHERE user.name = :name")
    UserDTO findByUserName(String name);

    @Query("SELECT user FROM UserDTO user WHERE user.password = :password")
    List<UserDTO> findByUserPassword(String password);

    @Query("SELECT user FROM UserDTO user WHERE user.name = :name AND user.password = :password")
    UserDTO findByUserNameAndPassword(String name, String password);

    @Modifying
    @Query("UPDATE UserDTO user set user.password = :password WHERE user.id = :id")
    int updatePassword(Long id, String password);

    @Modifying
    @Query("DELETE FROM UserDTO user WHERE user.id = :id")
    void deleteById(Long id);
}
