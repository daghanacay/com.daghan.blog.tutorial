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
	private final List<Blog> storedBlogs = new ArrayList<>();
	private final String[] bodyArray = { "body of the first blog", "body of the second blog",
			"body of the third blog" };

	@Activate
	private void initSource() {
		String title, body;
		for (int i = 0; i < bodyArray.length; i++) {
			title = "Title-" + (i + 1);
			body = bodyArray[i];
			storedBlogs.add(new BlogImpl(title, body));
		}
	}

	@Override
	public List<Blog> getBlogs() {
		// returns unmodifiable list to make the soure thread safe
		return Collections.unmodifiableList(storedBlogs);
	}

}
