package dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public final class DbConnection {//拒绝继承
	//sql server时选用
	//private  String url = "jdbc:sqlserver://localhost:1433;DatabaseName=mytest";
	//my sql选用
	private  String url ="jdbc:mysql://localhost:3306/shopcart";
	
	//sql server时选用
	//private  String user = "sa";
	//my sql选用
	private String user = "root";
	private  String password = "root";
	//拒绝new一个实例
	private DbConnection() {};
	static {//调用该类时既注册驱动
		try {
			//my sql选用
			 Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//sql server时选用
	
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	//单例模式：初始化一个域
	private static DbConnection instance = new DbConnection();
	//获取实例
	public static DbConnection getInstance() {
		return instance;
	}
	
	//获取连接
	public  Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	//释放资源
	public  void free(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						if (conn != null) {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}