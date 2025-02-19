package com.example.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    // 1. 实现查询所有用户
    @Select("select * from user")
    List<User> findAll();
    // 2. 根据用户id查询用户
    @Select("select * from user where id = #{id}")
    User findById(Long id);

    // 3. 添加新用户
    @Insert("insert into user(id, name) value(#{id}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(User user);
    // 4. 根据用户id删除用户
    @Delete("delete from user where id = #{id}")
    void deleteUser(Long id);
    // 5. 根据用户id更新用户
    @Update("update user set name = #{name} where id = #{id}")
    void updateUser(@Param("id") Long id, @Param("name") String name);
}
