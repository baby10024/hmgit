package test.action;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import test.Category;
import test.CategoryService;

import com.opensymphony.xwork2.ActionSupport;
public class CategoryAction extends ActionSupport {  
    
    private Category category;//设置一个私有成员变量接收url带过来的参数，注意下面要写好get和set方法  
      
    private CategoryService categoryService;  
      
    public void setCategoryService(CategoryService categoryService) {  
        this.categoryService = categoryService;  
    }  
      
    public String update() {  
        System.out.println("----update----");  
        System.out.println(categoryService);//由于已经和Spring整合，所以可以拿到这个categoryService了，打印出来就不是null了  
        categoryService.update(category); //新加一条语句，来更新数据库  
        return "index";  
    }  
      
    public String save() {  
        System.out.println("----save----");  
        System.out.println(categoryService);  
        return "index";  
    }  
  
    public Category getCategory() {  
        return category;  
    }  
  
    public void setCategory(Category category) {  
        this.category = category;  
    }  
}
