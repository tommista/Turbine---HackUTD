package tommista.com.turbine.net;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import tommista.com.turbine.net.services.OauthService;
import tommista.com.turbine.net.services.TimelineServices;

/**
 * Created by tbrown on 1/17/15.
 */
public class TwitterAPI {
    private static final String SERVER_ADDRESS = "https://api.twitter.com";
    private static TwitterAPI instance;
    private final RestAdapter restAdapter;
    private RequestInterceptor reqInterceptor;

    public OauthService oauthService;
    public TimelineServices timelineServices;

    public Gson gson;

    public static TwitterAPI getInstance() {
        if (instance == null) {
            instance = new TwitterAPI();
        }
        return instance;
    }

    public TwitterAPI() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        reqInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade requestFacade) {
                requestFacade.addHeader("Authorization", "Bearer AAAAAAAAAAAAAAAAAAAAALXqdgAAAAAAMfVikYHyimgiQKPW9bqJGndfngk%3Dad7RyM7WUMG5knJcMm7PKICeoOLOfvORmqBZUlvvTVV6J3FI81");
                //requestFacade.addHeader("Authorization", "Basic Tk9yOXliM3V1TWcyakdFSlFuWTVzSjF0MDpuVGNqWVhMWFJ1UkwyY0U3ejlXMmRMWUxrakhaRlE3NFl0TVBDMnNIWUF3NXhSaHo2Rg==");
            }
        };

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(SERVER_ADDRESS)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(reqInterceptor)
                .build();

        oauthService = restAdapter.create(OauthService.class);
        timelineServices = restAdapter.create(TimelineServices.class);
    }
}