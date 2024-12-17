package com.yedam.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.common.DAO;
import com.yedam.vo.ReplyVO;

public class ReplyDAO extends DAO{
	String query = "select a.* "
			+ 		" from (select /* + INDEX(r PK_REPLY) */ rownum rn, r.*  "
			+ 		"        FROM tbl_reply r "
			+       "        WHERE board_no = ?) a "
			+ 		" WHERE a.rn > (? -1 ) * 5 "
			+ 		" AND a.rn <= ? * 5 ";
	
	String insertQuery = " insert into tbl_reply (reply_no, reply, replyer, board_no) "
			+ "            VALUES( ?, ?, ?, ? )  ";
	
	String deleteQuery = " delete from tbl_reply "
			+ "            WHERE reply_no = ? ";
	
	//전체댓글건수
	String replyCount ="select count(1) FROM tbl_reply WHERE board_no = ? ";
	
	//chart. 게시글 별 댓글 갯수
	String chartQuery = "select board_no || '번 글' as boardNo, count(1) as cnt  "
						+ "from tbl_reply "
						+ "group by board_no ";
	
	//삭제기능
	String removeQuery = "delete from tbl_events "
			+ "           WHERE title = ? AND start_date = ? AND end = ? " ;
	
	
	
	
	
	//일정 삭제
	public boolean removeData(Map<String, String> map) {
		getConn();
		
		try {
			psmt = conn.prepareStatement(removeQuery);
			psmt.setString(1, map.get("title"));
			psmt.setString(2, map.get("start"));
			psmt.setString(3, map.get("end"));
			
			
			int r = psmt.executeUpdate(); //쿼리 업데이트나 인서트
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			disConnect();
		} return false;
	}	
	
	
	//일정등록.
	public boolean insertEvent(Map<String, String> map) {
		getConn();
		String sql = "insert into tbl_events (title, start_date, end) "
				+ "	 values(?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, map.get("title"));
			psmt.setString(2, map.get("start"));
			psmt.setString(3, map.get("end"));
			
			int r = psmt.executeUpdate(); //처리된 건수 반환.			
			if(r > 0) {
				return true; //정상처리.
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
 		} finally {
 			disConnect();
 		}
		return false; //비정상처리.
	}
	
	//fullcalendar 데이터.
	public List<Map<String, Object>> calendarData(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		getConn();
		String sql = "SELECT title, start_date , end FROM tbl_events ";
		
		try {
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("title", rs.getString("title"));
				map.put("start", rs.getString("start_date"));
				map.put("end", rs.getString("end"));
				
				list.add(map);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return list;
	}
	
	
	//차트데이터.
	
	public List<Map<String, Object>> chartData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		getConn();
		
		try {
		psmt = conn.prepareStatement(chartQuery);
		rs = psmt.executeQuery();
		
		//조회결과가 있으면..
		while(rs.next()) {
			Map<String, Object> map = new HashMap<>();
			map.put("boardNo", rs.getString("boardNo"));
			map.put("cnt", rs.getInt("cnt"));
			
			list.add(map);
		}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}
	
	//댓글건수반환.
	public int selectReplyCount(int boardNo) {
		getConn();
		
		try {
		psmt = conn.prepareStatement(replyCount);
		psmt.setInt(1, boardNo);
		rs = psmt.executeQuery();
		
		//조회결과가 있으면..
		if(rs.next()) {
			return rs.getInt(1);
		}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0; //조회된 건수가 없거나 쿼리 없으면 0 반환
	} 
	
	//댓글 등록.
	public boolean insertReply(ReplyVO rvo) {
		getConn();
		
		try {
			psmt = conn.prepareStatement("select reply_seq.nextval FROM dual ");
			rs = psmt.executeQuery();
			int rno = 0; //시퀀스를 먼저 생성해서 rvo에 저장.
			if(rs.next()) {
				rno =rs.getInt(1);
				rvo.setReplyNo(rno);
			}
			
			psmt = conn.prepareStatement(insertQuery);
			psmt.setInt(1, rno);
			psmt.setString(2, rvo.getReply());
			psmt.setString(3, rvo.getReplyer());
			psmt.setInt(4, rvo.getBoardNo());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			disConnect();
		} return false;
	}	
	
	
	
	
	//댓글삭제
	public boolean deleteReply(int replyNo) {
		getConn();
		
		try {
			psmt = conn.prepareStatement(deleteQuery);
			psmt.setInt(1, replyNo);
			
			int r = psmt.executeUpdate(); //쿼리 업데이트나 인서트
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			disConnect();
		} return false;
	}	
	
	
	//댓글목록
	public List<ReplyVO> selectList(int boardNo, int page){
		
		getConn();
		List<ReplyVO> rlist = new ArrayList<>();
	try {
		psmt = conn.prepareStatement(query);
		psmt.setInt(1, boardNo);
		psmt.setInt(2, page);
		psmt.setInt(3, page);
		
		//조회쿼리
		rs = psmt.executeQuery();
		while(rs.next()) {
			ReplyVO rvo = new ReplyVO();
			rvo.setReplyNo(rs.getInt("reply_no"));
			rvo.setReply(rs.getString("reply"));
			rvo.setReplyer(rs.getString("replyer"));
			rvo.setReplyDate(rs.getDate("reply_date"));
			rvo.setBoardNo(rs.getInt("board_no"));
			rlist.add(rvo);			
		}
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		disConnect();
	} return rlist;
	}
}
