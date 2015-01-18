package tommista.com.turbine.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tbrown on 1/17/15.
 */
public class Tweet {

    @SerializedName("id_str")
    String tweetId;

    @SerializedName("text")
    String tweetText;

    @SerializedName("profile_image_url")
    String profileImageURL;

    @SerializedName("entities")
    TweetEntities tweetEntities;

    @Override
    public String toString(){
        return tweetEntities.urlList[0].expandedUrl;
    }

}
