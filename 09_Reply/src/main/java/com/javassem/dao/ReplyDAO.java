package com.javassem.dao;

import java.util.List;

import com.javassem.domain.ReplyVO;

import lombok.Data;

@Data
public interface ReplyDAO {

	public Integer insertReply(ReplyVO vo); 
	public List<ReplyVO> selectAllReply();
	public int deleteReply(String rno);
}
