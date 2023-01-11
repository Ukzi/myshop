package com.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //컨트롤러의 역할을 하는 클래스를 정의
@RequestMapping(value = "/thymeleaf") //url의 경로를 지정해준다.
public class ThymeleafExController {
	@GetMapping(value = "/ex01")
	public String thymeleafEx01(Model model) {
		model.addAttribute("data", "타임리프 예제 입니다.");
		return "thymeleafEx/thymeleafEx01.html";
	}
}
