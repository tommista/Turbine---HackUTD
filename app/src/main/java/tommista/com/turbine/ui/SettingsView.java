package tommista.com.turbine.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import timber.log.Timber;
import tommista.com.turbine.R;
import tommista.com.turbine.adapters.HandleAdapter;
import tommista.com.turbine.managers.HandleManager;
import tommista.com.turbine.models.Handle;

/**
 * Created by tbrown on 1/17/15.
 */
public class SettingsView extends LinearLayout {

    private SettingsPresenter presenter;
    private Context context;
    private HandleAdapter adapter;
    private Button addButton;
    private EditText eText;


    public SettingsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        presenter = new SettingsPresenter(context, this);
        adapter = new HandleAdapter(context, HandleManager.getInstance().getHandleList()) ;
        final ListView listView = (ListView) this.findViewById(R.id.listview);


        addButton = (Button) this.findViewById(R.id.add_button);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eText = (EditText) findViewById(R.id.edit_text);



                if(eText.getText() == null){

                }else{
                Handle handle = new Handle(eText.getText().toString());
                HandleManager.getInstance().addHandle(handle);
                    adapter.add(handle);
                    listView.deferNotifyDataSetChanged();
                }


            }
        });






        listView.setAdapter(adapter);
    }

}
