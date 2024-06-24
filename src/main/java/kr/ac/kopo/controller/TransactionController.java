package kr.ac.kopo.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.transaction.dao.TransactionDAO;
import kr.ac.kopo.transaction.service.TransactionService;
import kr.ac.kopo.transaction.vo.TransactionVO;

@Controller
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionDAO transferDAO;

    @Autowired
    public TransactionController(TransactionService transactionService, TransactionDAO transferDAO) {
        this.transactionService = transactionService;
        this.transferDAO = transferDAO;
    }

    @PostMapping("/checkAccountPassword")
    @ResponseBody
    public Map<String, Boolean> checkAccountPassword(@RequestBody Map<String, String> request) throws Exception {
        System.out.println("Received request: " + request);

        String accountNum = request.get("accountNum");
        String accountPassword = request.get("accountPassword");

        Map<String, Boolean> response = new HashMap<>();
        boolean isValid = false;

        AccountVO account = transferDAO.getAccountByAccountNum(accountNum);

        if (account != null && account.getAccount_password().equals(accountPassword)) {
            isValid = true;
        }

        response.put("valid", isValid);
        return response;
    }

    @PostMapping("/transfer")
    public String transfer(@ModelAttribute TransactionVO transaction) throws Exception {
        transactionService.transfer(transaction);
        System.out.println(transaction);
        
        return "redirect:/";
    }

    @GetMapping("/transfer")
    public String transferForm() {
    	System.out.println("GET request to /transfer received.");
        return "account/transfer";  // 여기에 GET 요청이 도달하면 반환할 JSP 페이지 이름을 입력합니다.
    }
    
    
}
