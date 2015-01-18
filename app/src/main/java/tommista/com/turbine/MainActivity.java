package tommista.com.turbine;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;
import tommista.com.turbine.net.API;


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
        API api = API.getInstance();

        api.timelineServices.getUserTimeline("@MisterWives", 5, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                Timber.i("success");
            }

            @Override
            public void failure(RetrofitError error) {
                Timber.i("unfortunate failure");
            }
        });

        /*api.oauthService.getOauthToken(new OauthHelper(), new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                Timber.i("success");
            }

            @Override
            public void failure(RetrofitError error) {
                Timber.i("tragic failure");
                Timber.i(error.toString());
            }
        });*/


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

        return super.onOptionsItemSelected(item);
    }
}
