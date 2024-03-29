package tommista.com.turbine.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import tommista.com.turbine.MainActivity;
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
                String name = eText.getText().toString();
                if (name.isEmpty()) return;
                if(!name.startsWith("@")){
                    name = "@" + name;
                }
                HandleManager.getInstance().addHandle(name);
                MainActivity.getInstance().resetSettings();
                hideInputMethod(v);
            }
        });
        listView.setAdapter(adapter);
    }
    private void hideInputMethod(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null && view != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }



}
