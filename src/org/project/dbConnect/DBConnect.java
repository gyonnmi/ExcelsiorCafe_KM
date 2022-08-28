package org.project.dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//JDBC 연결 클래스 생성
public class DBConnect {
	
	//static method(정적 메소드) getConnection()
	//객체 생성없이 클래스를 통해 메서드를 직접 호출할 수 있다.
	public static Connection getConnection() throws NamingException, SQLException {
		
		//데이터베이스와 연결하는 객체
		Connection conn=null;
		
		String driver="oracle.jdbc.driver.OracleDriver"; //JDBC Driver Class
		//DB연결을 위한 정보
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system"; 
		String password="1234"; 
		
		try {
			//JDBC 드라이버 로딩
			Class.forName(driver);
			
			System.out.println("Driver Ok");
			//Connection 객체 생성
			conn=DriverManager.getConnection(url, user, password); //데이터베이스 연결
			System.out.println("DB Connect Ok");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver No");
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("DB Connect No");
		}
		
//		DataSource dataSource;
//		Context context=new InitialContext();
//		dataSource=(DataSource)context.lookup("java:comp/env/jdbc/oracleDB");
//		conn=dataSource.getConnection();
		
		return conn;
	}
}
