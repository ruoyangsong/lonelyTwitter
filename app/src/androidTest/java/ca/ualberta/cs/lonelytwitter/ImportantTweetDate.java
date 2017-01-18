package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ruoyang on 1/17/17.
 */

public class ImportantTweetDate extends TweetDate {
    public ImportantTweetDate(Date date) {
        super(date);
    }
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
