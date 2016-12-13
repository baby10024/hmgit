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
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
/**
 * 
 * @author hou
 *生产厂家表
 *manufacture_no:厂家编号
 *name:厂家名称
 */
@Entity
@Table(name = "manufacturers", catalog = "fruitshop")
public class Manufacturers implements java.io.Serializable{
	
	private Integer manufacture_no;
	private String name;
	private Set<Fruits> fruits = new HashSet<Fruits>();
	
	@Id
	@GeneratedValue
	@Column(name = "Manufacture_no",unique = true,nullable = false)
	public Integer getManufacture_no() {
		return manufacture_no;
	}
	public void setManufacture_no(Integer manufacture_no) {
		manufacture_no = manufacture_no;
	}
	@Column(name = "Name",nullable = false,length = 20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(mappedBy="manus",fetch=FetchType.EAGER)
	@Cascade(value={CascadeType.DELETE})
	public Set<Fruits> getFruits() {
		return fruits;
	}
	public void setFruits(Set<Fruits> fruits) {
		this.fruits = fruits;
	}
	
	

}
