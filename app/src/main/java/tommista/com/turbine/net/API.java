package tommista.com.turbine.net;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import tommista.com.turbine.net.services.OauthService;

/**
 * Created by tbrown on 1/17/15.
 */
public class API {
    private static final String SERVER_ADDRESS = "https://api.twitter.com";
    private static API instance;
    private final RestAdapter restAdapter;
    private RequestInterceptor reqInterceptor;

    public OauthService oauthService;

    public Gson gson;

    public static API getInstance() {
        if (instance == null) {
            instance = new API();
        }
        return instance;
    }

    public API() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        reqInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade requestFacade) {
                requestFacade.addHeader("Authorization", "Basic Tk9yOXliM3V1TWcyakdFSlFuWTVzSjF0MDpuVGNqWVhMWFJ1UkwyY0U3ejlXMmRMWUxrakhaRlE3NFl0TVBDMnNIWUF3NXhSaHo2Rg==");
            }
        };

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(SERVER_ADDRESS)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(reqInterceptor)
                .build();

        oauthService = restAdapter.create(OauthService.class);
    }
}