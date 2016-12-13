package po;
import java.util.Set;

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
 *��Ʒˮ����
 *f_id:ˮ��ID
 *name:ˮ������
 *storage:�����
 *made_date:��������
 *keep_date:������
 *price:�۸�
 *simg:����ͼ��ַ
 *bimg:��ͼ��ַ
 *description:��Ʒ����
 *kinds:����
 *mamus:��������
 */
@Entity
@Table(name = "fruits", catalog = "fruitshop")
public class Fruits implements java.io.Serializable{
	
	private Integer f_id;
	private String name;
	private int storage;
	private String made_date;
	private String keep_date;
	private double price;
	private String simg;
	private String bimg;
	private String description;
	private Kinds kinds;
	private Manufacturers manus ;
	
	@Id
	@GeneratedValue
	@Column(name = "F_id",unique = true,nullable = false)
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	@Column(name = "Name",nullable = false,length = 16)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "Storage",nullable = false,length = 16)
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	@Column(name = "Made_date",nullable = false,length = 16)
	public String getMade_date() {
		return made_date;
	}
	public void setMade_date(String made_date) {
		this.made_date = made_date;
	}
	@Column(name = "Keep_date",nullable = false,length = 16)
	public String getKeep_date() {
		return keep_date;
	}
	public void setKeep_date(String keep_date) {
		this.keep_date = keep_date;
	}
	@Column(name="Price",precision = 8,scale=0)
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Column(name = "Simg",nullable = true,length = 50)
	public String getSimg() {
		return simg;
	}
	public void setSimg(String simg) {
		this.simg = simg;
	}
	@Column(name = "Bimg",nullable = true,length = 100)
	public String getBimg() {
		return bimg;
	}
	public void setBimg(String bimg) {
		this.bimg = bimg;
	}
	@Column(name = "Description",nullable = false,length = 100)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	//���һӳ�� ����Kinds���͵Ĺ�������
	@ManyToOne(fetch=FetchType.EAGER)
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@JoinColumn(name="Kind")
	public Kinds getKinds() {
		return kinds;
	}
	
	public void setKinds(Kinds kinds) {
		this.kinds = kinds;
	}
	//���һӳ�� ����Manus���͵Ĺ�������
			@ManyToOne(fetch=FetchType.EAGER)
			@Cascade(value={CascadeType.SAVE_UPDATE})
			@JoinColumn(name="Manu")
	public Manufacturers getManus() {
		return manus;
	}
	
	public void setManus(Manufacturers manus) {
		this.manus = manus;
	}
	
	
	
	
	
	
	

}
