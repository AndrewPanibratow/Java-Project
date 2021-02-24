package com.website.hotel.repositories;

import com.website.hotel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private String Create_Statement = "INSERT INTO HOTEL VALUES(?,?,?,?,?)";
    private String Fint_By_Login = "SELECT U.ID FROM User AS U WHERE U.Login = ?";
    private String Fint_By_Email = "SELECT U.ID FROM User AS U WHERE U.Email = ?";
    private String Find_By_Log_Pass = "SELECT U.ID FROM User AS U WHERE U.Login = ? AND U.Password = ?";
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Integer create(String Name, String Surname, String Email, String Login, String Password) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(Create_Statement, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,Name);
            preparedStatement.setString(2,Surname);
            preparedStatement.setString(3,Email);
            preparedStatement.setString(4,Login);
            preparedStatement.setString(5,Password);
            return preparedStatement;
        }, keyHolder);
        return (Integer) keyHolder.getKeys().get("Id");
    }

    @Override
    public User findById(int Id) {
        return jdbcTemplate.queryForObject(Fint_By_Email,new Object[]{Id}, userMapper);
    }

    @Override
    public Integer findByLoginAndPassword(String Login, String Password) {
        return jdbcTemplate.queryForObject(Find_By_Log_Pass,new Object[]{Login, Password},Integer.class);
    }

    @Override
    public Integer FindByLogin(String Login) {
        return jdbcTemplate.queryForObject(Fint_By_Login,new Object[]{Login},Integer.class);
    }

    @Override
    public Integer FindByEmail(String Email) {
        return jdbcTemplate.queryForObject(Fint_By_Email,new Object[]{Email},Integer.class);
    }
    private RowMapper<User> userMapper = ((rs,rowNum)->{
        return new User(
                rs.getInt("Id"),
                rs.getString("Name"),
                rs.getString("Surname"),
                rs.getString("Email"),
                rs.getString("Login"),
                rs.getString("Password")

        );
    });
}
