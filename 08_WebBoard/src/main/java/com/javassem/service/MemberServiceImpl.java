package com.javassem.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.MemberDAOImpl;
import com.javassem.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

   @Autowired
   private MemberDAOImpl memberDAO;
   
   
   /**
     * 아이디 중복 체크하는 sql + 로그인 기능 sql
     */
     public MemberVO idCheck_Login( MemberVO vo)
     {
        return memberDAO.idCheck(vo);
     }
     
     
     /**
      * 회원가입 sql
      */
      public int userInsert(MemberVO vo)
      {
        return memberDAO.memberInsert(vo);
      }

      // 전체 목록 리스트로 받기
      public List<MemberVO> selectAll() {
         return memberDAO.memberSelectAll();
      }
}