package tommista.com.turbine;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;
import tommista.com.turbine.managers.HandleManager;
import tommista.com.turbine.managers.TweetManager;
import tommista.com.turbine.models.Handle;
import tommista.com.turbine.models.Tweet;
import tommista.com.turbine.net.TwitterAPI;
import tommista.com.turbine.net.UnshortenResponse;

/**
 * Created by tbrown on 1/17/15.
 */
public class DataFetcher {

    HandleManager handleManager;
    TweetManager tweetManager;
    MainActivity mainActivity;

    public DataFetcher(MainActivity mainActivity){
        handleManager = HandleManager.getInstance();
        tweetManager = TweetManager.getInstance();
        this.mainActivity = mainActivity;
    }

    public void refreshButtonPressed(){
        this.refresh();
    }

    private void refresh(){

        ArrayList<Handle> handleList = handleManager.getHandleList();
        for(Handle handle : handleList){
            getTweetsForHandle(handle);
        }

    }

    private void getTweetsForHandle(final Handle handle){
        TwitterAPI.getInstance().timelineServices.getUserTimeline(handle.getTwitterHandle(), 5, new Callback<List<Tweet>>() {
            @Override
            public void success(List<Tweet> list, Response response) {
                Timber.i("Successfully downloaded timeline for %s with %d tweets", handle.getTwitterHandle(), list.size());

                for(final Tweet tweet : list){

                    if(tweet.tweetEntities.urlList.length > 0){
                        String expandedURL = tweet.tweetEntities.urlList[0].expandedUrl;
                        if(expandedURL != null && expandedURL.length() > 0){
                            Timber.i("unexpanded url: " + expandedURL);

                            if(expandedURL.toLowerCase().contains("youtube") || expandedURL.toLowerCase().contains("spotify") || expandedURL.toLowerCase().contains("soundcloud")) {
                                if(!tweetManager.tweetExists(tweet)){
                                    Tweet newTweet = new Tweet(tweet);
                                    newTweet.screenName = handle.getTwitterHandle();
                                    newTweet.goodUrl = expandedURL;
                                    tweetManager.addTweet(newTweet);
                                    mainActivity.refresh();
                                    Timber.i("added new tweet");
                                }
                            }else{
                                Util.unshortenUrl(expandedURL, new Callback<UnshortenResponse>() {
                                    @Override
                                    public void success(UnshortenResponse unshortenResponse, Response response) {
                                        String url = unshortenResponse.fullUrl;
                                        Timber.i("successfully shortened url: " + url);

                                        if(url == null){
                                            return;
                                        }

                                        if(url.toLowerCase().contains("youtube") || url.toLowerCase().contains("spotify") || url.toLowerCase().contains("soundcloud")){
                                            if(!tweetManager.tweetExists(tweet)){

                                                Tweet newTweet = new Tweet(tweet);
                                                newTweet.screenName = handle.getTwitterHandle();
                                                newTweet.goodUrl = url;
                                                tweetManager.addTweet(newTweet);
                                                mainActivity.refresh();
                                                Timber.i("added new tweet");
                                            }
                                        }
                                    }

                                    @Override
                                    public void failure(RetrofitError error) {

                                    }
                                });
                            }


                        }else{
                            continue;
                        }
                    }

                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
