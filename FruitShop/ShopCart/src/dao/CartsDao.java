package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import po.Carts;


public class CartsDao {
	private Connection conn;
	
	public CartsDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
public ArrayList<Carts> allCarts(){
		
		List<Carts> list = new ArrayList();
		
		try {
			PreparedStatement pstat = conn.prepareStatement("select * from carts");
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()){
				Carts cart = new Carts();
				cart.setId(rs.getInt("id"));
				cart.setGid(rs.getInt("gid"));
				cart.setGcount(rs.getInt("gcount"));
				cart.setGsum(rs.getDouble("gsum"));
				list.add(cart);
			}
			return (ArrayList<Carts>) list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

public boolean add(Carts cart){
	try {
		PreparedStatement pstat = conn.prepareStatement("insert into carts values(null,?,?,?)");
		
		pstat.setInt(1,cart.getGid());
		pstat.setInt(2, cart.getGcount());
		pstat.setDouble(3, cart.getGsum());
	
		if(pstat.execute()){
			return true;
		}else{
			return false;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}

}

public boolean delete(Carts cart) {
	try {
		PreparedStatement pstat = conn.prepareStatement("delete from carts where id = ?");
		pstat.setInt(1, cart.getId());
		
		if(pstat.execute()) {
			return true;
		}else {
			return false;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
	
	

}
