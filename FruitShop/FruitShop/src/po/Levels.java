package po;
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
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * 
 * @author hou
 * �û��ȼ���
 * level:�ȼ�;
 * discount:��Ӧ���ۿ�
 * point_request:��Ӧ�Ļ���Ҫ��
 * 
 * levels:�û��ȼ�����|��һ��
 *
 */
@Entity
@Table(name = "levels", catalog = "fruitshop")
public class Levels implements java.io.Serializable{
	private Integer level;
	private double discount; 
	private String point_request;
	
	//����Ԫ������ΪUsers�Ĺ�����������users
	private Set<Users> users = new HashSet<Users>();
	@Id
	@GeneratedValue
	@Column(name = "Level",unique = true,nullable = false)
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	@Column(name="Discount",precision = 8,scale=0)
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Column(name = "Point_request",nullable = false,length = 20)
	public String getPoint_request() {
		return point_request;
	}
	public void setPoint_request(String point_request) {
		this.point_request = point_request;
	}
	@OneToMany(mappedBy="levels",fetch=FetchType.EAGER)
	@Cascade(value={CascadeType.DELETE})
	public Set<Users> getUsers() {
		return users;
	}
	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	
	
	

}
