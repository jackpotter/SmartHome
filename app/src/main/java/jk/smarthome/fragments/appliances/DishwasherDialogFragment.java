package jk.smarthome.fragments.appliances;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import jk.smarthome.R;
import jk.smarthome.SmartHomeApplication;

/**
 * Created by jacek on 11/03/15.
 */
public class DishwasherDialogFragment extends DialogFragment {

    public static DishwasherDialogFragment newInstance() {
        DishwasherDialogFragment fragmentFirst = new DishwasherDialogFragment();
        return fragmentFirst;
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.appliance_dishwasher_dialog_fragment, container, false);

        Button confirmButton = (Button) view.findViewById(R.id.enterButton);

        final Spinner dishwasherSpinner = (Spinner) view.findViewById(R.id.dishwasherProgramSelectionSpinner);

        ((SmartHomeApplication)getActivity().getApplication()).getRoomList().get(2).getAppliances().remove("Dishwasher");
        ((SmartHomeApplication)getActivity().getApplication()).getRoomList().get(2).getAppliances().put("Dishwasher", null);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dishwasherSpinner.getSelectedItemPosition() == 0){
                    ((SmartHomeApplication)getActivity().getApplication()).getRoomList().get(2).getAppliances().remove("Dishwasher");
                    ((SmartHomeApplication)getActivity().getApplication()).getRoomList().get(2).getAppliances().put("Dishwasher", null);
                } else {
                    String state = (String)dishwasherSpinner.getSelectedItem();
                    //Toast.makeText(getActivity(), "" + state, Toast.LENGTH_SHORT).show();
                    ((SmartHomeApplication) getActivity().getApplication()).getRoomList().get(2).getAppliances().remove("Dishwasher");
                    ((SmartHomeApplication)getActivity().getApplication()).getRoomList().get(2).getAppliances().put("Dishwasher", state);
                }

                getDialog().dismiss();
            }
        });



        return view;


    }

}
