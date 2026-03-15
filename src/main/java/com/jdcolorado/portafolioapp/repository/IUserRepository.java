package com.jdcolorado.portafolioapp.repository;

import com.jdcolorado.portafolioapp.model.User;

import java.util.Optional;

public interface IUserRepository {

    Optional<User> findByUsername(String username);
}
