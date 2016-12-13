package dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.*;

import dao.ICommonDao;

public class SpringCommonDao<T>  implements ICommonDao<T>{

	protected Class<T> entity;
	
	@SuppressWarnings("unchecked")
	public SpringCommonDao(){
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.entity = (Class<T>) pt.getActualTypeArguments()[0];
	
	}
	
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory =  sessionFactory;
	}
	@Override
	public void save(T t) {
//		Transaction tx = null;
//		Session session = sessionFactory.getCurrentSession();
//		
//		try{
//			tx = session.beginTransaction();
//			session.save(t);
//			
//			tx.commit();
//		}catch (Exception e) {
//			if(tx !=null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}
		
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
		
		
	}

	@Override
	public void delete(T t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
		
	}
	

	@Override
	public T queryById(Integer id) {
		try{
			Session session = sessionFactory.getCurrentSession();
			String hql="Select *  from "+entity.getName()+" where id = "+id;
			Query query = session.createQuery(hql);
			query.getClass();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryAll() {
		return null;
		}

	@Override
	public void update(T t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryByPage(int start, int max) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(entity);
		c.setFirstResult(start);
		c.setMaxResults(max);
		return c.list();
		}
	
	

	@Override
	public List<T> queryByCondition(int start, int max, String... values) {
		return null;
	}
	@Override
	public int totalRows() {
		int count = 0;
		try{
		Session session = sessionFactory.getCurrentSession();
		String hql="Select * count(s) from "+entity.getName()+" s";
		Query query = session.createQuery(hql);
		count = Integer.parseInt(query.uniqueResult().toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	

}
