package com.sist.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * 	public List<EmpVO> empListData()
 *  { 
 * 		try{
 * 
 * 		}catch(Exception e)
 * 		{
 * 		}
 * 		
 *  }
 *  	자동 호출
 *  	1. 언제
 *  	2. 어느시점에
 */
import com.sist.dao.*;
@Aspect
@Component
public class DBAspect {
   @Autowired
   private DBConnection dbConn;
   
   @Before("execution(* com.sist.dao.EmpDAO.emp*(..))")
   public void before()
   {
	   dbConn.getConnection();
   }
   @After("execution(* com.sist.dao.EmpDAO.emp*(..))")
   public void after()
   {
	   dbConn.disConnection();
   }
   /*
    * 	Around
    * 	======
    * 	 
    * 
    */
   @Around("execution(* com.sist.web.EmpController.*(..))")
   public Object around(ProceedingJoinPoint jp) throws Throwable
   {
	   Object obj=null;
	   System.out.println("사용자 호출전:"+jp.getSignature().getName());
	   obj=jp.proceed();
	   System.out.println("사용자 호출후:"+jp.getSignature().getName());
	   return obj;
   }
   @AfterReturning(value="execution(* com.sist.web.EmpController.*(..))",returning="val")
   public void afterReturning(JoinPoint jp,Object val)
   {
	   System.out.println("리턴값 :"+val);
   }
   
   @AfterThrowing(value="execution(* com.sist.web.EmpController.*(..))",throwing="ex")
   public void afterThrowing(Throwable ex)
   {
	   System.out.println(ex.getMessage());
   }
}

