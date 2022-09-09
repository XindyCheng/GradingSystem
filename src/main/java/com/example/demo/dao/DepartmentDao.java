package com.example.demo.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;

@Mapper
@Repository
public interface DepartmentDao {
    @Insert("<script>" + "insert into `departments`" + "(id,layer,p_id,name) "
            + "values(#{department.id},#{department.layer}," + "#{department.pid},#{department.name})" + "</script>")
    public int addDepartment(@Param("department") Department department);

    @Select("select * from departments where p_id=#{pid}")
    public Department selectByPid(int pid);

    @Select("select * from departments where id=#{id}")
    public Department selectById(int id);

    @Delete("delete from departments")
    public int deleteAll();

}
