package com.lab126.alexa;

import java.util.Map;

import twitter4j.RateLimitStatus;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;

public class TweetRadioMain {

	private static final String		BROWSER_CONSUMER_KEY = "OZW4OY9esxNcijm22G5yI2XxC";
	private static final String		BROWSER_CONSUMER_SECRET = "ZOHWyN95vsG7WTjJbRLYoL3Q3ooM3Uq5WvxweWGke6D7xqr2Pd";
	
	
	public static void main(String[] args) {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setApplicationOnlyAuthEnabled(true);
		
		Twitter twitter = new TwitterFactory(builder.build()).getInstance();
		
        try {
    		twitter.setOAuthConsumer(BROWSER_CONSUMER_KEY, BROWSER_CONSUMER_SECRET);
            OAuth2Token token = twitter.getOAuth2Token();

            Map<String, RateLimitStatus> rateLimitStatus = twitter.getRateLimitStatus("search");
            RateLimitStatus searchTweetsRateLimit = rateLimitStatus.get("/search/tweets");
    		System.out.println(searchTweetsRateLimit);

//            twitter.getAccountSettings();
        } 
        catch (TwitterException e) {
        	e.printStackTrace();
        }
		System.out.println(twitter);
	}
}
