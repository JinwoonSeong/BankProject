package kr.ac.kopo.controller;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.savings.service.SavingsAccountService;
import kr.ac.kopo.savings.vo.SavingsAccountVO;
import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

@Controller
public class SavingsAccountController {

    @Autowired
    private SavingsAccountService savingsAccountService;

    @GetMapping("/savingsAccountRegister")
    public String savingsAccountRegisterForm(HttpSession session, Model model) {
        // 세션에서 사용자 정보 가져오기
        MemberVO user = (MemberVO) session.getAttribute("userVO");
        if (user == null) {
            // 사용자 정보가 없으면 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        // 사용자 정보를 모델에 추가하여 JSP에서 사용할 수 있도록 함
        model.addAttribute("userVO", user);

        try {
            // 적금 유형 리스트 가져오기 (예: 청년적금, 희망적금 등)
            List<String> depositTypes = savingsAccountService.getAllDepositTypes();
            
            // 중복 및 null 값 제거 후 유일한 값만 남기기
            Set<String> uniqueDepositTypes = new HashSet<>(depositTypes);
            uniqueDepositTypes.remove(null); // null 값 제거
            
            // JSP에 전달할 적금 유형 리스트 추가
            model.addAttribute("depositTypes", uniqueDepositTypes);
            
            // 적금 가입 폼을 위한 빈 SavingsAccountVO 객체 추가
            model.addAttribute("savingsAccount", new SavingsAccountVO());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "An error occurred while fetching deposit types.");
        }
        
        // 적금 가입 폼 JSP로 이동
        return "savings/savingsAccountRegister";
    }


    @PostMapping("/savingsAccountRegister")
    public String savingsAccountRegister(@ModelAttribute SavingsAccountVO savingsAccount, @RequestParam("depositType") String depositType, Model model) {
        try {
            if (depositType == null || depositType.isEmpty()) {
                throw new IllegalArgumentException("Deposit type is null or empty");
            }
            int productNumber = savingsAccountService.getProductNumber(depositType);
            String accountNum = savingsAccountService.generateUniqueSavingsAccountNumber(productNumber);
            savingsAccount.setSavings_account_num(accountNum);
            savingsAccount.setProduct_number(productNumber);
            savingsAccount.setDeposit_type(depositType);
            SavingsAccountVO savingsAccountRegisterVO = savingsAccountService.savingsAccountRegister(savingsAccount);
            if (savingsAccountRegisterVO != null) {
                model.addAttribute("accountNumber", accountNum);
                model.addAttribute("amount", savingsAccount.getAmount());
                model.addAttribute("expiration_date", savingsAccount.getExpiration_date());
                model.addAttribute("interestRate", savingsAccount.getInterest_rate());
                return "savings/successSavingsAccount";
            } else {
                model.addAttribute("registerFailure", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("registerFailure", true);
        }
        return "savings/savingsAccountRegister";
    }

    @PostMapping("/savingsDeposit")
    public String savingsDeposit(@RequestParam("savingAccountNum") String savingAccountNum, @RequestParam("amount") int amount, Model model) {
        try {
            boolean success = savingsAccountService.savingsDeposit(savingAccountNum, amount);
            if (success) {
                model.addAttribute("depositSuccess", true);
            } else {
                model.addAttribute("depositFailure", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("depositFailure", true);
        }
        return "savings/savingsDeposit";
    }

    @GetMapping("/generateAccountNumber")
    @ResponseBody
    public String generateAccountNumber(@RequestParam("productNumber") int productNumber) throws Exception {
        return savingsAccountService.generateUniqueSavingsAccountNumber(productNumber);
    }

    @GetMapping("/manager/updateFI")
    public String updateFI() {
        return "manager/updateFI";
    }

    @GetMapping("/savingsCRUD/add")
    public String addSavingsAccountForm(Model model) {
        model.addAttribute("savingsAccount", new SavingsAccountVO());
        return "savingsCRUD/add";
    }

    @PostMapping("/savingsCRUD/add")
    public String addSavingsAccount(@ModelAttribute("savingsAccount") SavingsAccountVO savingsAccount, BindingResult result , Model model) {
        if(result.hasErrors()) {
            System.out.println("ERROR");
        }

        try {
            savingsAccountService.createSavings(savingsAccount);
            model.addAttribute("addSuccess", true);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("addFailure", true);
        }
        return "savingsCRUD/add";
    }

    @GetMapping("/savingsCRUD/edit")
    public String editSavingsAccountForm(Model model) {
        model.addAttribute("savingsAccount", new SavingsAccountVO());
        return "savingsCRUD/edit";
    }

    @PostMapping("/savingsCRUD/edit")
    public String editSavingsAccount(@ModelAttribute("savingsAccount") SavingsAccountVO savingsAccount, Model model) {
        try {
            savingsAccountService.updateSavingsAccount(savingsAccount);
            model.addAttribute("editSuccess", true);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("editFailure", true);
        }
        return "savingsCRUD/edit";
    }

    @GetMapping("/savingsCRUD/delete")
    public String deleteSavingsAccountForm(Model model) {
        return "savingsCRUD/delete";
    }

    @PostMapping("/savingsCRUD/delete")
    public String deleteSavingsAccount(@RequestParam("depositType") String depositType, Model model) {
        try {
            savingsAccountService.deleteSavingsAccountByType(depositType);
            model.addAttribute("deleteSuccess", true);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("deleteFailure", true);
        }
        return "savingsCRUD/delete";
    }
    
    @GetMapping("/savigsaccounts")
    public String listSavingsaccounts(HttpSession session, Model model) {
    	// 세션에서 로그인한 사용자 정보를 가져옵니다.
        MemberVO user = (MemberVO) session.getAttribute("userVO");
        if (user == null) {
            // 사용자 정보가 없는 경우 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }
        
     // 고객 ID를 이용해 계좌 목록을 가져옵니다.
        String customerId = user.getCustomer_id();
        model.addAttribute("accounts", savingsAccountService.getAccountsByCustomerId(customerId));
        
        return "savings/savingslistaccouts";
    }
    
    @GetMapping("/savings/{accountId}")
    public String viewAccountDetails(@PathVariable("accountId") String accountId, Model model) throws Exception {
        List<TransactionDetailVO> transactions = savingsAccountService.getTransactionsByAccountId(accountId);
        
        // 거래 내역을 나중에 일어난 순으로 정렬
        transactions.sort(Comparator.comparing(TransactionDetailVO::getTransactionDate).reversed());
        
        transactions.forEach(transaction -> System.out.println(transaction.getTransactionId() + " " + transaction.getTransactionDate()));
        
        model.addAttribute("account", savingsAccountService.getAccountById(accountId));
        model.addAttribute("transactions", transactions);
        return "savings/savingsacoountDetails";
    }
    
    @GetMapping("/terminateForm/{accountId}")
    public String terminateForm(@PathVariable("accountId") String accountId, Model model) throws Exception {
        SavingsAccountVO account = savingsAccountService.getAccountById(accountId);
        model.addAttribute("account", account);
        return "savings/terminateSavingsAccount";
    }

    @PostMapping("/terminate")
    public String terminateSavingsAccount(@RequestParam("savingsAccountNum") String savingsAccountNum,
                                          @RequestParam("password") String password,
                                          Model model) throws Exception {
        SavingsAccountVO account = savingsAccountService.getAccountById(savingsAccountNum);
        if (account.getAmount() > 0) {
            model.addAttribute("account", account);
            return "savings/confirmTerminateSavingsAccount";
        }

        boolean isTerminated = savingsAccountService.terminateSavingsAccount(savingsAccountNum, password);
        if (isTerminated) {
            return "savings/terminationSuccess";
        } else {
            model.addAttribute("error", "Invalid password");
            model.addAttribute("account", account);
            return "savings/terminateSavingsAccount";
        }
    }

    @PostMapping("/confirmTerminate")
    public String confirmTerminateSavingsAccount(@RequestParam("savingsAccountNum") String savingsAccountNum,
                                                 @RequestParam("password") String password,
                                                 @RequestParam("transferAccountNum") String transferAccountNum,
                                                 Model model) throws Exception {
        boolean isTerminated = savingsAccountService.terminateSavingsAccount(savingsAccountNum, password, transferAccountNum);
        if (isTerminated) {
            return "savings/terminationSuccess";
        } else {
            SavingsAccountVO account = savingsAccountService.getAccountById(savingsAccountNum);
            model.addAttribute("error", "Invalid password or termination failed");
            model.addAttribute("account", account);
            return "savings/confirmTerminateSavingsAccount";
        }
    }
    
    
    
    
    
}
