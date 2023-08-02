package com.ys.sbbs.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ys.sbbs.dao.UserDaoOracle;
import com.ys.sbbs.entity.User;

@Service
public class UserServiceOracleImpl implements UserService {
	@Autowired private UserDaoOracle userDao;

	@Override
	public int getUserCount() {
		int count = userDao.getUserCount();
		return count;
	}

	@Override
	public User getUser(String uid) {
		User user = userDao.getUser(uid);
		return user;
	}

	@Override
	public List<User> getUserList(int page) {
		int maxrow = page * 10;
		int offset = (page - 1) * 10;
		List<User> list = userDao.getUserList(maxrow, offset);
		return list;
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		System.out.println(user);
		userDao.updateUser(user.getPwd(), user.getUname(), user.getEmail(), user.getProfile(),
							user.getAddr(), user.getUid());
	}

	@Override
	public void deleteUser(String uid) {
		userDao.deleteUser(uid);
	}

	@Override
	public int login(String uid, String pwd) {
		User user = userDao.getUser(uid);
		if (user == null)
			return UID_NOT_EXIST;
		if (BCrypt.checkpw(pwd, user.getPwd()))
			return CORRECT_LOGIN;
		else
			return WRONG_PASSWORD;
	}

}
