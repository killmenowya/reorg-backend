package com.reorg.user_setting.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reorg.user_setting.models.User;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface  UserRepository extends JpaRepository<User, String> {
}
