package kr.ac.kopo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PasswordController {

    @PostMapping("/checkPassword")
    @ResponseBody
    public Map<String, Boolean> checkPassword(@RequestBody Map<String, String> request) {
        String password = request.get("password");
        String savingsPassword = request.get("savings_password");
        Map<String, Boolean> response = new HashMap<>();
        
        // 비밀번호 유효성 로직 (예: 특정 기준에 맞는지 확인)
        boolean isValid = password != null && password.matches("\\d{6}");
        boolean isValid2 = savingsPassword != null & savingsPassword.matches("\\d{6}");
        response.put("valid", isValid);
        response.put("valid2", isValid2);
        return response;
    }
}
