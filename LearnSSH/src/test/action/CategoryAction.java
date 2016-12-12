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
    
    private Category category;//����һ��˽�г�Ա��������url�������Ĳ�����ע������Ҫд��get��set����  
      
    private CategoryService categoryService;  
      
    public void setCategoryService(CategoryService categoryService) {  
        this.categoryService = categoryService;  
    }  
      
    public String update() {  
        System.out.println("----update----");  
        System.out.println(categoryService);//�����Ѿ���Spring���ϣ����Կ����õ����categoryService�ˣ���ӡ�����Ͳ���null��  
        categoryService.update(category); //�¼�һ����䣬���������ݿ�  
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
