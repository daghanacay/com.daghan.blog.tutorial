package com.daghan.blog.api;

import java.util.List;

import com.daghan.blog.api.domain.Blog;

/**
 * Searches the blogs
 * 
 * @author daghan
 *
 */
public interface BlogSearcher {
	/**
	 * Applies the search criteria to the blog. Implementation can search in
	 * title or body of the blog inside the blog
	 * 
	 * @param searchString
	 * @return
	 */
	public List<Blog> searchBlogs(List<Blog> blogsToSearch, String searchString);
}
