package com.reorg.user_setting.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reorg.user_setting.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface  UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.username = :username and u.password = :password")
    List<User> findByUsernameAndPassword(@Param("username") String username,
                                   @Param("password")String password);
}
