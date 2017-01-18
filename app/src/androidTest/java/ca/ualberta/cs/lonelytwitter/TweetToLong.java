package ca.ualberta.cs.lonelytwitter;

/**
 * Created by ruoyang on 1/17/17.
 */

public class TweetToLong extends Exception{
    public TweetToLong(String detailMessage) {
        super(detailMessage);
    }

    public TweetToLong() {
    }
}
