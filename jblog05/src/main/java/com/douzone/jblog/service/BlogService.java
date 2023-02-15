package com.douzone.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	public BlogVo getBlog(String id) {
		return blogRepository.findById(id);
	}

	public void updateBlog(BlogVo vo) {
		blogRepository.update(vo);
		
	}

	public List<CategoryVo> getCategoryList(String id) {
		
		return blogRepository.findAll(id);
	}

	public void addCategory(CategoryVo vo) {
		blogRepository.insert(vo);
		
	}

	public void addContents(PostVo vo) {
		blogRepository.insert(vo);
		
	}

	public Map<Object, Object> getBlogMainPage(String id, Long categoryNo, Long postNo) {
		
		Map<Object,Object> map = new HashMap<Object, Object>();
		
		// category list
		List<CategoryVo> categoryList = blogRepository.findAll(id);
		// blog 
		BlogVo blogVo= blogRepository.findById(id);
		// post List
		List<PostVo> postList = blogRepository.findAll(id,categoryNo);
		// Main post
		PostVo postVo = blogRepository.findByCategoryNoAndPostNo(id,categoryNo,postNo);
		
		map.put("list", categoryList);
		map.put("id",id);
		map.put("blogVo",blogVo);
		map.put("postlist", postList);
		map.put("postvo", postVo);
		return map;
	}

	public void removeCategory(Long no) {
		blogRepository.deleteCategory(no);		
	}

	public void removePost(Long categoryNo) {
		blogRepository.deletePost(categoryNo);
	}

}
