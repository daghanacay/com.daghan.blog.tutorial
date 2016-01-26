package com.inmemory.blog.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import com.daghan.blog.api.BlogSource;
import com.daghan.blog.api.domain.Blog;

/**
 * Provides blogs from a fixed hard coded blogs
 */
@Component(name = "com.inmemory.blog")
public class BlogSourceImpl implements BlogSource {
	private final List<Blog> storedBlogs = new ArrayList<>();;

	@Activate
	private void initSource() {
		String title, body;
		for (int i = 0; i < 15; i++) {
			title = "Title-" + (i + 1);
			body = "Body from the BlogSourceImpl: " + (i + 1);
			storedBlogs.add(new BlogImpl(title, body));
		}
	}

	@Override
	public List<Blog> getBlogs() {
		// returns unmodifiable list to make the soure thread safe
		return Collections.unmodifiableList(storedBlogs);
	}

}
