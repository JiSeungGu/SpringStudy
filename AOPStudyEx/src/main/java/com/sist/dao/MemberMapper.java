package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface MemberMapper {
	@Select("SELECT COUNT(*) FROM member "
			+ "WHERE id=#{id}")
	public int idCheck(String id);
	
	@Select("SELECT pwd FROM member "
			+"WHERE id=#{id}")
	public String memberGetPassword(String id);
	
	
	
}
