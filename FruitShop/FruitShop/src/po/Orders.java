package po;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
/**
 * 
 * @author hou
 * 订单总表
 * order_id:订单ID;
 * total_price:订单总价
 * order_date:订单日期
 * invoice_no:发票编号
 * order_status:订单状态
 * deliv_date:配送日期
 * users:用户id
 
 *
 */
@Entity
@Table(name = "orders", catalog = "fruitshop")
public class Orders implements java.io.Serializable{
	
	private Integer order_id;
	private double total_price;
	private String order_date;
	private String invoice_no; 
	private String order_status ;
	private String deliv_date;
	private Users users;
	
	@Id
	@GeneratedValue
	@Column(name = "Order_id",unique = true,nullable = false)
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	@Column(name="Total_price",precision = 8,scale=0)
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	@Column(name = "Order_date",nullable = false,length = 16)
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	@Column(name = "Invoice_no",nullable = false,length = 16)
	public String getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}
	@Column(name = "Order_status",nullable = false,length = 16)
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	@Column(name = "Deliv_date",nullable = false,length = 16)
	public String getDeliv_date() {
		return deliv_date;
	}
	public void setDeliv_date(String deliv_date) {
		this.deliv_date = deliv_date;
	}
	//多对一映射 定义Users类型的关联属性
		@ManyToOne(fetch=FetchType.EAGER)
		@Cascade(value={CascadeType.SAVE_UPDATE})
		@JoinColumn(name="U_id")
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	
}
