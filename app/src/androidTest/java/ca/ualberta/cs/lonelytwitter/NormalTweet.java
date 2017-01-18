package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ruoyang on 1/17/17.
 */

public class NormalTweet extends Tweet {
    public NormalTweet(Date date, String message) throws TweetToLong {
        super(date, message);
    }

    public NormalTweet(String message) throws TweetToLong {
        super(message);
    }
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
