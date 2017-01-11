package com.skillsmanagement.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillsmanagement.dao.SkillsDao;
import com.skillsmanagement.model.Skills;

@Repository
@Transactional
public class SkillsDaoImpl implements SkillsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Skills getSkillsById(int skillsId) {
		Session session = sessionFactory.getCurrentSession();
		return (Skills) session.get(Skills.class, skillsId);
	}

	public List<Skills> getSkillsBySkillsGroupId(int skillsGroupId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from skills where skillsgroupid = ?");
		query.setInteger(0, skillsGroupId);
		@SuppressWarnings("unchecked")
		List<Skills> skillsList = query.list();
		session.flush();

		return skillsList;
	}

	public void addSkills(Skills skills) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(skills);
		session.flush();
	}

	public void editSkills(Skills skills) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(skills);
		session.flush();
	}

	public void deleteSkills(Skills skills) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(skills);
		session.flush();
	}

}
