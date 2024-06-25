package kr.ac.kopo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.ac.kopo.account.service.AccountService;
import kr.ac.kopo.manager.service.ManagerService;
import kr.ac.kopo.manager.vo.ManagerVO;

@SessionAttributes({"userVO"})
@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;
    
    @Autowired
    private AccountService accountService;

    @GetMapping("/managerLogin")
    public String loginForm(Model model) {
        ManagerVO manager = new ManagerVO();
        model.addAttribute("M", manager);
        return "manager/managerLogin";
    }

    @PostMapping("/managerLogin")
    public String login(@ModelAttribute("M") ManagerVO manager, Model model) throws Exception {
        ManagerVO loginVO = managerService.login(manager);
        if (loginVO == null) {
            // 로그인 실패
            return "manager/managerLogin";
        } else {
            // 로그인 성공
            model.addAttribute("userVO", loginVO);
            return "redirect:/manager/managerHome";
        }
    }

    @GetMapping("/manager/managerHome")
    public String home() {
        return "manager/managerHome";
    }
    
    @GetMapping("/manager/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }
    
    @GetMapping("/manager/listAccountsForManager")
    public String listAccounts(Model model) {
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "manager/listAccountsForManager";
    }
}
