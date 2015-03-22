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
public class OvenDialogFragment extends DialogFragment {

    public static OvenDialogFragment newInstance() {
        OvenDialogFragment fragmentFirst = new OvenDialogFragment();
        return fragmentFirst;
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.appliance_oven_dialog_fragment, container, false);

        Button confirmButton = (Button) view.findViewById(R.id.enterButton);

        final Spinner ovenSpinner = (Spinner) view.findViewById(R.id.ovenProgramSelectionSpinner);

        ((SmartHomeApplication)getActivity().getApplication()).getRoomList().get(2).getAppliances().remove("Oven");
        ((SmartHomeApplication)getActivity().getApplication()).getRoomList().get(2).getAppliances().put("Oven", null);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ovenSpinner.getSelectedItemPosition() == 0){
                    ((SmartHomeApplication)getActivity().getApplication()).getRoomList().get(2).getAppliances().remove("Oven");
                    ((SmartHomeApplication)getActivity().getApplication()).getRoomList().get(2).getAppliances().put("Oven", null);
                } else {
                    String state = (String)ovenSpinner.getSelectedItem();
                    //Toast.makeText(getActivity(), ""+state, Toast.LENGTH_SHORT).show();
                    ((SmartHomeApplication) getActivity().getApplication()).getRoomList().get(2).getAppliances().remove("Oven");
                    ((SmartHomeApplication)getActivity().getApplication()).getRoomList().get(2).getAppliances().put("Oven", state);
                }

                getDialog().dismiss();
            }
        });



        return view;


    }

}
