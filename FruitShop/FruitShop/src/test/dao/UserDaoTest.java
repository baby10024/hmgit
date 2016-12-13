package test.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Users;

import dao.impl.UserDao;
public class UserDaoTest {
	
	UserDao userDao ;
	
	@Test
	public void testSave() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		userDao=(UserDao)ac.getBean("userDao");
		
		Users u = new Users();
		u.setUsername("alice");
		u.setRealname("buyer");
		u.setPassword("123456");
		u.setAddress("walman,st10#");
		u.setZip("010000");
		u.setTel("18647374747");
		u.setSex("m");
		u.setPoint("0");
		//System.out.println(u.getUsername());
		userDao.save(u);
	}

}
