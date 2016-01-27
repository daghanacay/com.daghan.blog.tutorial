package com.daghan.blog.tutorial.application;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.daghan.blog.api.BlogSearcher;
import com.daghan.blog.api.BlogSource;
import com.daghan.blog.api.domain.Blog;
import com.daghan.blog.dto.BlogDTO;

import osgi.enroute.configurer.api.RequireConfigurerExtender;
import osgi.enroute.google.angular.capabilities.RequireAngularWebResource;
import osgi.enroute.rest.api.REST;
import osgi.enroute.rest.api.RESTRequest;
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

	@Reference
	BlogSearcher blogSearcher;

	public List<BlogDTO> getBlogs() {
		// Convert the blogs from the source to DTO so it can be read from the
		// IU
		return convertBlogs(blogSource.getBlogs());
	}

	/**
	 * Returns the blogs that supports the search criteria. it takes the first
	 * value in the query string and searches the blogs
	 * 
	 * @param request
	 * @return
	 */
	public List<BlogDTO> getBlogs(RESTRequest request, String searchUrl) {
		List<BlogDTO> returnVal = new ArrayList<>();
		String[] queryArray = new String[] {};
		if (request._request().getQueryString() != null) {
			queryArray = request._request().getQueryString().split("=");
		}

		if (queryArray.length > 1) {
			returnVal = convertBlogs(blogSearcher.searchBlogs(blogSource.getBlogs(), queryArray[1]));
		} else {
			returnVal = getBlogs();
		}
		return returnVal;
	}

	/**
	 * Utility method to convert Blogs to its DTO
	 * 
	 * @param blogs
	 * @return
	 */
	private List<BlogDTO> convertBlogs(List<Blog> blogs) {
		List<BlogDTO> blogsDto = new ArrayList<>();
		for (Blog tempBlog : blogs) {
			blogsDto.add(new BlogDTO(tempBlog.getTitle(), tempBlog.getBody()));
		}
		return blogsDto;
	}

}
