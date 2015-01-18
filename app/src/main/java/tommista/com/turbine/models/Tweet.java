package tommista.com.turbine.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tbrown on 1/17/15.
 */
public class Tweet {

    public Tweet(Tweet tweet){
        this.tweetId = tweet.tweetId;
        this.tweetText = tweet.tweetText;
        this.user = tweet.user;
        this.screenName = tweet.screenName;
        this.tweetEntities = tweet.tweetEntities;
        this.goodUrl = tweet.goodUrl;
        this.createdAt = tweet.createdAt;
    }

    public String goodUrl;

    @SerializedName("created_at")
    public String createdAt;

    @SerializedName("id_str")
    public String tweetId;

    @SerializedName("text")
    public String tweetText;

    @SerializedName("user")
    public User user;

    @SerializedName("entities")
    public TweetEntities tweetEntities;

    @SerializedName("screen_name")
    public String screenName;

    @Override
    public String toString(){
        return tweetEntities.urlList[0].expandedUrl;
    }

}
