package com.ys.sbbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ys.sbbs.dao.ReplyDaoMySQL;
import com.ys.sbbs.entity.Reply;

@Service
public class ReplyServiceMySQLImpl implements ReplyService {
	@Autowired private ReplyDaoMySQL replyDao;

	@Override
	public List<Reply> getReplyList(int bid) {
		List<Reply> list = replyDao.getReplyList(bid);
		return list;
	}

	@Override
	public void insertReply(Reply reply) {
		replyDao.insertReply(reply);
	}

}
