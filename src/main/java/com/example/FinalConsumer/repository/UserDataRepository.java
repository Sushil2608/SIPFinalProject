package com.example.FinalConsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FinalConsumer.model.User;

public interface UserDataRepository extends JpaRepository<User, Long>{

}