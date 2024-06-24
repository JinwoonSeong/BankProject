package kr.ac.kopo.manager.dao;

import kr.ac.kopo.manager.vo.ManagerVO;

public interface ManagerDAO {
    ManagerVO login(ManagerVO manager) throws Exception;
}

