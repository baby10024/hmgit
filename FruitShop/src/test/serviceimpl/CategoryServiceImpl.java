package test.serviceimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import test.Category;
import test.CategoryService;
import utils.HibernateSessionFactory;


  
public class CategoryServiceImpl implements CategoryService {  
  
  
    
    /*Spring和Hibernate整个后*/  
    private SessionFactory sessionFactory; //定义一个sessionFactory  
      
    //当需要使用sessoinFactory的时候，Spring会将sessionFactory注入进来  
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }    
    protected Session getSession() {  
        //从当前线程获取session，如果没有则创建一个新的session  
        return sessionFactory.getCurrentSession();  
    }  
      
    @Override //Spring和Hibernate整合后的情况  
    public void update(Category category) {  
        getSession().update(category);      
    } 
    @Override //Spring和Hibernate整合后的情况  
    public void save(Category category) {  
        getSession().save(category);      
    } 
}  