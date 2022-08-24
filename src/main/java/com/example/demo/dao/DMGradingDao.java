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

import com.example.demo.entity.DMGrading;

@Mapper
@Repository
public interface DMGradingDao {
	@Select("select * from CM_grading")
	public List<DMGrading> selectAll();
	
	@Select("select * from CM_grading where id=#{id}")
	public DMGrading selectById(int id);
	
	@Insert("<script>"
			+"insert into `DM_grading`"
			+ "(time,DM_name,unit,constructability,technique,res_tl,compl_tl,"
			+ "deliver_quality,customer_satisfaction,comment,total) "
			+ "values(#{grading.time},#{grading.dmname},#{grading.unit},"
			+ "#{grading.constructability},#{grading.technique},#{grading.res_tl},"
			+ "#{grading.compl_tl},#{grading.deliver_quality},#{grading.customer_satisfaction},"
			+ "#{grading.comment},#{grading.total})"
			+ "</script>")
	@Options(useGeneratedKeys = true,keyProperty = "grading.id")
	public int insert(@Param("grading") DMGrading grading);
	
	@Delete("")
	public DMGrading deleteById(int id);
	
	@Update("")
	public int update();
	
}
