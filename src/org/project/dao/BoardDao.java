package org.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import org.project.dbConnect.DBConnect;
import org.project.dto.MemberDto;
import org.project.dto.NoticeDto;

//DataBase Access Object
public class BoardDao {

	//싱글톤
		//클래스가 최초 한번만 메모리를 할당하고(Static) 그 메모리에 객체를 만들어 사용하는 디자인 패턴
				
		//생성자를 외부에서 호출할 수 없도록  private 접근제한자
		private static class singleton {
			//정적 필드 static final => 한 번 초기값이 저장되면 변경 불가
			private static final BoardDao INSTANCE=new BoardDao();
		}
		
		//생성자
		private BoardDao() {}
		
		//외부 호출이 가능(public) 정적(static) 메소드
		public static BoardDao getInstance() {
			return singleton.INSTANCE;
		}
		
		
		//오늘날짜시간 Get
		public String getDate() {
			String todayTime="";
			
			Connection conn=null;
			PreparedStatement pstm=null;
			ResultSet rs=null;
			String query="";
			
			try {
				conn=DBConnect.getConnection();
				query="select to_char(sysdate,'YYYY-MM-DD') from dual";
//				query="select to_char(sysdate,'RRRR-MM-DD HH24:MI:SS') from dual";
				pstm=conn.prepareStatement(query);
				rs=pstm.executeQuery();
				if(rs.next()) {
					todayTime=rs.getString(1);
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
			return todayTime;
		}
		
		
		//게시글번호 마지막번호+1
		public int maxNo() {
			int maxNo=0;
			
			Connection conn=null;
			PreparedStatement pstm=null;
			ResultSet rs=null;
			String query="";
			
			try {
				conn=DBConnect.getConnection();
				query="select max(notice_no)+1 from pj_notice";
				pstm=conn.prepareStatement(query);
				rs=pstm.executeQuery();
				if(rs.next()) {
					maxNo=rs.getInt(1);
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
			return maxNo;
		}
		
		
		//공지사항 작성 noticeWrite
		public int noticeWrite(int notice_no, String notice_title, 
				String notice_content, String notice_date, int hit) {
			int rs=0;
			
			Connection conn=null;
			PreparedStatement pstm=null;
			String query="";
			
			try {
				conn=DBConnect.getConnection();
				query="insert into pj_notice values (?,?,?,?,?)";
				pstm=conn.prepareStatement(query);
				pstm.setInt(1, notice_no);
				pstm.setString(2, notice_title);
				pstm.setString(3, notice_content);
				pstm.setString(4, notice_date);
				pstm.setInt(5, hit);
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
		
		
		//공지사항 
		public ArrayList<NoticeDto> notice() {
			ArrayList<NoticeDto> notices=new ArrayList<NoticeDto>();
			
			Connection conn=null;
			PreparedStatement pstm=null;
			ResultSet rs=null;
			String query="";
			
			try {
				conn=DBConnect.getConnection();
				query="select * from pj_notice order by notice_no desc";
				pstm=conn.prepareStatement(query);
				rs=pstm.executeQuery();
				while(rs.next()) {
					notices.add(new NoticeDto(rs.getInt(1), rs.getString(2), 
							rs.getString(3), rs.getString(4), rs.getInt(5)));
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
			return notices;
		}
		
		
		//게시글 상세 조회
		public NoticeDto NoticeView(int notice_no) {
			NoticeDto noti=null;
			
			Connection conn=null;
			PreparedStatement pstm=null;
			ResultSet rs=null;
			String query="";
			
			try {
				conn=DBConnect.getConnection();
				query="select * from pj_notice where notice_no=?";
				pstm=conn.prepareStatement(query);
				
				pstm.setInt(1, notice_no);
				
				rs=pstm.executeQuery();
				
				if(rs.next()) {
					noti=new NoticeDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
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
			return noti;
		}

		
		//조회수 증가
		public int updateHit(int notice_no) {
			int rs=0;
			
			Connection conn=null;
			PreparedStatement pstm=null;
			String query="";
			
			try {
				conn=DBConnect.getConnection();
				query="update pj_notice set hit=hit+1 where notice_no=?";
				pstm=conn.prepareStatement(query);
				pstm.setInt(1, notice_no);
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
		
		
		
		
		
		
		
		
		
}
