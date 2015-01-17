package tommista.com.turbine.models;

/**
 * Created by tbrown on 1/17/15.
 */
public class Handle {
    private String twitterHandle;

    public Handle(String twitterHandle){
        this.twitterHandle = twitterHandle;
    }

    public String getTwitterHandle()
    {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle){
        this.twitterHandle = twitterHandle;
    }
}
