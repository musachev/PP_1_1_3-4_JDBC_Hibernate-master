package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static final Connection conn = Util.getInstance().getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS users " +
                    "(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), last_name VARCHAR(255), age INT)");
            create.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            PreparedStatement create = conn.prepareStatement("DROP TABLE IF EXISTS users");
            create.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            PreparedStatement create = conn.prepareStatement("INSERT INTO users (name, last_name, age) VALUES (?, ?, ?)");
            create.setString(1, name);
            create.setString(2, lastName);
            create.setByte(3, age);
            create.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            PreparedStatement create = conn.prepareStatement("DELETE FROM users WHERE id = ?");
            create.setLong(1, id);
            create.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try {
            PreparedStatement create = conn.prepareStatement("SELECT * FROM users");
            ResultSet result = create.executeQuery();

            List<User> users = new ArrayList<>();

            while (result.next()) {
                User user = new User(result.getString("name"),
                        result.getString("last_name"), result.getByte("age"));
                user.setId(result.getLong("id"));
                users.add(user);
            }
            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void cleanUsersTable() {
        try {
            PreparedStatement create = conn.prepareStatement("TRUNCATE TABLE users");
            create.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
