package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ruoyang on 1/17/17.
 */

public class ImportTweet extends Tweet {
    public ImportTweet(Date date, String message) throws TweetToLong {
        super(date, message);
    }

    public ImportTweet(String message) throws TweetToLong {
        super(message);
    }


    public Boolean isImportant() {
        return Boolean.TRUE;
    }
    @Override
    public String getMessage() {
        return super.getMessage()+"!!!";
    }
}
