package com.body.search.provider;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

import com.daghan.blog.api.BlogSearcher;
import com.daghan.blog.api.domain.Blog;

/**
 * 
 */
@Component(name = "com.body.search")
public class SearchImpl implements BlogSearcher {

	/**
	 * search implementation that checks if the string is contained in the the
	 * body or title of the blog
	 */
	@Override
	public List<Blog> searchBlogs(List<Blog> blogsToSearch, String searchString) {
		return blogsToSearch.parallelStream()
				.filter(blog -> blog.getBody().contains(searchString) || blog.getTitle().contains(searchString))
				.collect(Collectors.toList());
	}

}
