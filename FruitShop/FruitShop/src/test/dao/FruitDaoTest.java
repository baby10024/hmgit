package test.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Fruits;
import po.Users;

import dao.impl.FruitDao;
import dao.impl.UserDao;
public class FruitDaoTest {
	
	
	//org.springframework.context.support.ClassPathXmlApplicationContext
	@Test
	public void testSave() {
		//ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		FruitDao fdao = new FruitDao();
		
		Fruits f = new Fruits();
		f.setName("apple");
		f.setKeep_date("2018-2-1");
		f.setMade_date("20184930");
		f.setDescription("goodgood");
		//System.out.println(u.getUsername());
		fdao.save(f);
	}

}
