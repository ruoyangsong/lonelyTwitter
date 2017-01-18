package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ruoyang on 1/17/17.
 */
public abstract class Tweet implements Tweetable{
    private Date date;
    private String message;
    //private String hiddenString;
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetToLong{
        if (message.length()>144){
            throw new TweetToLong();
        }
        else {
            this.message = message;
        }
        this.message = message;
    }
    public abstract Boolean isImportant();


    public Tweet(Date date, String message) throws TweetToLong{
        this.date = date;
        this.setMessage(message);
    }
    public Tweet(String message) throws TweetToLong{
        this.setMessage(message);
        this.date = new Date();
    }


}
