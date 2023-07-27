package com.ys.sbbs.service;

import java.util.List;

import com.ys.sbbs.entity.Reply;

public interface ReplyService {

	List<Reply> getReplyList(int bid);
	
	void insertReply(Reply reply);
	
}
