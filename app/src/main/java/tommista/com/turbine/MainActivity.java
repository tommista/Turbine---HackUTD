package tommista.com.turbine;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;
import tommista.com.turbine.models.Tweet;
import tommista.com.turbine.net.TwitterAPI;
import tommista.com.turbine.net.UnshortenResponse;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            // TODO eventually put remote logging into a tree and put here.
        }

        Timber.i("asdf");
        TwitterAPI twitterApi = TwitterAPI.getInstance();

        twitterApi.timelineServices.getUserTimeline("@thomasbrown333", 1, new Callback<List<Tweet>>() {
            @Override
            public void success(List<Tweet> list, Response response) {
                Timber.i("success %d", list.size());
                Timber.i("asdf " + list.get(0).toString());
                String tempStr = list.get(0).toString();

                Util.unshortenUrl(tempStr, new Callback<UnshortenResponse>() {
                    @Override
                    public void success(UnshortenResponse unshortenResponse, Response response2) {
                        Timber.i("unshorten success: " + unshortenResponse.fullUrl);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Timber.i("unshorten failure");
                        Timber.i(error.toString());
                    }
                });

            }

            @Override
            public void failure(RetrofitError error) {
                Timber.i("unfortunate failure");
                Timber.i(error.toString());
            }
        });

        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Timber.i("action button hit");
            setContentView(R.layout.settings_view);
            return true;
        }
        else if(id == R.id.action_refresh){
            Timber.i("refresh button hit");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
