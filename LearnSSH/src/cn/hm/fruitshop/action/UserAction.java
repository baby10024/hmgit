package cn.hm.fruitshop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.hm.fruitshop.dao.UserDao;
import cn.hm.fruitshop.model.Users;
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<Users> {
	
	public String update() {  
        System.out.println("----update----");  
        userService.update(model);//直接使用model  
        return "index";  
    }  
      
    public String save() {  
        System.out.println("----save----");  
        System.out.println(model); //直接使用model  
        return "index";  
    }  
      
    public String query() {   
        request.put("userList", userService.query());   
        session.put("userList", userService.query());   
        application.put("userList", userService.query());   
        return "index";  
    }  

}
