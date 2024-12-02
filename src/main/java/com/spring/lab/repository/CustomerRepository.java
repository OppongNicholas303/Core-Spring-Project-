package com.spring.lab.repository;

import com.spring.lab.DTO.CustomerDTo;
import com.spring.lab.DTO.Message;
import com.spring.lab.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class CustomerRepository {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private Message message;
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

    public Message updateCustomer(int id, CustomerDTo customerDTo){
        String sql = "UPDATE customer "
                + "SET name = ?, email = ? "
                + "WHERE id = ?";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsInserted = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, customerDTo.name());
            ps.setString(2, customerDTo.email());
            ps.setInt(3, id);
            return ps;
        }, keyHolder);

        if (rowsInserted > 0) {
            message.setMessage("Updated successfully");
            System.out.println("appddata");
            return message;
        } else {
            return null;
        }

    }

public Message deleteCustomer(int id){
    String sql = "DELETE FROM customer WHERE id = ?";
    KeyHolder keyHolder = new GeneratedKeyHolder();
    int rowsInserted = jdbcTemplate.update(connection -> {
        PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
        ps.setInt(1, id);
        return ps;
    }, keyHolder);

    if (rowsInserted > 0){
        message.setMessage("Deleted successfully");
        return message;
    }else {
        return null;
    }
}

public List<CustomerModel> findAllCustomers(){
    String sql = "SELECT id, name, email FROM customer";

    return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
        CustomerModel customer = new CustomerModel();
        customer.setId(resultSet.getInt("id"));
        customer.setName(resultSet.getString("name"));
        customer.setEmail(resultSet.getString("email"));
        return customer;
    });
}

}
