package com.daghan.blog.api;

import java.util.List;

import com.daghan.blog.api.domain.Blog;

/**
 * Returns available blogs
 * 
 * @author daghan
 *
 */
public interface BlogSource {
	/**
	 * Returns blogs for the system
	 */
	public List<Blog> getBlogs();
}
