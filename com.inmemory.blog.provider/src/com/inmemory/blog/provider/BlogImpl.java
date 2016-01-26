package com.inmemory.blog.provider;

import java.util.UUID;

import com.daghan.blog.api.domain.Blog;

public class BlogImpl implements Blog {
	String title, body;
	UUID uuid;

	public BlogImpl(String title, String body) {
		this.title = title;
		this.body = body;
		this.uuid = UUID.randomUUID();
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getBody() {
		return body;
	}

	/**
	 * returns the UUID of the message
	 * 
	 * @return
	 */
	public UUID getUuid() {
		return uuid;
	}

}
