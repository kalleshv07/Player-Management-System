package com.dcl.servlet.container;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dcl.servlet.dao.PlayersDao;
import com.dcl.servlet.entity.Players;

@WebServlet("/find-by-id")
public class Find_BY_ID extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("playerId"));
		Players player=PlayersDao.findPlayer(id);
		req.setAttribute("player", player);
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}

}
