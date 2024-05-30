package kr.ac.kopo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.kopo.account.service.AccountService;
import kr.ac.kopo.account.vo.AccountVO;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/accountRegister")
    public String accountRegisterForm() {
        return "account/accountRegister";
    }

    @PostMapping("/accountRegister")
    public String accountRegister(@ModelAttribute AccountVO account, Model model) {
        try {
            AccountVO accountRegisterVO = accountService.accountRegister(account);
            System.out.println(account);
            String customerId = account.getCustomer_id();
            System.out.println(customerId);
            if (accountRegisterVO != null) {
                model.addAttribute("registerSuccess", true);
            } else {
                model.addAttribute("registerFailure", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("registerFailure", true);
        }
        return "redirect:/";
    }
}
