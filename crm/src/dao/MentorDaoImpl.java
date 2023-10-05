package dao;

import model.Mentor;

import java.sql.*;
import java.time.LocalDate;

public class MentorDaoImpl extends DaoFactory implements MentorDao {

    public MentorDaoImpl() {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection();

            String ddlQuery = "CREATE TABLE IF NOT EXISTS tb_mentor(" +
                    "id           BIGSERIAL, " +
                    "first_name   VARCHAR(50)  NOT NULL, " +
                    "last_name    VARCHAR(50)  NOT NULL, " +
                    "email        VARCHAR(100) NOT NULL, " +
                    "phone_number CHAR(13)     NOT NULL, " +
                    "salary       MONEY        NOT NULL CHECK ( salary > MONEY (0))," +
                    "dob          DATE         NOT NULL CHECK (dob < now()), " +
                    "date_created TIMESTAMP    NOT NULL DEFAULT now(), " +
                    "" +
                    "CONSTRAINT pk_mentor_id PRIMARY KEY(id), " +
                    "CONSTRAINT uniq_mentor_email UNIQUE(email)" +
                    ")";

            statement = connection.createStatement();
            statement.execute(ddlQuery);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                close(statement);
                close(connection);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Mentor save(Mentor mentor) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Mentor savedMentor = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            String creatQuery = "INSERT INTO tb_mentor(first_name, last_name, phone_number, email, dob, salary, date_created) " +
                    "VALUES(?,?,?,?,?,MONEY(?),?)";

            String readQuery = "SELECT * FROM tb_mentor ORDER BY id LIMIT DESC 1";

            preparedStatement = connection.prepareStatement(creatQuery);
            preparedStatement.setString(1, mentor.getFirstName());
            preparedStatement.setString(2, mentor.getLastName());
            preparedStatement.setString(3, mentor.getPhoneNumber());
            preparedStatement.setString(4, mentor.getEmail());
            preparedStatement.setDate(5, Date.valueOf(mentor.getDob()));
            preparedStatement.setString(6, mentor.getSalary() + "");
            preparedStatement.setTimestamp(7, Timestamp.valueOf(mentor.getDateCreated()));

            preparedStatement.execute();
            close(preparedStatement);

            preparedStatement = connection.prepareStatement(readQuery);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            savedMentor = new Mentor();
            savedMentor.setId(resultSet.getLong("id"));
            savedMentor.setFirstName(resultSet.getString("first_name"));
            savedMentor.setLastName(resultSet.getString("last_name"));
            savedMentor.setEmail(resultSet.getString("email"));
            savedMentor.setSalary(Double.valueOf(resultSet.getString("salary").replaceAll("[^\\d\\.] +", "")));
            savedMentor.setDob(resultSet.getDate("dob").toLocalDate());
            savedMentor.setDateCreated(resultSet.getTimestamp("dateCreated").toLocalDateTime());


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                close(resultSet);
                close(preparedStatement);
                close(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return savedMentor;
    }

    @Override
    public Mentor findById(Long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;
        Mentor mentor = null;

        try {
            connection = getConnection();

            String findId = "SELECT * FROM tb_mentor WHERE id = ?";

            preparedStatement = connection.prepareStatement(findId);
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            mentor = new Mentor();
            mentor.setId(resultSet.getLong("id"));
            mentor.setLastName(resultSet.getString("last_name"));
            mentor.setFirstName(resultSet.getString("first_name"));
            mentor.setEmail(resultSet.getString("email"));
            mentor.setDob(resultSet.getDate("dob").toLocalDate());
            mentor.setDateCreated(resultSet.getTimestamp("date_created").toLocalDateTime());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);

        }

        return mentor;
    }

    @Override
    public void findByAll() {

    }

    private void close(AutoCloseable autoCloseable) {
        try {
            System.out.println(autoCloseable.getClass().getSimpleName() + "closing");
            autoCloseable.close();
            System.out.println(autoCloseable.getClass().getSimpleName() + "closed");
        } catch (Exception e) {
            System.out.println("Could not close" + autoCloseable.getClass().getSimpleName());
            e.printStackTrace();
        }
    }

}
