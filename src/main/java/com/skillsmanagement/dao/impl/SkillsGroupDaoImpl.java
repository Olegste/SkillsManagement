package com.skillsmanagement.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillsmanagement.dao.SkillsGroupDao;
import com.skillsmanagement.model.SkillsGroup;

@Repository
@Transactional
public class SkillsGroupDaoImpl implements SkillsGroupDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SkillsGroup getSkillsGroupById(int skillsGroupId) {
		Session session = sessionFactory.getCurrentSession();
		return (SkillsGroup) session.get(SkillsGroup.class, skillsGroupId);
	}

	public void addSkillsGroup(SkillsGroup skillsGroup) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(skillsGroup);
		session.flush();
	}

	public void editSkillsGroup(SkillsGroup skillsGroup) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(skillsGroup);
		session.flush();
	}

	public void deleteSkillsGroup(SkillsGroup skillsGroup) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(skillsGroup);
		session.flush();
	}

	public List<SkillsGroup> getSkillsGroupByUserId(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from skillsgroup where userId = ?");
		query.setInteger(0, userId);
		@SuppressWarnings("unchecked")
		List<SkillsGroup> skillsGroupList = query.list();
		session.flush();

		return skillsGroupList;
	}

}
