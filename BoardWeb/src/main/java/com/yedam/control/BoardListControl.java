 package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = req.getParameter("page"); //페이지 정보.
		page = page == null ? "1" : page; //page 값이 null 이면 1 페이지 보여줌.
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		
		// @AllArgsConstructor
		// 페이지, 검색조건, 키워드 => 게시글목록출력.
		SearchDTO search = new SearchDTO(Integer.parseInt(page), sc, kw);
		System.out.println(search);
		
		BoardDAO bdao = new BoardDAO();
		List<BoardVO> list = bdao.boardList(search); // 실행영역에서는 실제값을 대입.
											//argument
		int totalCnt = bdao.selectCount(search);
		PageDTO pageDto = new PageDTO(Integer.parseInt(page), totalCnt);

		req.setAttribute("list", list);
		req.setAttribute("paging", pageDto);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		// 요청재지정.
		req.getRequestDispatcher("WEB-INF/html/boardList.jsp").forward(req, resp);

	}

}
