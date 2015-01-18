package tommista.com.turbine.net.services;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by tbrown on 1/17/15.
 */
public interface TimelineServices {

    @GET("/1.1/statuses/user_timeline.json")
    void getUserTimeline(@Query("screen_name") String screenName, @Query("count") int count, Callback<Response> callback);
}
