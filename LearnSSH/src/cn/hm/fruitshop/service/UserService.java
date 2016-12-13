package cn.hm.fruitshop.service;

import java.util.List;

import cn.hm.fruitshop.model.Users;

public interface UserService extends BaseService<Users> {
	
	 public List<Users> queryJoinLevels(String type,int page, int size);
	 
	 public long getCount(String point);

}
