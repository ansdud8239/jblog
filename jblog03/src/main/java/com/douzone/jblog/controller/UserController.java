package com.douzone.jblog.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.service.UserService;
import com.douzone.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(@ModelAttribute UserVo vo) {
		return "user/join";
	}
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute @Valid UserVo vo,
			BindingResult result,
			Model model
			) {
		if(userService.idDupChk(vo.getId())) {
			// id 중복체크 
			// 아이디가 존재하면?
			// 에러 추가
			result.addError(new FieldError("userVo", "id", "중복된 아이디 값입니다."));
		}
		
		if(result.hasErrors()) {
//			List<ObjectError> list = result.getAllErrors();
//			for(Object error:list) {
//				//System.out.println("error:"+error);
//			}
			model.addAttribute("userVo",vo);
			model.addAllAttributes(result.getModel());
			return "user/join";
		}
		userService.addUser(vo);
		return "user/joinsuccess";
	}
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}
	
}
