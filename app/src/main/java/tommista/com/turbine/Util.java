package tommista.com.turbine;

import retrofit.Callback;
import tommista.com.turbine.net.UnshortenResponse;
import tommista.com.turbine.net.services.ExtensionAPI;

/**
 * Created by tbrown on 1/17/15.
 */
public class Util {

    public static void unshortenUrl(String url, Callback<UnshortenResponse> callback){
        ExtensionAPI.getInstance().extensionService.unshortenURL(url, "HNYjhn3BQqffhw5qRMPrGjN6Vz6uHFOJ", "json", callback);
    }
}
