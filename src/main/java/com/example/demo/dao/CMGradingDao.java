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
import com.example.demo.entity.CMGrading;

@Mapper
@Repository
public interface CMGradingDao {
	@Select("select * from CM_grading")
	public List<CMGrading> selectAll();
	
	@Select("select * from CM_grading where id=#{id}")
	public CMGrading selectById(int id);
	
	@Insert("<script>"
			+ "insert into `CM_grading`"
			+ "(time,CM_name,unit,credibility,customer_relat,project_support,personnel_quality,comment,total) "
			+ "values (#{grading.time},#{grading.cmname},#{grading.unit},#{grading.credibility},"
			+ "#{grading.customerrelat},#{grading.projectsupport},#{grading.personnelquality},"
			+ "#{grading.comment},#{grading.total})"
			+ "</script>")
	@Options(useGeneratedKeys = true,keyProperty = "grading.id")
	public int insert(@Param("grading") CMGrading grading);
	
	@Delete("delete from CM_grading where id=#{id}")
	public int deleteById(int id);
	
	@Update("update")
	public int update();
	
}
