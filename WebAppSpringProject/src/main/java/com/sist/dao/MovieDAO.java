package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// 메모리 할당
@Repository
public class MovieDAO {
	// 구현된 클래스 
	@Autowired
	public MovieMapper mapper;
	
	public List<MovieVO> movieListData(Map map)
	{
		return mapper.movieListData(map);
	}
	
	public int movieTotalData(int cateno)
	{
		return mapper.movieTotalData(cateno);
	}

	//상세보기
	public MovieVO movieDetailDate(int no)
	{
		return mapper.movieDetailDate(no);
	}
}
