package cn.hm.fruitshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import cn.hm.fruitshop.dao.UserDao;
import cn.hm.fruitshop.model.Users;
@SuppressWarnings("unchecked")
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<Users> implements UserDao {

}
