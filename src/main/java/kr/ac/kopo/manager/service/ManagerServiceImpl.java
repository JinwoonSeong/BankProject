package kr.ac.kopo.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.account.dao.AccountDAO;
import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.manager.dao.ManagerDAO;
import kr.ac.kopo.manager.vo.ManagerVO;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDAO managerDao;
	@Autowired
	private AccountDAO accountDao;
	
	@Override
	public ManagerVO login(ManagerVO manager) throws Exception {
		return managerDao.login(manager);
	}
	@Override
    public List<AccountVO> getAllAccounts() {
        return accountDao.getAllAccounts();
    }
}