package tommista.com.turbine.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import tommista.com.turbine.R;
import tommista.com.turbine.adapters.HandleAdapter;
import tommista.com.turbine.managers.HandleManager;

/**
 * Created by tbrown on 1/17/15.
 */
public class SettingsView extends LinearLayout {

    private SettingsPresenter presenter;
    private Context context;
    private HandleAdapter adapter;


    public SettingsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        presenter = new SettingsPresenter(context, this);
        adapter = new HandleAdapter(context, HandleManager.getInstance().getHandleList()) ;
        ListView listView = (ListView) this.findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }

}
