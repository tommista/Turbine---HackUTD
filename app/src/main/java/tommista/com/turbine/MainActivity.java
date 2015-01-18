package tommista.com.turbine;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import timber.log.Timber;


public class MainActivity extends ActionBarActivity {

    public static MainActivity instance;

    public static MainActivity getInstance(){
        return instance;
    }

    public DataFetcher dataFetcher;
    private int currentDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        instance = this;

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            // TODO eventually put remote logging into a tree and put here.
        }

        dataFetcher = new DataFetcher(this);
        dataFetcher.refreshButtonPressed();

        currentDisplay = 0;
        setContentView(R.layout.main_view);

    }

    public void refresh(){
        setContentView(R.layout.main_view);
    }

    public void resetSettings(){
        setContentView(R.layout.settings_view);
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
            currentDisplay = 1;
            setContentView(R.layout.settings_view);
            return true;
        }
        else if(id == R.id.action_refresh){
            Timber.i("refresh button hit");
            dataFetcher.refreshButtonPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        Timber.i("back button pressed");
        if(currentDisplay == 0){
            super.onBackPressed();
        }else if(currentDisplay == 1){
            currentDisplay = 0;
            setContentView(R.layout.main_view);
            dataFetcher.refreshButtonPressed();
        }
    }
}
