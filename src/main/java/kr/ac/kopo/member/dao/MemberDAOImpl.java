package kr.ac.kopo.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    private SqlSessionTemplate sqlSession;
    
    @Override
    public MemberVO login(MemberVO member) throws Exception {
    	System.out.println(member);
        MemberVO loginVO = sqlSession.selectOne("dao.MemberDAO.login", member);
        return loginVO;
    }

    @Override
    public void signUp(MemberVO member) throws Exception {
        sqlSession.insert("dao.MemberDAO.signUp", member);
    }
    
    @Override
    public MemberVO getMemberById(String id) throws Exception {
    	System.out.println(id + "dao1");
    	MemberVO m = sqlSession.selectOne("dao.MemberDAO.getMemberById", id);
    	System.out.println(m + "dao");
        return sqlSession.selectOne("dao.MemberDAO.getMemberById", id);
    }

    @Override
    public void updateMember(MemberVO member) throws Exception {
        sqlSession.update("dao.MemberDAO.updateMember", member);
    }
    
    @Transactional
	public int update_mypage(MemberVO member) throws Exception{
		return sqlSession.update("member.update_mypage", member);
	}
    
    public MemberVO findById(String userId) {
        return sqlSession.selectOne("dao.MemberDAO.findById", userId);
    }

    @Override
    public void delete(String userId) {
        sqlSession.delete("dao.MemberDAO.delete", userId);
    }
}
