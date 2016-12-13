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
 * 商品种类表
 *kind_no:商品种类编号
 *kind_name:商品种类名称
 *
 */
@Entity
@Table(name = "kinds", catalog = "fruitshop")
public class Kinds implements java.io.Serializable{
	
	private Integer kind_no;
	private String kind_name;
	//定义元素类型为Fruits的关联集合属性fruits
	private Set<Fruits> fruits = new HashSet<Fruits>();
	@Id
	@GeneratedValue
	@Column(name = "Kind_no",unique = true,nullable = false)
	public Integer getKind_no() {
		return kind_no;
	}
	public void setKind_no(Integer kind_no) {
		this.kind_no = kind_no;
	}
	@Column(name = "Kind_name",nullable = false,length=16)
	public String getKind_name() {
		return kind_name;
	}
	public void setKind_name(String kind_name) {
		this.kind_name = kind_name;
	}
	@OneToMany(mappedBy="kinds",fetch=FetchType.EAGER)
	@Cascade(value={CascadeType.DELETE})
	public Set<Fruits> getFruits() {
		return fruits;
	}
	public void setFruits(Set<Fruits> fruits) {
		this.fruits = fruits;
	}
	
	

}
