package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import po.Goods;

public class GoodsDao {
	private Connection conn;
	
	public GoodsDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
public ArrayList<Goods> allGoods(){
		
		List<Goods> list = new ArrayList();
		
		try {
			PreparedStatement pstat = conn.prepareStatement("select * from goods");
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()){
				Goods good = new Goods();
				good.setId(rs.getInt("id"));
				good.setName(rs.getString("name"));
				good.setDesc(rs.getString("desc"));
				good.setLocation(rs.getString("location"));
				good.setPrice(rs.getDouble("price"));
				list.add(good);
			}
			return (ArrayList<Goods>) list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

public Goods queryOne(Goods good) {
	try {
		PreparedStatement pstat = conn.prepareStatement("select * from goods where id=?");
		pstat.setInt(1, good.getId());
		if(pstat.execute()) {
			return good;
		}else {
			return null;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
	
	

}
