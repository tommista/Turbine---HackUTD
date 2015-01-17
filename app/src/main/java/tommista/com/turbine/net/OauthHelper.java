package tommista.com.turbine.net;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tbrown on 1/17/15.
 */
public class OauthHelper {

    @SerializedName("grant_type")
    public String grantType = "client_credentials";
}
