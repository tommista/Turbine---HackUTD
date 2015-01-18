package tommista.com.turbine.net.services;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;

/**
 * Created by tbrown on 1/17/15.
*/
public class ExtensionAPI {

    private static final String SERVER_ADDRESS = "http://api.unshorten.it";
    private static ExtensionAPI instance;
    private final RestAdapter restAdapter;

    public ExtensionService extensionService;

    public Gson gson;

    public static ExtensionAPI getInstance() {
        if (instance == null) {
            instance = new ExtensionAPI();
        }
        return instance;
    }

    public ExtensionAPI() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(SERVER_ADDRESS)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        extensionService = restAdapter.create(ExtensionService.class);

    }
}
