package kr.ac.kopo.manager.service;

import java.util.List;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.manager.vo.ManagerVO;

public interface ManagerService {
    ManagerVO login(ManagerVO manager) throws Exception;
    List<AccountVO> getAllAccounts();
}
