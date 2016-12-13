package cn.hm.fruitshop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import cn.hm.fruitshop.dao.UserDao;
import cn.hm.fruitshop.model.Users;
@SuppressWarnings("unchecked")
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<Users> implements UserDao {

	 @Override  
	    public List<Users> queryJoinLevels(String point,int page, int size) {  
	        String hql = "from Users c left join fetch c.levels where c.point like :point";  
	        return getSession().createQuery(hql)  
	                .setString("point", "%" + point + "%")
	                .setFirstResult((page-1) * size) //从第几个开始显示  
	                .setMaxResults(size) //显示几个  
	                .list(); 
	    }

	@Override
	public Long getCount(String point) {
		String hql = "select count(c) from Users c where c.point like :point";
		return (Long) getSession().createQuery(hql)
			.setString("point", "%" + point + "%")
			.uniqueResult(); //返回一条记录:总记录数
	}  
}
