package cn.hm.fruitshop.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.hm.fruitshop.dao.UserDao;
import cn.hm.fruitshop.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T> {  
	  
    protected Map<String, Object> request;  
    protected Map<String, Object> session;  
    protected Map<String, Object> application;  
    
    protected T model;
    
  //page��rows�ͷ�ҳ�йأ�pageMap��Ų�ѯ�����ݣ�Ȼ������json��ʽ�õ�
  	//page��rowsʵ��get��set������pageMapֻ��Ҫʵ��get�������ɣ���ΪpageMap���ǽ���ǰ̨�����ģ�����struts��ȡ��
  	protected Integer page;
  	protected Integer rows;
  	protected Map<String, Object> pageMap = null;
  	
    @Resource
    protected UserService userService;
    
      
    @Override  
    public void setApplication(Map<String, Object> application) {  
        this.application = application;  
    }  
  
    @Override  
    public void setSession(Map<String, Object> session) {  
        this.session = session;  
    }  
  
    @Override  
    public void setRequest(Map<String, Object> request) {  
        this.request = request;  
    }  
    
    @Override  
    public T getModel() { //����ͨ��������������T��newһ����Ӧ��instance  
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();  
        Class clazz = (Class)type.getActualTypeArguments()[0];  
        try {  
            model = (T)clazz.newInstance();  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }     
        return model;  
    }

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Map<String, Object> getPageMap() {
		return pageMap;
	}

	public void setPageMap(Map<String, Object> pageMap) {
		this.pageMap = pageMap;
	} 
    
    
}  
