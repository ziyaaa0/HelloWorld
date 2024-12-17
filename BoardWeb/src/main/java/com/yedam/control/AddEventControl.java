package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;

public class AddEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String title = req.getParameter("a");
		String sd = req.getParameter("b");
		String ed = req.getParameter("c");
		
		ReplyDAO rdao = new ReplyDAO();
		
		Map<String, String> inputVal = new HashMap<>();
		inputVal.put("title", title);
		inputVal.put("start", sd);
		inputVal.put("end", ed);
		
		
		if(rdao.insertEvent(inputVal)) {
			// {"retCode" : "OK"}
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		}else{
			// {"retCode" : "Fail"}
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		};
	}

}
