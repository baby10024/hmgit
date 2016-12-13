package cn.hm.fruitshop.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import cn.hm.fruitshop.dao.BaseDao;

@SuppressWarnings("unchecked")
@Repository("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	private Class clazz; //clazz中存储了当前操作的类型，即泛型T  
	@Resource
    private SessionFactory sessionFactory;  
    
    public BaseDaoImpl() {
        //下面三个打印信息可以去掉，这里是给自己看的  
        System.out.println("this代表的是当前调用构造方法的对象" + this);  
        System.out.println("获取当前this对象的父类信息" + this.getClass().getSuperclass());  
        System.out.println("获取当前this对象的父类信息(包括泛型信息)" + this.getClass().getGenericSuperclass());  
        //拿到泛型的参数类型  
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();  
        clazz = (Class)type.getActualTypeArguments()[0]; 
    }
    
    
      
    protected Session getSession() {  
        //从当前线程获取session，如果没有则创建一个新的session  
        return sessionFactory.getCurrentSession();  
    }  

	@Override
	public void save(T t) {
		 getSession().save(t);
		
	}

	@Override
	public void update(T t) {
		getSession().update(t);
		
	}

	@Override
	public void delete(int id) {
		System.out.println(clazz.getSimpleName());  
        String hql = "delete " + clazz.getSimpleName() + " as c where c.id=:id";  
        getSession().createQuery(hql) //  
                  .setInteger("id", id) //  
                  .executeUpdate();  
	}

	@Override
	public T get(int id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> query() {
		String hql = "from " + clazz.getSimpleName();  
        return getSession().createQuery(hql).list();  
	}

}
