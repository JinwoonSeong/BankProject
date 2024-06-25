package kr.ac.kopo.controller;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.ac.kopo.account.dao.RandomAccountNumberGenerator;
import kr.ac.kopo.account.service.AccountService;
import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

@SessionAttributes({"userVO"})
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RandomAccountNumberGenerator ra;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/accountRegister")
    public String accountRegisterForm(HttpSession session, Model model) {
        // 세션에서 로그인한 사용자 정보를 가져옵니다.
        MemberVO user = (MemberVO) session.getAttribute("userVO");
        if (user == null) {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉트
            return "redirect:/login";
        }
        return "account/accountRegister";
    }

    @PostMapping("/accountRegister")
    public String accountRegister(@ModelAttribute AccountVO account, Model model, HttpSession session) {
        // 세션에서 로그인한 사용자 정보를 가져옵니다.
        MemberVO user = (MemberVO) session.getAttribute("userVO");
        if (user == null) {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉트
            return "redirect:/login";
        }

        try {
            // 계좌 번호 생성
            String accountNumber = ra.generateRandomAccountNumber();
            account.setAccount_num(accountNumber);

            // 계좌 등록
            AccountVO accountRegisterVO = accountService.accountRegister(account);
            
            if (accountRegisterVO != null) {
                model.addAttribute("accountNumber", accountRegisterVO.getAccount_num());
                return "account/successRegister";
            } else {
                model.addAttribute("registerFailure", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("registerFailure", true);
        }
        return "account/accountRegister";
    }
    
    @GetMapping("/deposit")
    public String depositForm(HttpSession session, Model model) {
        // 세션에서 로그인한 사용자 정보를 가져옵니다.
        MemberVO user = (MemberVO) session.getAttribute("userVO");
        if (user == null) {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉트
            return "redirect:/login";
        }
        return "account/deposit";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam("account_num") String accountNum, @RequestParam("amount") int amount, Model model, HttpSession session) {
        // 세션에서 로그인한 사용자 정보를 가져옵니다.
        MemberVO user = (MemberVO) session.getAttribute("userVO");
        if (user == null) {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉트
            return "redirect:/login";
        }

        try {
            boolean success = accountService.deposit(accountNum, amount);
            if (success) {
                model.addAttribute("depositSuccess", true);
            } else {
                model.addAttribute("depositFailure", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("depositFailure", true);
        }
        return "account/deposit";
    }
    
    @GetMapping("/withdrawal")
    public String withdrawalForm(HttpSession session, Model model) {
        // 세션에서 로그인한 사용자 정보를 가져옵니다.
        MemberVO user = (MemberVO) session.getAttribute("userVO");
        if (user == null) {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉트
            return "redirect:/login";
        }
        return "account/withdrawal";
    }

    @PostMapping("/withdrawal")
    public String withdraw(@RequestParam("accountId") String accountId, 
                           @RequestParam("password") String password, 
                           @RequestParam("amount") int amount, 
                           Model model, HttpSession session) {
        // 세션에서 로그인한 사용자 정보를 가져옵니다.
        MemberVO user = (MemberVO) session.getAttribute("userVO");
        if (user == null) {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉트
            return "redirect:/login";
        }

        try {
            boolean success = accountService.withdraw(accountId, password, amount);
            if (success) {
                model.addAttribute("successMessage", "출금 성공!!");
            } else {
                model.addAttribute("errorMessage", "계좌번호 또는 계좌 비밀번호가 잘못되었습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Error processing withdrawal.");
        }
        return "account/withdrawal";
    }
    
    @GetMapping("/accounts")
    public String listAccounts(HttpSession session, Model model) {
        // 세션에서 로그인한 사용자 정보를 가져옵니다.
        MemberVO user = (MemberVO) session.getAttribute("userVO");
        if (user == null) {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉트
            return "redirect:/login";
        }

        // 고객 ID를 이용해 계좌 목록을 가져옵니다.
        String customerId = user.getCustomer_id();
        model.addAttribute("accounts", accountService.getAccountsByCustomerId(customerId));
        
        return "account/listAccounts";
    }

    @GetMapping("/account/{accountId}")
    public String viewAccountDetails(@PathVariable("accountId") String accountId, Model model, HttpSession session) {
        // 세션에서 로그인한 사용자 정보를 가져옵니다.
        MemberVO user = (MemberVO) session.getAttribute("userVO");
        if (user == null) {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉트
            return "redirect:/login";
        }

        List<TransactionDetailVO> transactions = accountService.getTransactionsByAccountId(accountId);
        
        // 거래 내역을 나중에 일어난 순으로 정렬
        transactions.sort(Comparator.comparing(TransactionDetailVO::getTransactionDate).reversed());
        
        transactions.forEach(transaction -> System.out.println(transaction.getTransactionId() + " " + transaction.getTransactionDate()));
        
        model.addAttribute("account", accountService.getAccountById(accountId));
        model.addAttribute("transactions", transactions);
        return "account/accountDetails";
    }
    
    @GetMapping("/close/{accountId}")
    public String closeAccountForm(@PathVariable("accountId") String accountId, Model model, HttpSession session) {
        // 세션에서 로그인한 사용자 정보를 가져옵니다.
        MemberVO user = (MemberVO) session.getAttribute("userVO");
        if (user == null) {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉트
            return "redirect:/login";
        }

        AccountVO account = accountService.getAccountById(accountId);
        model.addAttribute("account", account);
        return "account/closeAccount";
    }

    @GetMapping("/close")
    public String closeAccount(@RequestParam("accountId") String accountId,
                               @RequestParam("password") String password,
                               Model model, HttpSession session) {
        // 세션에서 로그인한 사용자 정보를 가져옵니다.
        MemberVO user = (MemberVO) session.getAttribute("userVO");
        if (user == null) {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉트
            return "redirect:/login";
        }

        AccountVO account = accountService.getAccountById(accountId);
        if (account.getAccount_money() > 0) {
            model.addAttribute("account", account);
            return "account/confirmCloseAccount";
        }
        boolean isClosed = accountService.closeAccount(accountId, password);
        if (isClosed) {
            return "account/closeSuccess";
        } else {
            model.addAttribute("error", "Invalid password");
            model.addAttribute("account", account);
            return "account/closeAccount";
        }
    }

    @GetMapping("/confirmClose")
    public String confirmCloseAccount(@RequestParam("accountId") String accountId,
                                      @RequestParam("password") String password,
                                      Model model, HttpSession session) {
        // 세션에서 로그인한 사용자 정보를 가져옵니다.
        MemberVO user = (MemberVO) session.getAttribute("userVO");
        if (user == null) {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉트
            return "redirect:/login";
        }

        boolean isClosed = accountService.closeAccount(accountId, password);
        if (isClosed) {
            return "account/closeSuccess";
        } else {
            AccountVO account = accountService.getAccountById(accountId);
            model.addAttribute("error", "Invalid password");
            model.addAttribute("account", account);
            return "account/confirmCloseAccount";
        }
    }
}
