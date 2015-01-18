package tommista.com.turbine.managers;

import java.util.ArrayList;
import java.util.HashMap;

import tommista.com.turbine.models.Tweet;

/**
 * Created by tbrown on 1/17/15.
 */
public class TweetManager {

    public static TweetManager instance;
    public HashMap<String, Tweet> tweetMap;

    public static TweetManager getInstance(){
        if(instance == null){
            instance = new TweetManager();
        }
        return instance;
    }

    private TweetManager(){
        tweetMap = new HashMap<String, Tweet>();
    }

    public void addTweet(Tweet tweet){
        tweetMap.put(tweet.tweetId, tweet);
    }

    public boolean tweetExists(Tweet tweet){
        return (tweetMap.get(tweet.tweetId) != null);
    }

    public ArrayList<Tweet> getTweetList(){
        return new ArrayList<Tweet>(tweetMap.values());
    }
}
