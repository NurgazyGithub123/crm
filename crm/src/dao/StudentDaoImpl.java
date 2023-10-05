package dao;

import model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class StudentDaoImpl implements StudentDao {

    public StudentDaoImpl() {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection();

            String ddlQuery = "CREATE TABLE IF NOT EXISTS tb_student(" +
                    "id           BIGSERIAL, " +
                    "first_name   VARCHAR(50)  NOT NULL, " +
                    "last_name    VARCHAR(50)  NOT NULL, " +
                    "email        VARCHAR(100) NOT NULL, " +
                    "phone_number CHAR(13)     NOT NULL, " +
                    "dob          DATE         NOT NULL CHECK(dob < now())," +
                    "date_created TIMESTAMP    NOT NULL DEFAULT now(), " +
                    "" +
                    "CONSTRAINT pk_student_id PRIMARY KEY(id), " +
                    "CONSTRAINT uniq_student_email UNIQUE(email)" +
                    ")";

            statement = connection.createStatement();
            statement.execute(ddlQuery);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                close(statement);
                close(connection);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public Student save(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Student savedStudent = null;
        ResultSet resultSet = null;

        try {

            connection = getConnection();

            String creatQuery = "INSERT INTO tb_student(first_name, last_name, email, phone_number, dob, date_created)" +
                    "VALUES(?,?,?,?,?,?)";

            String readQuery = "SELECT * FROM tb_student ORDER BY id DESC LIMIT 1";

            preparedStatement = connection.prepareStatement(creatQuery);
            preparedStatement.setString(1,student.getFirstName());
            preparedStatement.setString(2,student.getLastName());
            preparedStatement.setString(3,student.getEmail());
            preparedStatement.setString(4,student.getPhoneNumber());
            preparedStatement.setDate(5,Date.valueOf(student.getDob()));
            preparedStatement.setTimestamp(6,Timestamp.valueOf(student.getDateCreated()));

            preparedStatement.execute();
            close(preparedStatement);

            preparedStatement = connection.prepareStatement(readQuery);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            savedStudent = new Student();
            savedStudent.setId(resultSet.getLong("id"));
            savedStudent.setFirstName(resultSet.getString("first_name"));
            savedStudent.setLastName(resultSet.getString("last_name"));
            savedStudent.setEmail(resultSet.getString("email"));
            savedStudent.setPhoneNumber(resultSet.getString("phone_number"));
            savedStudent.setDob(resultSet.getDate("dob").toLocalDate());
            savedStudent.setDateCreated(resultSet.getTimestamp("date_created").toLocalDateTime());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                close(resultSet);
                close(preparedStatement);
                close(connection);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return savedStudent;
    }

    @Override
    public Student findById (Long id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Student student = null;

        try {
            connection = getConnection();

            String findById = "SELECT * FROM tb_student WHERE id = ?";

            preparedStatement = connection.prepareStatement(findById);
            preparedStatement.setLong(1,id);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            student = new Student();
            student.setId(resultSet.getLong("id"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
            student.setPhoneNumber(resultSet.getString("phone_number"));
            student.setEmail(resultSet.getString("email"));
            student.setDob(resultSet.getDate("dob").toLocalDate());
            student.setDateCreated(resultSet.getTimestamp("date_created").toLocalDateTime());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return student;
    }

    @Override
    public void findByAll () {

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
