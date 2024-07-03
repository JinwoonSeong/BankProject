package kr.ac.kopo.member.dao;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberDAO {

    MemberVO login(MemberVO member) throws Exception;

    void signUp(MemberVO member) throws Exception;

    MemberVO getMemberById(String id) throws Exception;

    void updateMember(MemberVO member) throws Exception;

    MemberVO findMemberById(String memberId);

    void delete(String userId);
}
