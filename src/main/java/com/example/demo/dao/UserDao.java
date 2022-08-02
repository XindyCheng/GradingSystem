package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.User;

@Mapper
@Repository
public interface UserDao{
	@Select("SELECT * FROM user")
	public List<User> selectAll();
	
	@Select("SELECT * FROM user WHERE id=#{id}")
	public User selectById(int id);
	
	@Select("SELECT * FROM user WHERE name=#{name}")
	public User selectByName(String name);
	
	@Delete("delete from user where id=#{id}")
	public int deleteById(int id);
	
	@Update("update user set password=#{password} where id=#{id}")
	public int updatePassword(@Param("id")int id,@Param("password")String password);
	
	@Insert("insert into user(name, password) values(#{name},#{password})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int insert(User user);
}
