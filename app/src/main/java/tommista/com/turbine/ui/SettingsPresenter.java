package tommista.com.turbine.ui;

import android.content.Context;
import android.widget.ArrayAdapter;

import tommista.com.turbine.R;
import tommista.com.turbine.managers.HandleManager;

/**
 * Created by tbrown on 1/17/15.
 */
public class SettingsPresenter {

    private SettingsView settingsView;
    private Context context;




    public SettingsPresenter(Context context, SettingsView settingsView) {
        this.context = context;
        this.settingsView = settingsView;
  }
}
