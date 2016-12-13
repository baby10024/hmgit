package cn.hm.fruitshop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.hm.fruitshop.model.Users;
import cn.hm.fruitshop.service.UserService;
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<Users> implements UserService {

	@Override
	public List<Users> queryJoinLevels(String point,int page, int size) {
		return userDao.queryJoinLevels(point,page,size);
	}

	@Override
	public long getCount(String point) {
		return userDao.getCount(point);
	}

	
}
