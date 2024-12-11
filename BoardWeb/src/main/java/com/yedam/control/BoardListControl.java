 package com.yedam.control;

import java.io.IOException;
import java.util.List;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = req.getParameter("page"); //페이지 정보.
		page = page == null ? "1" : page; //page 값이 null 이면 1 페이지 보여줌.
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		
		// @AllArgsConstructor
		SearchDTO search = new SearchDTO(Integer.parseInt(page), sc, kw);
		System.out.println(search);
		
		BoardDAO bdao = new BoardDAO();
		List<BoardVO> list = bdao.boardList(search);
		
		int totalCnt = bdao.selectCount(search);
		PageDTO pageDto = new PageDTO(Integer.parseInt(page), totalCnt);

		req.setAttribute("list", list);
		req.setAttribute("paging", pageDto);
		// 요청재지정.
		req.getRequestDispatcher("html/boardList.jsp").forward(req, resp);

	}

}
