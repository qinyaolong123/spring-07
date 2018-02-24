package java0224;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//url格式：jdbc:mysql://主机IP:端口号/数据库名
		String url="jdbc:mysql://192.168.198.166:3306/NewDatebase";
		String user="root";
		String password="qyl123456";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//选择数据库种类，加载驱动-----（反射）
			Class.forName("com.mysql.jdbc.Driver");
			
			//建立连接 主机IP 端口号 用户名 密码   //选择要操作的数据库
			 con = DriverManager.getConnection(url, user, password);
				
		    //创建命令窗口（写sql语句）
			 pstmt = con.prepareStatement("select * from students");
			 
			//运行sql语句 ，得到结果集
			 rs = pstmt.executeQuery();
			//显示结果集
			while(rs.next()) {
				System.out.println(rs.getInt("id")+"  "+rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					while(rs!=null)
					rs.close();
					while(pstmt!=null)
					pstmt.close();
					while(con!=null)
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
