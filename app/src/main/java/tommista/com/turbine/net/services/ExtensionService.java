package tommista.com.turbine.net.services;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import tommista.com.turbine.net.UnshortenResponse;

/**
 * Created by tbrown on 1/17/15.
 */
public interface ExtensionService {
    @GET("/")
    void unshortenURL(@Query("shortURL") String shortURL, @Query("apiKey") String apiKey, @Query("responseFormat") String responseFormat, Callback<UnshortenResponse> callback);
}
