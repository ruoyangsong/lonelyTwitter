package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ruoyang on 1/17/17.
 */

public abstract class TweetDate {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public abstract Boolean isImportant();

    public TweetDate(Date date){
        this.setDate(date);
    }
}
