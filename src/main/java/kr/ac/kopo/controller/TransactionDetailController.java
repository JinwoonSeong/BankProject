package kr.ac.kopo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.kopo.transactiondetail.service.TransactionDetailService;
import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

public class TransactionDetailController {
	
	@Autowired
    private TransactionDetailService transactionDetailService;

    @PostMapping("/deposit")
    public String deposit(TransactionDetailVO transaction, Model model) {
    	transactionDetailService.deposit(transaction);
        return "redirect:/transactionSuccess";
    }

    @PostMapping("/withdraw")
    public String withdraw(TransactionDetailVO transaction, Model model) {
    	transactionDetailService.withdraw(transaction);
        return "redirect:/transactionSuccess";
    }

    @PostMapping("/transfer")
    public String transfer(TransactionDetailVO transaction, Model model) {
    	transactionDetailService.transfer(transaction);
        return "redirect:/transactionSuccess";
    }

    @PostMapping("/loan")
    public String loan(TransactionDetailVO transaction, Model model) {
    	transactionDetailService.loan(transaction);
        return "redirect:/transactionSuccess";
    }

}
