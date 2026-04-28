package com.dcl.servlet.container;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dcl.servlet.dao.PlayersDao;
import com.dcl.servlet.entity.Players;
@WebServlet("/displayAll")
public class Display_Player extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Players> li=PlayersDao.displayPlayers();
		
		req.setAttribute("players", li);
		req.getRequestDispatcher("display.jsp").forward(req, resp);
	}
}
