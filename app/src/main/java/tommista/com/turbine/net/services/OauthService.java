package tommista.com.turbine.net.services;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
import tommista.com.turbine.net.OauthHelper;

/**
 * Created by tbrown on 1/17/15.
 */
public interface OauthService {

    @Headers("Content-Type: application/x-www-form-urlencoded;charset=UTF-8")
    @POST("/oauth2/token")
    void getOauthToken(@Body OauthHelper helper, Callback<Response> callback);
}
