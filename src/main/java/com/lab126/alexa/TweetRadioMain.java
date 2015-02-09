package com.lab126.alexa;

import java.util.Map;

import twitter4j.IDs;
import twitter4j.PagableResponseList;
import twitter4j.RateLimitStatus;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class TweetRadioMain {

	private static final String		BROWSER_CONSUMER_KEY = "ie7dINtXBOzDYESMKimM6Ee0s";
	private static final String		BROWSER_CONSUMER_SECRET = "XMZWUJyOSn6hLQiBsQAF0qdg1HESH4P9PQxeUaPteKQcxZUcZA";
	private static final String 	ACCESS_TOKEN = "26122273-aWRUdzbQW3YL4KwYOtrJ3UMSVBe3WeblBe9zCbpEq";
	private static final String		ACCESS_TOKEN_SECRET = "JCuWEysi6D1AtZBX4z0h82iq6BB9ITUFw6cDdPNNJw3K4";
	
	
	public static void main(String[] args) {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setDebugEnabled(true).
		setOAuthConsumerKey(BROWSER_CONSUMER_KEY).
		setOAuthConsumerSecret(BROWSER_CONSUMER_SECRET).
		setOAuthAccessToken(ACCESS_TOKEN).
		setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
		Twitter twitter = new TwitterFactory(builder.build()).getInstance();
		
        try {
            Map<String, RateLimitStatus> rateLimitStatus = twitter.getRateLimitStatus("search");
            RateLimitStatus searchTweetsRateLimit = rateLimitStatus.get("/search/tweets");
    		System.out.println(searchTweetsRateLimit);

    		User user = twitter.showUser("tapasroy");
    		System.out.println(user);
    		System.out.println("SSSSS");
    		PagableResponseList<User> ids = twitter.getFriendsList(user.getId(), -1);
    		System.out.println(ids);
    		for (User friend : ids) {
    			System.out.println(friend);
    		}
//            twitter.getAccountSettings();
        } 
        catch (TwitterException e) {
        	e.printStackTrace();
        }
	}
}
