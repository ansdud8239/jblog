package com.douzone.jblog.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@Repository
public class BlogRepository {

	@Autowired
	private SqlSession sqlSession;

	public BlogVo findById(String id) {
		return sqlSession.selectOne("blog.findById",id);
	}

	public void update(BlogVo vo) {
		sqlSession.update("blog.update",vo);
		
	}

	public List<CategoryVo> findAll(String id) {
		return sqlSession.selectList("category.findAll",id);
	}

	public void insert(CategoryVo vo) {
		sqlSession.insert("category.insert",vo);
		
	}
	public void insert(PostVo vo) {
		sqlSession.insert("post.insert",vo);
		
	}

	public List<PostVo> findAll(Long categoryNo) {		
		return sqlSession.selectList("post.findByCategoryNo",categoryNo);
	}

	public PostVo findByCategoryNoAndPostNo(Long categoryNo,Long postNo) {
		Map<String, Long> map = Map.of("c",categoryNo,"p",postNo);
		return sqlSession.selectOne("post.findByCategoryNoAndPostNo",map);
	}

	public void insert(BlogVo blogVo) {
		sqlSession.insert("blog.insert",blogVo);
		
	}
}
