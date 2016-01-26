package com.daghan.blog.tutorial.application;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.daghan.blog.api.BlogSource;
import com.daghan.blog.api.domain.Blog;
import com.daghan.blog.dto.BlogDTO;

import osgi.enroute.configurer.api.RequireConfigurerExtender;
import osgi.enroute.google.angular.capabilities.RequireAngularWebResource;
import osgi.enroute.rest.api.REST;
import osgi.enroute.twitter.bootstrap.capabilities.RequireBootstrapWebResource;
import osgi.enroute.webserver.capabilities.RequireWebServerExtender;

@RequireAngularWebResource(resource = { "angular.js", "angular-resource.js", "angular-route.js" }, priority = 1000)
@RequireBootstrapWebResource(resource = "css/bootstrap.css")
@RequireWebServerExtender
@RequireConfigurerExtender
@Component(name = "com.daghan.blog.tutorial")
public class TutorialApplication implements REST {
	// get the reference to available blog sources
	@Reference
	BlogSource blogSource;

	// Step 1 List of blogs we need
	private List<BlogDTO> blogs = new ArrayList<>();

	public List<BlogDTO> getBlogs() {
		// Convert the blogs from the source to DTO so it can be read from the
		// IU
		if (blogs.size() == 0) {
			for (Blog tempBlog : blogSource.getBlogs()) {
				blogs.add(new BlogDTO(tempBlog.getTitle(), tempBlog.getBody()));

			}
		}

		return blogs;
	}

}
