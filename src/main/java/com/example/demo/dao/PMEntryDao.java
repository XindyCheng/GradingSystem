package com.example.demo.dao;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PMEntry;

@Mapper
@Repository
public interface PMEntryDao {
	@Select("select * from PM_Entry")
	public List<PMEntry> selectAll();
	
	@Select("select * from PM_Entry where id=#{id}")
	public PMEntry selectById(int id);
	
	@Delete("delete from PM_Entry where id=#{id}")
	public int deleteById(int id);
	
	@Update("")
	public int update();
	
	@Insert("insert into `PM_entry` values (#{id},#{time},#{contractnumber},#{supplier},#{client},#{start},#{total},#{state},#{bg},#{score},#{pmname},#{cmname},#{dmname},#{comment})")
	public int insert(PMEntry entry);
}
