package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by ruoyang on 2/14/17.
 */

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    public void add(Tweet tweet){
        try {
            tweets.add(tweet);
        }catch (IllegalArgumentException e){
            Log.i("Error","Failed to add the tweets from the asynobject");
        }

    }
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }


    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);

    }

    public ArrayList gettweets(){
        return tweets;
    }
    public int getCount(){
        return tweets.size();
    }

}
