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
		System.out.println("page��" + page);
		System.out.println("rows��" + rows);
		
		//�����洢��ҳ������
		pageMap = new HashMap<String, Object>();
		
		//���ݹؼ��ֺͷ�ҳ�Ĳ�����ѯ��Ӧ������
		List<Users> userList = userService.queryJoinLevels(model.getPoint(), page, rows);
		pageMap.put("rows", userList); //�洢ΪJSON��ʽ
		//���ݹؼ��ֲ�ѯ�ܼ�¼��
		Long total = userService.getCount(model.getPoint());
//		System.out.println(total);
		pageMap.put("total", total); //�洢ΪJSON��ʽ

		return "jsonMap";
	}

}
