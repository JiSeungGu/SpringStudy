package com.sist.dao;

import java.util.*;


import org.apache.ibatis.annotations.Select;
public interface MovieMapper {
	@Select("SELECT no,cateno,title,poster,score,regdate,num "
			+"FROM (SELECT no,cateno,title,poster,score,regdate,rownum as num "
			+"FROM (SELECT no,cateno,title,poster,score,regdate "
			+"FROM daum_movie WHERE cateno=#{cateno}))"
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<MovieVO> movieListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM daum_movie WHERE cateno=#{cateno}")
	public int movieTotalData(int cateno);

	//상세보기
	@Select("SELECT * FROM daum_movie WHERE no=#{no}")
	public MovieVO movieDetailDate(int no);
}
