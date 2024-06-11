package kr.ac.kopo.loan.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.ac.kopo.loan.service.LoanService;
import kr.ac.kopo.loan.vo.LoanVO;

@SessionAttributes({"userVO"})
@Controller
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/loan/apply")
    public String applyLoanForm() {
        return "loan/applyLoan";
    }

    @PostMapping("/loan/apply")
    public String applyLoan(@ModelAttribute LoanVO loan, Model model) {
        try {
            loanService.applyLoan(loan);
            model.addAttribute("applySuccess", true);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("applyFailure", true);
        }
        return "loan/loanResult";
    }

    @GetMapping("/loan/view")
    public String viewLoan(@RequestParam("customerId") String customerId, Model model) throws Exception {
        LoanVO loan = loanService.getLoanById(customerId);
        model.addAttribute("loan", loan);
        return "loan/viewLoan";
    }
}
