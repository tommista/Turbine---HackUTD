package tommista.com.turbine.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

import tommista.com.turbine.R;
import tommista.com.turbine.TweetAdapter;
import tommista.com.turbine.managers.TweetManager;
import tommista.com.turbine.models.Tweet;

/**
 * Created by tbrown on 1/17/15.
 */
public class MainView extends LinearLayout{

    public TweetManager tweetManager;
    public TweetAdapter tweetAdapter;
    public ListView listView;

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        tweetManager = TweetManager.getInstance();
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        List<Tweet> tweetList = tweetManager.getTweetList();
        tweetAdapter = new TweetAdapter(getContext(), R.layout.main_tweet, tweetList);
        listView = (ListView) this.findViewById(R.id.main_list_view);
        listView.setAdapter(tweetAdapter);

    }
}
