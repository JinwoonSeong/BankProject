package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

//@Controller
public class MemberController2 {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String loginForm() {
	
		return "member/login";
	}
	
	/*
	 	1. 파라미터 추출(ID, PASSWORD)
	 	2. t_member테이블에 추출한 데이터의 회원 존재여부 판단
	*/
	@PostMapping("/login")
	public String login(MemberVO member, HttpServletRequest request) throws Exception {
		
		MemberVO loginVO = memberService.login(member);
		if(loginVO == null) {
			// 로그인 실패
			return "member/login";
		} else {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("userVO", loginVO);
			System.out.println(session.getAttribute("userVO"));
			return "redirect:/"; 
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}