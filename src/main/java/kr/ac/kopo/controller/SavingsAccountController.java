package kr.ac.kopo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.savings.service.SavingsAccountService;
import kr.ac.kopo.savings.vo.SavingsAccountVO;

@Controller
public class SavingsAccountController {

    @Autowired
    private SavingsAccountService savingsAccountService;

    @PostMapping("/savingsAccountRegister")
    public String savingsAccountRegister(@ModelAttribute SavingsAccountVO savingsAccount, Model model) {
        try {
            SavingsAccountVO savingsAccountRegisterVO = savingsAccountService.savingsAccountRegister(savingsAccount);
            if (savingsAccountRegisterVO != null) {
                model.addAttribute("registerSuccess", true);
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
    @GetMapping("/savingsAccountRegister")
    public String savingsAccountRegisterForm() {
        return "savings/savingsAccountRegister";
    }
 // 적금 상품 CRUD 페이지
    @GetMapping("/manager/updateFI")
    public String updateFI() {
        return "manager/updateFI";
    }

    // 적금 상품 추가
    @GetMapping("/savingsCRUD/add")
    public String addSavingsAccountForm(Model model) {
        model.addAttribute("savingsAccount", new SavingsAccountVO());
        return "savingsCRUD/add";
    }

    @PostMapping("/savingsCRUD/add")
    public String addSavingsAccount(@ModelAttribute SavingsAccountVO savingsAccount, Model model) {
        try {
            savingsAccountService.createSavings(savingsAccount);
            model.addAttribute("addSuccess", true);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("addFailure", true);
        }
        return "savingsCRUD/add";
    }

    // 적금 상품 수정
    @GetMapping("/savingsCRUD/edit")
    public String editSavingsAccountForm(@RequestParam("savingsAccountNum") String savingsAccountNum, Model model) {
        try {
            SavingsAccountVO savingsAccount = savingsAccountService.findSavingsAccountByNumber(savingsAccountNum);
            model.addAttribute("savingsAccount", savingsAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "savingsCRUD/edit";
    }

    @PostMapping("/savingsCRUD/edit")
    public String editSavingsAccount(@ModelAttribute SavingsAccountVO savingsAccount, Model model) {
        try {
            savingsAccountService.updateSavingsAccount(savingsAccount);
            model.addAttribute("editSuccess", true);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("editFailure", true);
        }
        return "savingsCRUD/edit";
    }

    // 적금 상품 삭제
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
}
