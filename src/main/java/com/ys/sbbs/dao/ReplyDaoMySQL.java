package com.ys.sbbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ys.sbbs.entity.Reply;

@Mapper
public interface ReplyDaoMySQL {

	@Select("SELECT r.rid, r.comment, r.regTime, r.isMine, r.uid, r.bid, u.uname FROM reply AS r "
			+ "	JOIN users AS u ON r.uid=u.uid WHERE r.bid=#{bid}")
	List<Reply> getReplyList(int bid);
	
	@Insert("insert into reply values(default, #{comment}, default, #{isMine}, #{uid}, #{bid})")
	void insertReply(Reply reply);
	
}
