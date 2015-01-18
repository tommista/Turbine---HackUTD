package tommista.com.turbine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import timber.log.Timber;
import tommista.com.turbine.models.Tweet;

/**
 * Created by tbrown on 1/17/15.
 */
public class TweetAdapter extends ArrayAdapter<Tweet>{

    public TweetAdapter(Context context, int resource, List<Tweet> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        Tweet tweet = getItem(position);

        if(convertView == null){
            LayoutInflater inflator = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(R.layout.main_tweet, null);
        }


        Timber.i("Tweet screenName: %s", tweet.screenName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.main_image_view);
        TextView handleTextView = (TextView) convertView.findViewById(R.id.main_handle_text_view);
        TextView urlTextView = (TextView) convertView.findViewById(R.id.main_url_link);

        imageView.setImageResource(R.drawable.box);
        handleTextView.setText(tweet.screenName);
        urlTextView.setText(tweet.goodUrl);
        return convertView;
    }
}
