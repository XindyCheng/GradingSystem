package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ClientProject;

@Mapper
@Repository
public interface ClientProjectDao {
    @Insert("<script>" + "insert into `client_project`(id,time,name,demand,business,other) "
            + "values (#{project.id},#{project.time},#{project.name},#{project.demand},"
            + "#{project.business},#{project.other})" + "</script>")
    public int insert(@Param("project") ClientProject project);

    @Select("select * from client_project")
    public List<ClientProject> selectAll();

    @Select("select * from client_project where id=#{id}")
    public ClientProject selectById(int id);

}
