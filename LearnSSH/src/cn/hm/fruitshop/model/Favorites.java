package cn.hm.fruitshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * 
 * @author hou
 * 用户收藏表
 * favor_id:用户收藏ID;
 * f_id:商品id
 * f_name:商品名称
 * simg:商品小图
 * users:用户id外键
 * 
 */
@Entity
@Table(name = "favorites", catalog = "fruitshop")
public class Favorites  implements java.io.Serializable {
	
	private Integer favor_id;
	private Integer f_id;
	private String f_name;
	private String simg;
	private Users users;
	
	@Id
	@GeneratedValue
	@Column(name = "Favor_id",nullable = false)
	public Integer getFavor_id() {
		return favor_id;
	}
	public void setFavor_id(Integer favor_id) {
		this.favor_id = favor_id;
	}
	@Id
	@GeneratedValue
	@Column(name = "F_id",nullable = false)
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	@Column(name = "F_name",nullable = false,length = 20)
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	@Column(name = "Simg",nullable = false,length = 20)
	public String getSimg() {
		return simg;
	}
	public void setSimg(String simg) {
		this.simg = simg;
	}
	@OneToOne
    @JoinColumn(name = "U_id")
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	

}
