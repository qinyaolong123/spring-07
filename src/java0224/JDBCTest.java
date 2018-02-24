package java0224;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//url��ʽ��jdbc:mysql://����IP:�˿ں�/���ݿ���
		String url="jdbc:mysql://192.168.198.166:3306/NewDatebase";
		String user="root";
		String password="qyl123456";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//ѡ�����ݿ����࣬��������-----�����䣩
			Class.forName("com.mysql.jdbc.Driver");
			
			//�������� ����IP �˿ں� �û��� ����   //ѡ��Ҫ���������ݿ�
			 con = DriverManager.getConnection(url, user, password);
				
		    //��������ڣ�дsql��䣩
			 pstmt = con.prepareStatement("select * from students");
			 
			//����sql��� ���õ������
			 rs = pstmt.executeQuery();
			//��ʾ�����
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
