package com.jdcolorado.portafolioapp.repository.impl;

import com.jdcolorado.portafolioapp.model.User;
import com.jdcolorado.portafolioapp.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private User mapRowToUser(ResultSet rs, int numRow) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEnabled(rs.getBoolean("enabled"));
        return user;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        String sql = "SELECT id, username, password, enabled FROM users WHERE username = ?";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, this::mapRowToUser, username));
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }
}
