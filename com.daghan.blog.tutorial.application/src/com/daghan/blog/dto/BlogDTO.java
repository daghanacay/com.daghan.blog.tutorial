package com.daghan.blog.dto;

/**
 * Represents the Blog as a DTO object
 * 
 * @author daghan
 *
 */
public class BlogDTO {
	// title of the Blog; must be public to be serialized by the framework
	public String title;
	// body of the Blog; must be public to be serialized by the framework
	public String body;

	/**
	 * Constructor for BlogDTO object. 
	 * safe
	 * 
	 * @param title
	 * @param body
	 */
	public BlogDTO(String title, String body) {
		this.title = title;
		this.body = body;
	}
}
