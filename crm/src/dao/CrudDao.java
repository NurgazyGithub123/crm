package dao;

import model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract interface CrudDao<Model> {

    default Connection getConnection() throws SQLException {
        final String URL = "jdbc:postgresql://localhost:5432/crm";
        final String USERNAME = "postgres";
        final String PASSWORD = "123";

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    Model save(Model model);
    Model findById(Long id);
    void findByAll();
}
