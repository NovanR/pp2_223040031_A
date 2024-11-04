package dao;

import java.sql.Statement;
import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Biodata;

public class BiodataDao {
    public int insert(Biodata biodata) {
        int result = -1;

        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO detail (id, nama, jenis_kelamin, alamat) VALUES (?, ?, ?, ?)");
            statement.setString(1, biodata.getId());
            statement.setString(2, biodata.getNama());
            statement.setString(3, biodata.getJenis_kelamin());
            statement.setString(4, biodata.getAlamat());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int update(Biodata biodata) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE detail SET nama = ?, jenis_kelamin = ?, alamat = ?  WHERE id = ?");
            statement.setString(1, biodata.getNama());
            statement.setString(2, biodata.getJenis_kelamin());
            statement.setString(3, biodata.getAlamat());
            statement.setString(4, biodata.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(Biodata biodata) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM detail WHERE id = ?");
            statement.setString(1, biodata.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Biodata> findAll() {
        List<Biodata> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery(
                    "SELECT detail.id, detail.nama, detail.jenis_member_id, jenis_member.id AS jenis_member_id, jenis_member.nama AS jenis_member_nama "
                            +
                            "FROM member " +
                            "JOIN jenis_member ON jenis_member.id = member.jenis_member_id")) {

                // Mengambil data dari ResultSet
                while (resultSet.next()) {
                    // Membuat objek Member
                    Biodata biodata = new Biodata();
                    biodata.setId(resultSet.getString("id"));
                    biodata.setNama(resultSet.getString("nama"));
                    biodata.setJenis_kelamin(resultSet.getString("jenis kelamin"));
                    biodata.setAlamat(resultSet.getString("alamat"));

                    // Menambahkan Member ke dalam list
                    list.add(biodata);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
