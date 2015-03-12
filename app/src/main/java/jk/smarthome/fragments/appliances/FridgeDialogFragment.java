package jk.smarthome.fragments.appliances;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import jk.smarthome.R;

/**
 * Created by jacek on 11/03/15.
 */
public class FridgeDialogFragment extends DialogFragment {

    // newInstance constructor for creating fragment with arguments
    public static FridgeDialogFragment newInstance() {
        FridgeDialogFragment fragmentFirst = new FridgeDialogFragment();
        return fragmentFirst;
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.appliance_fridge_dialog_fragment, container, false);

        Button button = (Button) view.findViewById(R.id.enterButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getDialog().dismiss();

            }
        });

        return view;


    }

}
