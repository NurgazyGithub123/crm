package dao;

import model.Manager;

import java.sql.*;

public class ManagerDaoImpl extends DaoFactory implements ManagerDao{

    public ManagerDaoImpl(){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();

            String ddlQuery = "CREATE TABLE IF NOT EXISTS tb_manager(" +
                    "id           BIGSERIAL, " +
                    "first_name   VARCHAR(50)   NOT NULL, " +
                    "last_name    VARCHAR(50)   NOT NULL, " +
                    "email        VARCHAR(100)  NOT NULL UNIQUE, " +
                    "phone_number CHAR(13)      NOT NULL, " +
                    "salary       MONEY         NOT NULL CHECK ( salary > MONEY (0)), " +
                    "dob          DATE          NOT NULL CHECK (dob < now()), " +
                    "date_created TIMESTAMP     NOT NULL DEFAULT now(), " +
                    "" +
                    "CONSTRAINT pk_manager_id PRIMARY KEY(id)" +
                    ")";

            statement = connection.createStatement();
            statement.execute(ddlQuery);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                close(statement);
                close(connection);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Manager save(Manager manager){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Manager savedManager = null;

        try {
           connection = getConnection();

            String createQuery = "INSERT INTO tb_manager(first_name, last_name, email, phone_number, dob, salary, date_created)" +
                            "VALUES(?,?,?,?,?,MONEY(?),?)";

            String readQuery = "SELECT * FROM tb_manager ORDER BY id DESC LIMIT 1";

            preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setString(1, manager.getFirstName());
            preparedStatement.setString(2, manager.getLastName());
            preparedStatement.setString(3, manager.getEmail());
            preparedStatement.setString(4, manager.getPhoneNumber());
            preparedStatement.setDate(5, Date.valueOf(manager.getDob()));
            preparedStatement.setString(6, manager.getSalary() + "");
            preparedStatement.setTimestamp(7,Timestamp.valueOf(manager.getDateCreated()));

            preparedStatement.execute(); // отправка в бд
            close(preparedStatement);

            preparedStatement = connection.prepareStatement(readQuery);
            resultSet = preparedStatement.executeQuery();  // вытащили данные в результ табл

            resultSet.next();

            savedManager = new Manager();
            savedManager.setId(resultSet.getLong("id"));
            savedManager.setFirstName(resultSet.getString("first_name"));
            savedManager.setLastName(resultSet.getString("last_name"));
            savedManager.setEmail(resultSet.getString("email"));
            savedManager.setDob(resultSet.getDate("dob").toLocalDate());
            savedManager.setSalary(Double.valueOf(resultSet.getString("salary").replaceAll("[^\\d\\.]+","")));
            savedManager.setDateCreated(resultSet.getTimestamp("date_created").toLocalDateTime());

            System.out.println(savedManager);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                close(resultSet);
                close(preparedStatement);
                close(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return savedManager;
    }

    @Override
    public Manager findById(Long id) {

            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            Manager manager = null;

        try {
            connection = getConnection();

            String findById = "SELECT * FROM tb_manager WHERE id = ?";

            preparedStatement = connection.prepareStatement(findById);
            preparedStatement.setLong(1, id); // вытащили из БД в preparedStatement

            resultSet = preparedStatement.executeQuery();
            resultSet.next(); // наводка курсора

            manager = new Manager();
            manager.setId(resultSet.getLong("id"));
            manager.setFirstName(resultSet.getString("first_name"));
            manager.setLastName(resultSet.getString("last_name"));
            manager.setPhoneNumber(resultSet.getString("phone_number"));
            manager.setEmail(resultSet.getString("email"));
            manager.setDob(resultSet.getDate("dob").toLocalDate());
            manager.setDateCreated(resultSet.getTimestamp("date_created").toLocalDateTime());
            manager.setSalary(Double.valueOf(resultSet.getString("salary").replaceAll("[^\\d\\.]+","")));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return manager;
    }

    @Override
    public void findByAll() {

    }

    private void close(AutoCloseable autoCloseable){
        try {
            System.out.println(autoCloseable.getClass().getSimpleName() + " closing");
            autoCloseable.close();
            System.out.println(autoCloseable.getClass().getSimpleName() + " closed");
        } catch (Exception e) {
            System.out.println( "Could not close" + autoCloseable.getClass().getSimpleName());
            e.printStackTrace();
        }
    }
}
