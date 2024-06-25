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
    public Map<String, Object> checkPassword(@RequestBody Map<String, String> request) {
        String password = request.get("password");
        Map<String, Object> response = new HashMap<>();
        response.put("valid", password != null && password.matches("[0-9]{6}"));
        return response;
    }

    @PostMapping("/checkSavingsPassword")
    @ResponseBody
    public Map<String, Object> checkSavingsPassword(@RequestBody Map<String, String> request) {
        String savingsPassword = request.get("savingsPassword");
        Map<String, Object> response = new HashMap<>();
        response.put("valid", savingsPassword != null && savingsPassword.matches("[0-9]{6}"));
        return response;
    }
}
