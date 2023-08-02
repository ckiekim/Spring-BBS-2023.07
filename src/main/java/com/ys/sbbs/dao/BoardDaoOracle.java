package com.ys.sbbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ys.sbbs.entity.Board;

@Mapper
public interface BoardDaoOracle {
	
	@Select("SELECT b.bid, b.\"uid\", b.title, b.content, b.modTime, b.viewCount, "
				+ "	b.replyCount, b.files, u.uname FROM board b "
				+ "	JOIN users u ON b.\"uid\"=u.\"uid\" WHERE b.bid=#{bid}")
	Board getBoard(int bid);
	
	@Select("select count(bid) from board where isDeleted=0 AND ${field} like #{query}")
	int getBoardCount(String field, String query);

	@Select("SELECT * from ("
			+ "   select rownum as rnum, a.* from ("
			+ "		select b.bid, b.\"uid\", b.title, b.modTime, b.viewCount, b.replyCount,"
			+ "		u.uname FROM board b JOIN users u ON b.\"uid\"=u.\"uid\" "
			+ "		WHERE b.isDeleted=0 AND ${field} LIKE #{query}"
			+ "		ORDER BY b.modTime DESC ) a "
			+ "	  WHERE rownum <= #{maxrow})"
			+ " WHERE rnum > #{offset}")
	List<Board> listBoard(String field, String query, int maxrow, int offset);
	
	@Insert("insert into board values(default, #{uid}, #{title}, #{content, jdbcType=VARCHAR},"
			+ " default, default, default, default, #{files, jdbcType=VARCHAR})")
	void insertBoard(Board board);
	
	@Update("update board set title=#{title}, content=#{content, jdbcType=VARCHAR},"
			+ " modTime=CURRENT_TIMESTAMP, files=#{files, jdbcType=VARCHAR}"
			+ " where bid=#{bid}")
	void updateBoard(Board board);
	
	@Update("update board set isDeleted=1 where bid=#{bid}")
	void deleteBoard(int bid);
	
	@Update("update board set ${field}=${field}+1 where bid=#{bid}")
	void increaseCount(String field, int bid);
	
}
