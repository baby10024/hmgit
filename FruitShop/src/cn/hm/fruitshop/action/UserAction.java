package cn.hm.fruitshop.action;

import java.util.HashMap;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.hm.fruitshop.dao.UserDao;
import cn.hm.fruitshop.model.Users;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<Users> {
	    
    public String queryJoinAccount() {
		System.out.println("point:" + model.getPoint());
		System.out.println("page：" + page);
		System.out.println("rows：" + rows);
		
		//用来存储分页的数据
		pageMap = new HashMap<String, Object>();
		
		//根据关键字和分页的参数查询相应的数据
		List<Users> userList = userService.queryJoinLevels(model.getPoint(), page, rows);
		pageMap.put("rows", userList); //存储为JSON格式
		//根据关键字查询总记录数
		Long total = userService.getCount(model.getPoint());
//		System.out.println(total);
		pageMap.put("total", total); //存储为JSON格式

		return "jsonMap";
	}

}
