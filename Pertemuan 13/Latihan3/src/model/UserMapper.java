package model;

import java.util.List;
import org.apache.ibatis.annotations.*;;

public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> getAllUsers();

    @Insert("INSERT INTO users (name, email, phone, address, age) VALUES (#{name}, #{email}, #{phone}, #{address}, #{age})")
    void insertUser(User user);

    @Update("UPDATE users SET name = #{name}, email = #{email}, phone = #{phone}, address = #{address}, age = #{age} WHERE id = #{id}")
    void updateUser(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUser(int id);

}
