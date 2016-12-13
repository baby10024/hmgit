package cn.hm.fruitshop.dao;

import java.util.List;

import cn.hm.fruitshop.model.Users;

public interface UserDao extends BaseDao<Users> {
	   
	    public List<Users> queryJoinLevels(String point,int page, int size) ;
	  //根据关键字查询总记录数
		public Long getCount(String point);
	
}
