package po;
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
 *���ﳵ��
 *cart_id:���ﳵ���(primary key)
 *u_id:
 *f_id:ˮ�����(primary key)
 *init_price:��Ʒ����
 *dis_price:��Ʒ�ۺ��
 *count:��Ʒ����
 *is_buy:�Ƿ���
 *total_price:��Ʒ�ܼ�
 */
@Entity
@Table(name = "carts", catalog = "fruitshop")
public class Carts  implements java.io.Serializable{
	
	private Integer cart_id;
	private Integer f_id;
	private double unit_price;
	private double dis_price;
	private int count;
	private boolean is_buy;
	private double total_price;
	
	private Users users;
	
	@Id
	@GeneratedValue
	@Column(name = "Cart_id",unique = false,nullable = false)
	public Integer getCart_id() {
		return cart_id;
	}
	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "F_id",unique = false,nullable = false)
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	@Column(name="Unit_price",precision = 8,scale=0)
	public double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}
	@Column(name="Dis_price",precision = 8,scale=0)
	public double getDis_price() {
		return dis_price;
	}
	public void setDis_price(double dis_price) {
		this.dis_price = dis_price;
	}
	@Column(name="Count",precision = 8,scale=0)
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isIs_buy() {
		return is_buy;
	}
	public void setIs_buy(boolean is_buy) {
		this.is_buy = is_buy;
	}
	@Column(name="Total_price",precision = 8,scale=0)
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
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


