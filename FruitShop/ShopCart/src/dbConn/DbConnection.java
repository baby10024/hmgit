package dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public final class DbConnection {//�ܾ��̳�
	//sql serverʱѡ��
	//private  String url = "jdbc:sqlserver://localhost:1433;DatabaseName=mytest";
	//my sqlѡ��
	private  String url ="jdbc:mysql://localhost:3306/shopcart";
	
	//sql serverʱѡ��
	//private  String user = "sa";
	//my sqlѡ��
	private String user = "root";
	private  String password = "root";
	//�ܾ�newһ��ʵ��
	private DbConnection() {};
	static {//���ø���ʱ��ע������
		try {
			//my sqlѡ��
			 Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//sql serverʱѡ��
	
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	//����ģʽ����ʼ��һ����
	private static DbConnection instance = new DbConnection();
	//��ȡʵ��
	public static DbConnection getInstance() {
		return instance;
	}
	
	//��ȡ����
	public  Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	//�ͷ���Դ
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