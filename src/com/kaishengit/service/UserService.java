package com.kaishengit.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.User;

@Named
@Transactional
public class UserService {

	@Inject
	private UserDao userDao;

	public User findById(int userId) {
		return userDao.findById(userId);
	}

	public void save(User user) {
		user.setEnable(true);
		userDao.save(user);
	}
}
