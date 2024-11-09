package dao;

import db.MySQLConnection;
import model.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

    // Method untuk menambahkan data person
    public int insert(Person person) {
        int result = -1;
        try (Connection connection = MySQLConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO person (nama, alamat, umur) VALUES (?, ?, ?)");
            statement.setString(1, person.getNama());
            statement.setString(2, person.getAlamat());
            statement.setInt(3, person.getUmur());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Method untuk memperbarui data person
    public int update(Person person) {
        int result = -1;
        try (Connection connection = MySQLConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE person SET nama = ?, alamat = ?, umur = ? WHERE id = ?");
            statement.setString(1, person.getNama());
            statement.setString(2, person.getAlamat());
            statement.setInt(3, person.getUmur());
            statement.setInt(4, person.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Method untuk menghapus data person
    public int delete(Person person) {
        int result = -1;
        try (Connection connection = MySQLConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM person WHERE id = ?");
            statement.setInt(1, person.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Method untuk mendapatkan semua data person
    public List<Person> findAll() {
        List<Person> list = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM person");
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setNama(resultSet.getString("nama"));
                person.setAlamat(resultSet.getString("alamat"));
                person.setUmur(resultSet.getInt("umur"));
                list.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
