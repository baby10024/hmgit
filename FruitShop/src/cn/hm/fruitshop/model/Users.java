package cn.hm.fruitshop.model;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * 
 * @author hou
 * 用户表
 * u_id:用户ID;
 * username:用户昵称 （登录使用）
 * realname:真实姓名（收货地址使用）
 * password:用户密码
 * address:用户收货地址
 * regisDate:注册日期
 * zip:邮编
 * tel:电话
 * sex:性别
 * point:用户积分
 * levels:用户等级（多|对一）
 *
 */
@Entity
@Table(name = "users", catalog = "fruitshop")
public class Users  implements java.io.Serializable{

	private Integer u_id;
	private String username;
	private String realname;
	private String password;
	private String address;
	private String regisDate;
	private String zip;
	private String tel;
	private String sex;
	private String point;
	private Levels levels;
	private Carts carts;
	private Favorites favors;
	private Set<Orders> orders = new HashSet<Orders>();
	
	@Id
	@GeneratedValue
	@Column(name = "U_id",unique = true,nullable = false)
	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	@Column(name = "Username",nullable = false,length = 16)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Realname",nullable = false,length = 16)
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "Password",nullable = false,length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Address",nullable = false,length = 20)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "RegisDate",nullable = true,length = 20)
	public String getRegisDate() {
		return regisDate;
	}

	public void setRegisDate(String regisDate) {
		this.regisDate = regisDate;
	}
	@Column(name = "Zip",nullable = false,length = 20)
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Column(name = "Tel",nullable = false,length = 20)
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(name = "Sex",nullable = false,length = 20)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	@Column(name = "Point",nullable = false,length = 20)
	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}
	//多对一映射 定义Levels类型的关联属性
	@ManyToOne(fetch=FetchType.EAGER)
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@JoinColumn(name="Level")
	public Levels getLevels() {
		return levels;
	}

	public void setLevels(Levels levels) {
		this.levels = levels;
	}
	@OneToOne(mappedBy="users")
	public Carts getCarts() {
		return carts;
	}

	public void setCarts(Carts carts) {
		this.carts = carts;
	}
	@OneToOne(mappedBy="users")
	public Favorites getFavors() {
		return favors;
	}

	public void setFavors(Favorites favors) {
		this.favors = favors;
	}
	@OneToMany(mappedBy="users",fetch=FetchType.EAGER)
	@Cascade(value={CascadeType.DELETE})
	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
	
	
	
	
}
