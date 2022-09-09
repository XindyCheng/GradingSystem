package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Display;

@Mapper
@Repository
public interface DisplayDao {
    @Select("select * from display")
    public List<Display> selectAll();

    @Select("select * from display where id=#{id}")
    public Display selectById(int id);

    @Insert("<script> insert into `display`(time,title,content,image_url) values(#{display.time},"
            + "#{display.title},#{display.content},#{display.imageurl}) " + "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "entry.id")
    public int insert(@Param("display") Display display);

}
