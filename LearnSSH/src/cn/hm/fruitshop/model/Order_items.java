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
 * 订单详情表
 * order_id:订单ID;
 * f_id:商品ID
 * unit_price:单价
 * dis_price:折后价
 * count:数量
 * order_date:订单日期

 *
 */

@Entity
@Table(name = "order_items", catalog = "fruitshop")
public class Order_items implements java.io.Serializable{
	
	private Integer order_id;
	private Integer f_id;
	private double unit_price;
	private double dis_price;
	private int count;
	private String order_date;
	
	

}
