package com.yedam.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public class BoardDAO extends DAO {

	// 회원정보 로그인 진행.     //파라메타
	public String login(String id, String pw) {
		getConn();
		String sql = "select * FROM tbl_member " //
				+ " WHERE member_id = ? " //
				+ " AND password = ? "; //

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getString("member_name");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

	// 실제 건수.
	public int selectCount(SearchDTO search) {
		getConn();
		String sql = "select count(1) " //
				+ "   from tbl_board "; //

		if (search.getSearchCondition() != null && search.getKeyword() != null) {

			if (search.getSearchCondition().equals("T")) {
				sql += "             WHERE title like '%'||?||'%' "; //
			} else if (search.getSearchCondition().equals("W")) {  //
				sql += "             WHERE writer like '%'||?||'%' "; //
			} else if (search.getSearchCondition().equals("TW")) {//
				sql += "             WHERE title like '%'||?||'%' OR writer like '%'||?||'%'  "; //
			}
		}
		
		
		try {
			psmt = conn.prepareStatement(sql);
			int cnt = 1;
			if (search.getSearchCondition() != null && search.getKeyword() != null) {
				if (search.getSearchCondition().equals("T")) {

					psmt.setString(cnt++, search.getKeyword()); // T에 대한 첫번째 파라미터

				} else if (search.getSearchCondition().equals("W")) {

					psmt.setString(cnt++, search.getKeyword()); // W에 대한 첫번째 파라미터

				} else if (search.getSearchCondition().equals("TW")) {

					psmt.setString(cnt++, search.getKeyword()); // TW에 대한 첫번째 파라미터
					psmt.setString(cnt++, search.getKeyword()); // TW에 대한 두번째 파라미터
				}
			}
			System.out.println(sql);
			
			
			rs = psmt.executeQuery(); // 조회.
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}

	// 수정(내용,제목)
	public boolean updateBoard(BoardVO board) {
		getConn();
		String sql = "UPDATE tbl_board " //
				+ "   SET    title = ? " //
				+ "          , content = ? " + "   WHERE  board_no = ? "; //

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setInt(3, board.getBoardNo());
			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}

	// 상세조회. 파라미터(int boardNo) selectBoard 반환값: BoardVO.
	public BoardVO selectBoard(int boardNo) {
		getConn();
		String sql = "select * from tbl_board where board_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery(); // 조회.

			while (rs.next()) {
				BoardVO brd = new BoardVO();
				brd.setBoardNo(rs.getInt("board_no"));
				brd.setTitle(rs.getString("title"));
				brd.setContent(rs.getString("content"));
				brd.setWriter(rs.getString("writer"));
				brd.setViewCnt(rs.getInt("view_cnt"));
				brd.setCreationDate(rs.getDate("creation_date"));
				brd.setImg(rs.getString("img"));
				
				return brd;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

	// BoardVO 파라미터 => 등록.
	public boolean insertBoard(BoardVO board) {
		getConn();
		String sql = "insert into tbl_board " //
				+ "(board_no, title, content, writer, img) " //
				+ "values(board_seq.nextval, ?, ?, ?, ? ) ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			psmt.setString(4, board.getImg());
			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}

	// 목록.
	public List<BoardVO> boardList(SearchDTO search) {
		getConn();
		String sql = "SELECT b.* " + "   FROM    (SELECT rownum rn, a.*  " 
		        + "    FROM   (SELECT *  "
				+ "            FROM tbl_board  ";

		// Title 검색조건 => title 컬럼에서 값을 조회
		if (search.getSearchCondition() != null && search.getKeyword() != null) {

			if (search.getSearchCondition().equals("T")) {
				sql += "             WHERE title like '%'||?||'%' ";
			} else if (search.getSearchCondition().equals("W")) {
				sql += "             WHERE writer like '%'||?||'%' ";
			} else if (search.getSearchCondition().equals("TW")) {
				sql += "             WHERE title like '%'||?||'%' OR writer like '%'||?||'%'  ";
			}
		}
		sql += "                ORDER BY board_no desc ) a ) b  " 
		        + "   WHERE b.rn > (? -1) * 5  "
				+ "   and  b.rn <=  ? * 5 ";
		
		List<BoardVO> result = new ArrayList<>(); // 반환값.

		// 순번 알려줌.
		int cnt = 1;
		try {
			psmt = conn.prepareStatement(sql);
			if (search.getSearchCondition() != null && search.getKeyword() != null) {
				if (search.getSearchCondition().equals("T")) {

					psmt.setString(cnt++, search.getKeyword()); // T에 대한 첫번째 파라미터

				} else if (search.getSearchCondition().equals("W")) {

					psmt.setString(cnt++, search.getKeyword()); // W에 대한 첫번째 파라미터

				} else if (search.getSearchCondition().equals("TW")) {

					psmt.setString(cnt++, search.getKeyword()); // TW에 대한 첫번째 파라미터
					psmt.setString(cnt++, search.getKeyword()); // TW에 대한 두번째 파라미터
				}
			}
			psmt.setInt(cnt++, search.getPage());
			psmt.setInt(cnt++, search.getPage());
			System.out.println(sql);

			rs = psmt.executeQuery(); // 조회.

			while (rs.next()) {
				BoardVO brd = new BoardVO();
				brd.setBoardNo(rs.getInt("board_no"));
				brd.setTitle(rs.getString("title"));
				brd.setContent(rs.getString("content"));
				brd.setWriter(rs.getString("writer"));
				brd.setViewCnt(rs.getInt("view_cnt"));
				brd.setCreationDate(rs.getDate("creation_date"));

				result.add(brd); // ArrayList에 추가.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}
}
