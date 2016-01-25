package com.daghan.blog.tutorial.application;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

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
	// Step 1 List of blogs we need
	private List<String> blogs;

	public List<String> getBlogs() {
		//Initiate blog everytime
		blogs = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			blogs.add("BLog Number" + 1);
		}
		return blogs;
	}

}
