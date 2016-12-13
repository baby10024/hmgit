package test.serviceimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import test.Category;
import test.CategoryService;
import utils.HibernateSessionFactory;


  
public class CategoryServiceImpl implements CategoryService {  
  
  
    
    /*Spring��Hibernate������*/  
    private SessionFactory sessionFactory; //����һ��sessionFactory  
      
    //����Ҫʹ��sessoinFactory��ʱ��Spring�ὫsessionFactoryע�����  
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }    
    protected Session getSession() {  
        //�ӵ�ǰ�̻߳�ȡsession�����û���򴴽�һ���µ�session  
        return sessionFactory.getCurrentSession();  
    }  
      
    @Override //Spring��Hibernate���Ϻ�����  
    public void update(Category category) {  
        getSession().update(category);      
    } 
    @Override //Spring��Hibernate���Ϻ�����  
    public void save(Category category) {  
        getSession().save(category);      
    } 
}  