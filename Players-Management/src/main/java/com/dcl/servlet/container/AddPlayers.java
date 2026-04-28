package com.dcl.servlet.container;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dcl.servlet.dao.PlayersDao;
import com.dcl.servlet.entity.Players;

@WebServlet("/addplayer")
public class AddPlayers extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("title");
		int age=Integer.parseInt(req.getParameter("age"));
		String team=req.getParameter("team");

		long salary=Long.parseLong(req.getParameter("salary"));
		String nlity=req.getParameter("nlity");
		
		Players p=new Players();
		p.setTitle(name);
		p.setAge(age);
		p.setSalary(salary);
		p.setNationality(nlity);
		p.setTeam(team);
		
		PlayersDao.addPlayers(p);
		
		resp.sendRedirect("index.jsp");

	}
}
