package kr.ac.kopo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.member.service.MemberService;

@RestController
public class MemberASyncController {

	@Autowired
	MemberService memberService;
	
	// 중복체크
	@GetMapping("/checkId/{id}")
	public boolean checkId(@PathVariable("id") String id) throws Exception {

		return memberService.checkId(id);
	}
}
