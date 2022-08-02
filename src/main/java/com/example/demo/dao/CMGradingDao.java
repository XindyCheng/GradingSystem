package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.CMGrading;

@Mapper
@Repository
public interface CMGradingDao {
	@Select("select * from CM_grading")
	public List<CMGrading> selectAll();
	
	@Select("select * from CM_grading where id=#{id}")
	public CMGrading selectById(int id);
	
	@Delete("delete from CM_grading where id=#{id}")
	public int deleteById(int id);
	
	@Update("update")
	public int update();
	
	@Insert("")
	public int insert();
}
