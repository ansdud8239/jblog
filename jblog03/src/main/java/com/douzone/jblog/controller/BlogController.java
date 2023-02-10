package com.douzone.jblog.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.FileuploadService;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private FileuploadService fileuploadService;

	@RequestMapping({ "", "/{pathNo1}", "/{pathNo1}/{pathNo2}" })
	public String index(@PathVariable("id") String id, @PathVariable("pathNo1") Optional<Long> pathNo1,
			@PathVariable("pathNo2") Optional<Long> pathNo2,Model model) {
		Long categoryNo = 1l;
		Long postNo = 1l;
		//System.out.println("--"+pathNo1+":"+pathNo2+"--");
		if(pathNo2.isPresent()) {
			categoryNo = pathNo1.get();
			postNo = pathNo2.get();
		}else if(pathNo1.isPresent()) {
			categoryNo = pathNo1.get();
		
		}
		//System.out.println("--"+categoryNo+":"+postNo+"--");
		
		Map<Object, Object> map =blogService.getBlogMainPage(id,categoryNo,postNo);
		model.addAttribute("map",map);
		return "/blog/main";
	}

	@RequestMapping("/admin/basic")
	public String adminBasic(@PathVariable String id, Model model) {
		BlogVo vo = blogService.getBlog(id);
		model.addAttribute("vo", vo);
		return "/blog/admin-basic";
	}

	@RequestMapping("/admin/basic/update")
	public String adminUpdateBasic(@PathVariable String id, Model model, BlogVo vo, MultipartFile file) {
		vo.setProfile(fileuploadService.restore(file));
		vo.setId(id);
		blogService.updateBlog(vo);
		return "redirect:/" + id + "/admin/basic";
	}

	@RequestMapping("/admin/category")
	public String adminCategory(@PathVariable String id, Model model) {
		List<CategoryVo> list = blogService.getCategoryList(id);
		model.addAttribute("list", list);
		return "/blog/admin-category";
	}
	@RequestMapping("/admin/category/add")
	public String adminAddCategory(@PathVariable String id,CategoryVo vo, Model model) {
		vo.setId(id);
		blogService.addCategory(vo);
		return "redirect:/"+id+"/admin/category";
	}

	@RequestMapping(value="/admin/write", method = RequestMethod.GET)
	public String adminWrite(@PathVariable String id, Model model) {
		List<CategoryVo> list = blogService.getCategoryList(id);
		model.addAttribute("list", list);
		return "/blog/admin-write";
	}
	@RequestMapping(value="/admin/write", method = RequestMethod.POST)
	public String adminWrite(@PathVariable String id,PostVo vo) {
		System.out.println(vo);
		blogService.addContents(vo);
		
		return "redirect:/"+id;
	}
}
