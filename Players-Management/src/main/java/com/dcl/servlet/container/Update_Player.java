package com.dcl.servlet.container;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dcl.servlet.dao.PlayersDao;
import com.dcl.servlet.entity.Players;

@WebServlet("/updateplayer")
public class Update_Player extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String title=req.getParameter("title");
		int age=Integer.parseInt(req.getParameter("age"));
		String team=req.getParameter("team");
		int salary=Integer.parseInt(req.getParameter("sal"));
		String nlity=req.getParameter("nlity");
		
		Players p=new Players();
		p.setAge(age);
		p.setId(id);
		p.setSalary(salary);
		p.setNationality(nlity);
		p.setTeam(team);
		p.setTitle(title);
		
		PlayersDao.updatePlayer(p);
		resp.sendRedirect("displayAll");
	}
	
	
}
