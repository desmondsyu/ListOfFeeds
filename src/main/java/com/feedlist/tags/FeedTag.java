package com.feedlist.tags;

import java.io.IOException;
import java.util.List;

import com.feedlist.models.Feed;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class FeedTag extends SimpleTagSupport {
	private List<Feed> feedList;

	public void setFeeds(List<Feed> feedList) {
		this.feedList = feedList;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (feedList != null) {
			JspWriter out = getJspContext().getOut();

			for (Feed feed : feedList) {
				getJspContext().setAttribute("feed", feed);
				getJspBody().invoke(out);
			}
		}
	}
}
