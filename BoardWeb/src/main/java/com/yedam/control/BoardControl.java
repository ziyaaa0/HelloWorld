package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardDAO bdao = new BoardDAO();
		// GET방식 : 조회 vs. POST방식: 등록.
		if (req.getMethod().equals("GET")) {
			//파라미터(board_no); + page + searchCondition + keyword
			String bno = req.getParameter("board_no");
			String page = req.getParameter("page");
			String sc = req.getParameter("searchCondition");
			String kw = req.getParameter("keyword");
			
			BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno)); // 단건조회.

			req.setAttribute("board", bvo); // board의 속성에 조회된 결과를 전달.
			req.setAttribute("searchCondition", sc); 
			req.setAttribute("keyword", kw); 
			req.setAttribute("page", page); 
			
			req.getRequestDispatcher("WEB-INF/html/board.jsp").forward(req, resp);
			
		} else if(req.getMethod().equals("POST")) {
			
			String savePath = req.getServletContext().getRealPath("images");
			int maxSize = 1024 * 1024 * 5; 
			
			//multipart요청
			MultipartRequest mr = new MultipartRequest(
					req, //요청정보.
					savePath, //저장경로
					maxSize, // 업로드할수있는 파일의 최대사이즈.
					"utf-8", //인코딩 방식
					new DefaultFileRenamePolicy()//리네임정책.
					);
					
			String title = mr.getParameter("title");
			String content = mr.getParameter("content");;
			String writer = mr.getParameter("writer");;
			String img = mr.getFilesystemName("img"); //리네임정책에 의해 생성된 파일명.
			
			//위의 값을 가지고 BoardVO 생성
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);
			board.setImg(img);
			
			if(bdao.insertBoard(board)) {
				//목록이동.
				resp.sendRedirect("boardList.do"); //페이지 재 지정.
			}else {
				//등록화면으로 이동.
				req.getRequestDispatcher("WEB-INF/html/boardForm.jsp").forward(req, resp);				
			}
		}
		
	}

}
