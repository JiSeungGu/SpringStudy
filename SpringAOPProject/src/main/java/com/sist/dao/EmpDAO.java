package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

@Repository
public class EmpDAO {
	
	@Autowired
	private MyDataSource ds;
	private Connection conn;
	private PreparedStatement ps;
	public EmpDAO()
	{
		try{
			Class.forName(ds.getDriverClassName());
		}catch (Exception e) {
			
		}
	}
	//////////////////////////  반복 구간
	public void getConnection()
	{
		try{
			conn=DriverManager.getConnection(ds.getUrl(),ds.getUsername(),ds.getPassword());
		}catch (Exception e) {}
	}
	public void disConnection()
	{
		try{
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		}catch (Exception e) {}
	}
	////////////////////////// AOP => 반복 제거 프로그램 
	/*
	 *  스프링
	 *  	=공통 모듈 => 공통 관심사 => 스프링에서 담당 (AOP) Callback 함수 (시스템에 의해 자동 호출)
	 *  	=핵심 모듈 => 핵심 관심사 => 프로그래머가 코딩  
	 *  	=반복을 제거하는 프로그램 AOP(트랜잭션,로그파일,보안)
	 * 
	 */
	public List<EmpVO> empListData()
	{
		List<EmpVO> list = new ArrayList<EmpVO>();
		// @Before
		try{
			// @Around => 실행 전  => setAutoCommit(false)
			// 핵심 코딩 (DML)
			// 실행 후 -> commit
			getConnection();
			String sql="SELECT empno,ename,job,hiredate,sal, "
					+ "(SELECT dname FROM dept d WHERE d.deptno=e.deptno) as dname, "
					+ "(SELECT loc FROM dept d where d.deptno=e.deptno) as loc "
					+ "FROM emp e";
		ps=conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			EmpVO vo = new EmpVO();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getInt(5));
			vo.setDname(rs.getString(6));
			vo.setLoc(rs.getString(7));
			list.add(vo);
		}
		}catch (Exception e) {
			// @After-Throwing -> rollback
		}finally {
			// @After -> setAutoCommit(true)
			disConnection();
		}
		
		return list; //@After-Returning
	}
	//상세보기
	public EmpVO empDetailData(int empno)
	{
		EmpVO vo = new EmpVO();
		try{
			getConnection();
			String sql="SELECT empno,ename,job,hiredate,sal, "
					+ "(SELECT dname FROM dept d WHERE d.deptno=e.deptno) as dname, "
					+ "(SELECT loc FROM dept d where d.deptno=e.deptno) as loc "
					+ "FROM emp e "
					+ "WHERE empno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, empno);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getInt(5));
			vo.setDname(rs.getString(6));
			vo.setLoc(rs.getString(7));
			rs.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			disConnection();
		}
		return vo;
	}
}
