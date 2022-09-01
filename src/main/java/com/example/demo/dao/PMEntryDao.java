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
	
	@Update("update `PM_entry` set cm_id =#{cm_id} where id=#{pm_id}")
	public int updateCM(int pm_id, int cm_id);
	
	@Update("update `PM_entry` set dm_id =#{dm_id} where id=#{pm_id}")
	public int updateDM(int pm_id, int dm_id);
	
	@Insert("<script>"
			+"insert into `PM_entry`"
			+ "(time,name,contract_number,supplier,client,start,total,state,bg,"
			+ "score,PM_name,department,CM_name,DM_name,comment) "
			+ "values(#{entry.time},#{entry.name},#{entry.contractnumber},#{entry.supplier},"
			+ "#{entry.client},#{entry.start},#{entry.total},#{entry.state},"
			+ "#{entry.bg},#{entry.score},#{entry.pmname},#{entry.department},"
			+ "#{entry.cmname},#{entry.dmname},#{entry.comment})"
			+"</script>")
	@Options(useGeneratedKeys = true,keyProperty = "entry.id")
	public int insert(@Param("entry") PMEntry entry);
}
