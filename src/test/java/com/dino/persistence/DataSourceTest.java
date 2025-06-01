package com.dino.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)  //JUnit �׽�Ʈ �ÿ� �������� �����ϴ� �׽�Ʈ ���ؽ�Ʈ �����ӿ�ũ�� ����ϵ��� ����
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //�ֳ����̼��� �׽�Ʈ�� ����� ������ ���� ������ ��ġ�� ����
@Log4j // �Һ��� �ֳ����̼�. log ������ ����Ͽ� �α׸� ���
public class DataSourceTest {
	
   @Autowired  //���������� �ش� �ʵ带 �ڵ����� ����, ������ �ҽ��� ����
   private DataSource datasource;

   
   @Autowired
   private SqlSessionFactory sqlSessionFactory;
   
   
   // ������ �ҽ��� ����Ͽ� �����ͺ��̽� ������ �õ��ϴ� �޼���
   @Test  // JUnit �����ӿ�ũ�� ���ϴ� �ֳ����̼�, �׽�Ʈ �޼���� �ν�, ������ �ҽ� ������ �׽�Ʈ�ϴ� �޼���
   public void testConnection() {  //testConnection() ������ �ҽ��� ����Ͽ� �����ͺ��̽� ������ �õ��ϴ� �޼���
	   try(Connection con = datasource.getConnection()){ //try-with-resources ������ ����Ͽ� ������ �ҽ��κ��� ������ ��� 
		   log.info(">>>>>2" + con);     //�����ͺ��̽� ������ �����ϸ� �α׿� �޽����� ���
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   @Test
   public void mybatisConnection() {
              // MyBatis SqlSessionFactory�� ����Ͽ� �����ͺ��̽� ������ �õ��ϴ� �޼���
	   try(SqlSession session = sqlSessionFactory.openSession();
			   Connection con= session.getConnection()){
		   log.info("session >>>>> " + session );
		   log.info("con >>>>> " + con );
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
}

// ������ �׽�Ʈ�� ����Ͽ� ������ �ҽ� ������ �׽�Ʈ�ϰ�, �α׸� ���� �׽�Ʈ ����� Ȯ��
