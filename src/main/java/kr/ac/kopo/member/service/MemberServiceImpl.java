package kr.ac.kopo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDao;
    
    @Override
    public MemberVO login(MemberVO member) throws Exception {
        return memberDao.login(member);
    }

    @Override
    public void signUp(MemberVO member) throws Exception {
        memberDao.signUp(member);
    }
    
    @Override
    public MemberVO getMemberById(String id) throws Exception {
    	System.out.println("service");
        return memberDao.getMemberById(id);
    }

    @Override
    public void updateMember(MemberVO member) throws Exception {
        memberDao.updateMember(member);
    }
    
    @Override
    public boolean deleteAccount(String userId, String password) {
        MemberVO user = memberDao.findById(userId);
        if (user != null && user.getPassword().equals(password)) {
        	memberDao.delete(userId);
            return true;
        }
        return false;
    }
}
