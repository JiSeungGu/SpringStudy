package com.sist.dao;
/*
 * SubQuery : SQL������ �ϳ� ��� ��� => JOIN , ������ ���� ������ �ִ� ���, SQL������ ���� ���� 
 * 	= ����
 * 		================
 * 		1. ������ ��������
 * 		2. ������ ��������
 * 		================ ���ǹ� ��� (WHERE ~)
 * 		3. ��Į�� ��������
 * 		================ Į�� ��ü
 * 		4. �ζ��� �� (TOP-N)
 * 		================ ���̺� ��ü
 * 	= ����
 * 		1.���������� ���� ==> ����� ���� ���� ����
 * 			��) SELECT ~~
 * 				FROM table_name
 * 				WHERE �÷��� ������ (SELECT ==) => ���������� ���� ���� => �ݵ��() 
 * 								===========
 * 								��� 1
 * 								��� ������ ( IN, ANY, ALL)
 * 								>ANY => �ּҰ� ALL(SELECT deptno FROM dept)
 * 											 ANY(10,20,30,40) => 10
 * 								<ANY => �ִ밪
 * 											 ANY(10,20,30,40) => 40
 * 								>ALL => �ִ밪
 * 											 ANY(10,20,30,40) => 40
 * 								<ALL => �ּҰ�
 * 											 ANY(10,20,30,40) => 10
 * 								====================================
 * 								SELECT MIN(deptno) FROM dept
 * 								SELECT MAX(deptno) FROM dept
 * 								IN(10,20,30,40)
 */

import java.util.*;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;
@Controller
public interface EmpMapper {
	@Select("SELECT empno,ename,job,hiredate,sal,deptno, "
			+"(SELECT dname FROM dept d WHERE e.deptno=d.deptno) as dname, "
			+"(SELECT loc FROM dept d WHERE e.deptno=d.deptno) as loc "
			+"FROM emp e")
	public List<EmpVO>empListData();
	@Select("SELECT empno,ename,job,hiredate,sal,deptno,"
			+"(SELECT dname FROM dept d WHERE e.deptno=d.deptno) as dname, "
			+"(SELECT loc FROM dept d WHERE e.deptno=d.deptno) as loc "
			+"FROM emp e "
			+"WHERE deptno=(SELECT deptno FROM emp WHERE ename=#{ename})")
	public List<EmpVO> empGroupData(String ename);
	
}
