package tommista.com.turbine.managers;

/**
 * Created by tbrown on 1/17/15.
 */
public class TweetManager {

    public static TweetManager instance;

    public static TweetManager getInstance(){
        if(instance == null){
            instance = new TweetManager();
        }
        return instance;
    }

    private TweetManager(){

    }
}
