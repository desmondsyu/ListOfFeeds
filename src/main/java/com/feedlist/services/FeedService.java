package com.feedlist.services;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import com.feedlist.models.Feed;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import jakarta.servlet.ServletContext;

public class FeedService {
	 public List<Feed> loadFeeds(ServletContext context) {
	        Gson gson = new Gson();
	        List<Feed> feeds = null;

	        try (InputStream inputStream = context.getResourceAsStream("/WEB-INF/feeds.json");
	             InputStreamReader streamReader = new InputStreamReader(inputStream);
	             JsonReader reader = new JsonReader(streamReader)) {

	            Type feedListType = new TypeToken<List<Feed>>() {}.getType();
	            feeds = gson.fromJson(reader, feedListType);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return feeds;
    }
}
