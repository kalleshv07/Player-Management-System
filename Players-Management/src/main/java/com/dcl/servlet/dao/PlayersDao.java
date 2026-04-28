package com.dcl.servlet.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import com.dcl.servlet.entity.Players;

public class PlayersDao {
static EntityManagerFactory emf=Persistence.createEntityManagerFactory("mysql");
	public static void addPlayers(Players p) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		
		em.persist(p);
		et.commit();
		em.close();
	}
	public static List<Players> displayPlayers() {
		EntityManager em =emf.createEntityManager();
		Query query =em.createQuery("FROM Players p");
		List<Players> players=query.getResultList();
		return players;
		
	}
	public static void updatePlayer(Players p) {
		EntityManager em=emf.createEntityManager();
		Players player=em.find(Players.class, p.getId());
		player.setAge(p.getAge());
		player.setNationality(p.getNationality());
		player.setSalary(p.getSalary());
		player.setTeam(p.getTeam());
		player.setTitle(p.getTitle());
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(player);
		et.commit();
		em.close();
	}
	public static Players findPlayer(int id) {
		EntityManager em=emf.createEntityManager();
		Players p=em.find(Players.class, id);
		return p;
	}
	public static void deletebyId(int id) {
		// TODO Auto-generated method stub
		EntityManager em =emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		CriteriaBuilder cb=em.getCriteriaBuilder();
		
		CriteriaDelete<Players> cd=cb.createCriteriaDelete(Players.class);
		Root<Players> root=cd.from(Players.class);
		cd.where(cb.equal(root.get("id"),id));
		et.begin();
		Query query=em.createQuery(cd);
		query.executeUpdate();
		et.commit();
		em.close();
	}

}
