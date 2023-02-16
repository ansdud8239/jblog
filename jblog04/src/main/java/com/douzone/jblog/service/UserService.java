package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.repository.UserRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;

	public void addUser(UserVo userVo) {
		userRepository.insert(userVo);
		blogRepository.insert(new BlogVo(userVo.getId(),(userVo.getName()+"의 blog"), ("/assets/images/spring-logo.jpg")));
		blogRepository.insert(new CategoryVo(userVo.getId(), "기본", "기본카테고리 입니다."));
	}

	public UserVo getUser(UserVo userVo) {
		return userRepository.findByIdAndPassword(userVo);
		
	}
	public boolean idDupChk(String id) {
		return userRepository.findById(id)==1?true:false;
	}

}
