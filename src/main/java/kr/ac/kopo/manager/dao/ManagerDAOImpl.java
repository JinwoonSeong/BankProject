package kr.ac.kopo.manager.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.manager.vo.ManagerVO;

@Repository
public class ManagerDAOImpl implements ManagerDAO {

    @Autowired
    private SqlSessionTemplate sqlSession;
   

	@Override
	public ManagerVO login(ManagerVO manager) throws Exception{
		System.out.println(manager);
        ManagerVO loginVO = sqlSession.selectOne("dao.ManagerDAO.login", manager);
        return loginVO;
	}

}
