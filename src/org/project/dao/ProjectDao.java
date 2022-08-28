package org.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.project.dbConnect.DBConnect;
import org.project.dto.MemberDto;

//DataBase Access Object
public class ProjectDao {
	
	//싱글톤
	//클래스가 최초 한번만 메모리를 할당하고(Static) 그 메모리에 객체를 만들어 사용하는 디자인 패턴
			
	//생성자를 외부에서 호출할 수 없도록  private 접근제한자
	private static class singleton {
		//정적 필드 static final => 한 번 초기값이 저장되면 변경 불가
		private static final ProjectDao INSTANCE=new ProjectDao();
	}
	
	//생성자
	private ProjectDao() {}
	
	//외부 호출이 가능(public) 정적(static) 메소드
	public static ProjectDao getInstance() {
		return singleton.INSTANCE;
	}
	
	
	//CRUD
	//회원가입
	public int  insertDo(String userId, String userPw, String userName, 
			String userBirthday, String userPhone) {
		int rs=0;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		String query="";
		
		try {
			conn=DBConnect.getConnection();
			query="insert into pj_member values (?,?,?,?,?)";
			pstm=conn.prepareStatement(query);
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			pstm.setString(3, userName);
			pstm.setString(4, userBirthday);
			pstm.setString(5, userPhone);
			rs=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {}
		}
		return rs;
	}
	
	
	//로그인
	public int loginDo(String userId, String userPw) {
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String query="";
		
		try {
			conn=DBConnect.getConnection();
			query="select userPw from pj_member where userId=?";
			pstm=conn.prepareStatement(query);
			pstm.setString(1, userId);

			rs=pstm.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(userPw)){
					return 1; //로그인 성공
				} else {
					return 0; //비밀번호 불일치
				}
			}
			return -1; //아이디가 없음
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
				if(rs!=null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {}
		}
		return -2; //데이터베이스 오류
	}
	
	
	//회원상세조회
	public MemberDto memberViewDo(String userId) {
		MemberDto member=null;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String query="";
		
		try {
			conn=DBConnect.getConnection();
			query="select * from pj_member where userId=?";
			pstm=conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			
			rs=pstm.executeQuery();
			
			if(rs.next()) {
				member=new MemberDto(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {}
		}
		return member;
	}
	
	
	//회원정보수정
	public int updateDo(String userId, String userPw, String userName, 
			String userBirthday, String userPhone) {
		int rs=0;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		String query="";
		
		try {
			conn=DBConnect.getConnection();
			query="update pj_member set userPw=?, userName=?, "
					+ "userBirthday=?, userPhone=? where userId=?";
			pstm=conn.prepareStatement(query);
			
			pstm.setString(1, userPw);
			pstm.setString(2, userName);
			pstm.setString(3, userBirthday);
			pstm.setString(4, userPhone);
			pstm.setString(5, userId);

			rs=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {}
		}
		return rs;
	}
	
	
	//회원탈퇴
	public boolean deleteDo(String userId, String userPw) {
		boolean result = false;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String dbUserPw="";
		try {
			conn=DBConnect.getConnection();
			String sql="select userPw from pj_member where userId=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, userId);
			rs=pstm.executeQuery();
			if(rs.next()) {
				dbUserPw=rs.getString("userPw");
				if(dbUserPw.equals(userPw)) {
					String delSql="delete from pj_member where userId=?";
					pstm=conn.prepareStatement(delSql);
					pstm.setString(1, userId);
					pstm.executeUpdate();
					result=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
				if(rs!=null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {}
		}
		return result;
	}
	
	
	//DB에 저장되어있는 Pw Get
	public String dbPassword(String userId) {
		String dbPassword="";
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String query="";
		
		try {
			conn=DBConnect.getConnection();
			query="select userPw from pj_member where userId=?";
			pstm=conn.prepareStatement(query);
			pstm.setString(1, userId);
			rs=pstm.executeQuery();
			if(rs.next()) {
				dbPassword=rs.getString("userPw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
				if(rs!=null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dbPassword;
	}
	
	
	//Ajax 아이디체크
	public int idChecked(String userId) {
		int result=0;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String query="";
		
		try {
			conn=DBConnect.getConnection();
			query="select count(*) from pj_member where userId=?"; 
			//아이디가 있으면 1, 없으면 0
			pstm=conn.prepareStatement(query);
			pstm.setString(1, userId);
			rs=pstm.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
				if(rs!=null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {}
		}
		return result;
	}
	
	
	
	
	
	
	
	

}
