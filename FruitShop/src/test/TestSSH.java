package test;

import java.util.Date;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.serviceimpl.CategoryServiceImpl;

/**
 * 
 * @author hou
 *@Description TODO(����Spring��ע����ԣ�����֧��Spring3.1������) 
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="classpath:beans.xml")  
public class TestSSH {
	@Resource  
    private Date date;  
      
	@Resource  
    private CategoryService categoryService; 
	
    @Test //����Spring IOC�Ŀ�������  
    public void springIoc() {  
        System.out.println(date);  
    }  

    @Test  //����Hibernate�Ŀ�����������Ϊû�����ϣ�����ֱ��new  
    public void hihernate() {  
        CategoryService categoryService = new CategoryServiceImpl();  
        Category category = new Category();  
        category.setType("������ʿ ");
        categoryService.save(category);  
    }
    
    @Test //����Hibernate��Spring���Ϻ�  
    public void hibernateAndSpring() { 
        Category category = new Category();  
        category.setType("����Ůʽ");
        categoryService.save(category); //categoryServiceͨ��Spring������ע�������  
    }  
}
