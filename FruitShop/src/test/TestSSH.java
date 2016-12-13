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
 *@Description TODO(采用Spring的注解调试，仅仅支持Spring3.1及以上) 
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="classpath:beans.xml")  
public class TestSSH {
	@Resource  
    private Date date;  
      
	@Resource  
    private CategoryService categoryService; 
	
    @Test //测试Spring IOC的开发环境  
    public void springIoc() {  
        System.out.println(date);  
    }  

    @Test  //测试Hibernate的开发环境，因为没有整合，可以直接new  
    public void hihernate() {  
        CategoryService categoryService = new CategoryServiceImpl();  
        Category category = new Category();  
        category.setType("休闲男士 ");
        categoryService.save(category);  
    }
    
    @Test //测试Hibernate和Spring整合后  
    public void hibernateAndSpring() { 
        Category category = new Category();  
        category.setType("休闲女式");
        categoryService.save(category); //categoryService通过Spring从上面注入进来的  
    }  
}
