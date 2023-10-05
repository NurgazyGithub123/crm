package dao;

import model.Address;

import java.sql.*;

public class AddressDaoImpl extends DaoFactory implements AddressDao {

    public AddressDaoImpl() {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection();

            String createQuery = "CREATE TABLE IF NOT EXISTS tb_address(" +
                    "id        BIGSERIAL, " +
                    "country   VARCHAR(50) NOT NULL, " +
                    "city      VARCHAR(50), " +
                    "region    VARCHAR(50), " +
                    "district  VARCHAR(50), " +
                    "apartment VARCHAR(50), " +
                    "" +
                    "CONSTRAINT pk_address_id PRIMARY KEY(id)" +
                    ")";

            statement = connection.createStatement();
            statement.execute(createQuery);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                close(statement);
                close(connection);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Address save(Address address) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Address saveAdress = null;

        try {
            connection = getConnection();

            String saveQuery = "INSERT INTO tb_address(country, city, region, district, apartment) " +
                    "VALUES (?, ?, ?, ?, ?)";

            String readQuery = "SELECT * FROM tb_address ORDER BY id DESC LIMIT 1";

            preparedStatement = connection.prepareStatement(saveQuery);
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getRegion());
            preparedStatement.setString(4, address.getDistrict());
            preparedStatement.setString(5, address.getApartment());

            preparedStatement.execute();
            close(preparedStatement);

            preparedStatement = connection.prepareStatement(readQuery);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            saveAdress = new Address();
            saveAdress.setId(resultSet.getLong("id"));
            saveAdress.setCountry(resultSet.getString("country"));
            saveAdress.setCity(resultSet.getString("city"));
            saveAdress.setRegion(resultSet.getString("region"));
            saveAdress.setDistrict(resultSet.getString("district"));
            saveAdress.setApartment(resultSet.getString("apartment"));


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
        return saveAdress;
    }

    @Override
    public Address findById(Long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Address address = null;

        try {
            connection = getConnection();

            String findId = "SELECT * FROM tb_address WHERE id = ?";

            preparedStatement = connection.prepareStatement(findId);
            preparedStatement.setLong(1,id);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            address = new Address();
            address.setId(resultSet.getLong("id"));
            address.setCountry(resultSet.getString("country"));
            address.setCity(resultSet.getString("city"));
            address.setRegion(resultSet.getString("region"));
            address.setDistrict(resultSet.getString("district"));
            address.setApartment(resultSet.getString("apartment"));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                close(resultSet);
                close(preparedStatement);
                close(connection);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return address;
    }

    @Override
    public void findByAll() {

    }

    private void close(AutoCloseable autoCloseable) throws SQLException{
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
