package com.ys.sbbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ys.sbbs.entity.Reply;
import com.ys.sbbs.service.BoardService;
import com.ys.sbbs.service.ReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	@Autowired ReplyService replyService;
	@Autowired BoardService boardService;

	@PostMapping("/write")
	public String writeProc(int bid, String uid, String comment, HttpSession session) {
		String sessionUid = (String) session.getAttribute("uid");
		int isMine = sessionUid.equals(uid) ? 1 : 0;
		Reply reply = new Reply(comment, isMine, sessionUid, bid);
		
		replyService.insertReply(reply);
		boardService.increaseReplyCount(bid);
		
		return "redirect:/board/detail/" + bid + "/" + uid + "?option=DNI";
	}
	
}
