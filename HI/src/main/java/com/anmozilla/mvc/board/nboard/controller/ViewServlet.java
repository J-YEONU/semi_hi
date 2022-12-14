package com.anmozilla.mvc.board.nboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anmozilla.mvc.board.nboard.model.service.BoardService;
import com.anmozilla.mvc.board.nboard.model.vo.Board;

@WebServlet("/nboard/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewServlet() {
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Board board = null;
    	int no = Integer.parseInt(request.getParameter("no"));
    	
    	System.out.println("게시글 번호 : " + no);
    	
    	board = new BoardService().getBoardByNo(no);
    	
    	System.out.println(board);
    	
    	request.setAttribute("board", board);
    	request.getRequestDispatcher("/views/nboard/view.jsp").forward(request, response);
	}

}