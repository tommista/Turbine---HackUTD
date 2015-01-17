package tommista.com.turbine.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by tbrown on 1/17/15.
 */
public class SettingsView extends LinearLayout {

    private SettingsPresenter presenter;


    public SettingsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        presenter = new SettingsPresenter(context, this);
    }


}
