package com.spring.lab.repository;

import com.spring.lab.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class CustomerRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CustomerModel save(CustomerModel customerModel) {
        String sql = "INSERT INTO customer (name, email) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int rowsInserted = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, customerModel.getName());
            ps.setString(2, customerModel.getEmail());
            return ps;
        }, keyHolder);

        if (rowsInserted > 0 && keyHolder.getKey() != null) {
            customerModel.setId((int) keyHolder.getKey().longValue()); // Set the generated ID
            return customerModel; // Return the updated customer with the ID
        } else {
            return null; // Return null if insertion fails
        }
    }


}
