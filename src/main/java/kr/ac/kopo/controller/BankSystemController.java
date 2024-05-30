package kr.ac.kopo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankSystemController {
	    
	 @GetMapping("/mypage")
	    public String  mypage() {
	        return "banksystem/mypage";  
	    }
	}