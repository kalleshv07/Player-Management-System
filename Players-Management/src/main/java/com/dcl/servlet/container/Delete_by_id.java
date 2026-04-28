package com.dcl.servlet.container;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dcl.servlet.dao.PlayersDao;

@WebServlet("/delete-by-id")
public class Delete_by_id extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("playerId"));
		PlayersDao.deletebyId(id);
		resp.sendRedirect("displayAll");
	}
}
