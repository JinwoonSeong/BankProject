package kr.ac.kopo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

@SessionAttributes({"userVO"})
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		MemberVO member = new MemberVO();
		model.addAttribute("M", member);
		return "member/login";
	}
	
	/*
	 	1. 파라미터 추출(ID, PASSWORD)
	 	2. t_member테이블에 추출한 데이터의 회원 존재여부 판단
	*/
	/**
	 * 스프링 세션에 등록하는 방식으로 로그인 구현
	 *
	 */
	@PostMapping("/login")
	public String login(@ModelAttribute("M") MemberVO member, Model model) throws Exception {
		System.out.println(member);
		MemberVO loginVO = memberService.login(member);
		if(loginVO == null) {
			// 로그인 실패
			return "member/login";
		} else {
			// 로그인 성공
			model.addAttribute("userVO", loginVO);
			return "redirect:/"; 
		}
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
	
	@GetMapping("/signup")
	public String signUpForm() {
	    return "member/signup";
	    }

	@PostMapping("/signup")
	public String signUp(MemberVO member, Model model) throws Exception { // 회원가입 처리
	System.out.println(member);
		memberService.signUp(member);// 회원가입 후 로그인 페이지로 리다이렉트
	        return "redirect:/login";
	    }
	
	@GetMapping("/member/mypage")
    public String viewMyPage(HttpSession session, Model model) throws Exception {
        // 로그인한 사용자의 ID를 세션에서 가져옵니다.
        MemberVO m = (MemberVO) session.getAttribute("userVO");
        System.out.println("씨발거"+ m);
        
        // ID에 해당하는 회원 정보를 가져옵니다.
        MemberVO member = memberService.getMemberById(m.getCustomer_id());
        System.out.println(member);
        
        // 모델에 회원 정보를 추가합니다.
        model.addAttribute("member", member);
        
        // mypage.jsp 페이지로 이동합니다.
        return "banksystem/mypage";
    }
	@GetMapping("/member/update")
    public String  update() {
        return "member/update";  
    }

    @PostMapping("/member/update")
    public String updateMyPage(@ModelAttribute("member") MemberVO member, HttpSession session, Model model) throws Exception {
        // 회원 정보를 업데이트합니다.
        memberService.updateMember(member);
        System.out.println(member+"성진운");
        // 세션에 저장된 회원 정보를 갱신합니다.
        session.setAttribute("member", memberService.getMemberById(member.getCustomer_id()));
        System.out.println("살려줘");
        // mypage.jsp 페이지로 리다이렉트합니다.
        return "redirect:/mypage";
    }
    
    @GetMapping("/deleteAccount")
    public String deleteAccountForm() {
        return "member/deleteAccount";
    }

    @PostMapping("/deleteAccount")
    public String deleteAccount(@RequestParam("userId") String userId, 
                                @RequestParam("password") String password, 
                                Model model) {
        try {
            boolean success = memberService.deleteAccount(userId, password);
            if (success) {
                model.addAttribute("successMessage", "회원탈퇴가 정상적으로 완료되었습니다.");
                return "redirect:/logout"; // Assuming there's a logout mechanism
            } else {
                model.addAttribute("errorMessage", "사용자 ID 또는 암호를 잘못되었습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Error processing account deletion.");
        }
        return "member/deleteAccount";
    }
}







