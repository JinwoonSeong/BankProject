package kr.ac.kopo.member.service;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberService {

    MemberVO login(MemberVO member) throws Exception;

    void signUp(MemberVO member) throws Exception;
    
    MemberVO getMemberById(String id) throws Exception;
    void updateMember(MemberVO member) throws Exception;
    boolean deleteAccount(String userId, String password);
    
    boolean checkId(String id) throws Exception;
}
