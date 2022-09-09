package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BusinessTitle;

@Mapper
@Repository
public interface BusinessTitleDao {
    @Select("select * from business_title where id=#{id}")
    public BusinessTitle selectById(int id);

    @Insert("<script> insert into `business_title`(id,contact,left,right) values"
            + "(#{title.id},#{title.contact},#{title.left},#{title.right})</script>")
    public int insert(@Param("title") BusinessTitle title);

    @Update("<script>update `business_title` set `contact`=#{title.contact}, "
            + "`left`=#{title.left}, `right`=#{title.right} where id=#{title.id}</script>")
    public int update(@Param("title") BusinessTitle title);
}
