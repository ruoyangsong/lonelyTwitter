package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ruoyang on 1/17/17.
 */

public class NormalTweetDate extends TweetDate{
    public NormalTweetDate(Date date) {
        super(date);
    }
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
