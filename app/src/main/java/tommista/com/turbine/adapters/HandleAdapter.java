package tommista.com.turbine.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import timber.log.Timber;
import tommista.com.turbine.R;
import tommista.com.turbine.managers.HandleManager;
import tommista.com.turbine.models.Handle;

/**
 * Created by JoshBeridon on 1/17/15.
 */


public class HandleAdapter extends ArrayAdapter<Handle>{

    private Button delButton;
    private LinearLayout parentLayout;
    public HandleAdapter(Context context, ArrayList<Handle> handles) {
        super(context, R.layout.handle_view , handles);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Handle handle = getItem(position);
        Timber.i("position=%d,handle=%s", position, handle.getTwitterHandle());
        /*if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.handle_view, parent, false);
        }
        */
        delButton = (Button) convertView.findViewById(R.id.del_button);

        View view;
        if(convertView == null){
            LayoutInflater inflator = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(R.layout.handle_view, null);
        }

        final View.OnClickListener delButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parentLayout = (LinearLayout)delButton.getParent();
                // need to delete the handle below so I think I need the child info?
                HandleManager.getInstance().deleteHandle(handle);//


            }
        };



        delButton.setOnClickListener(delButtonListener);

        TextView handle_text= (TextView) convertView.findViewById(R.id.handle_text);
        handle_text.setText(handle.getTwitterHandle());
        return convertView;
    }

}
