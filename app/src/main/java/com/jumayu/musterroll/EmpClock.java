package com.jumayu.musterroll;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EmpClock extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.emp_clock, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        View v = getView();
        final Button clockBtn = v.findViewById(R.id.clock_btn);
        final TextView refreshBtn = v.findViewById(R.id.refloc_btn);
        final TextView geofenceBtn = v.findViewById(R.id.geofence_btn);
        clockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fingervoice()).commit();
                if(clockBtn.getText().toString()=="Clock In") clockBtn.setText("Clock Out");
                if(clockBtn.getText().toString()=="Clock Out") clockBtn.setText("Clock In");
            }
        });
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("geofence", "" + geofenceBtn.getText().toString());
                if(geofenceBtn.getText().toString()=="Outside Geo-Fence") {
                    geofenceBtn.setText("Inside Geo-Fence");
                    geofenceBtn.setBackgroundColor(Color.GREEN);
                }
                if(geofenceBtn.getText().toString()=="Inside Geo-Fence") {
                    geofenceBtn.setText("Outside Geo-Fence");
                    geofenceBtn.setBackgroundColor(Color.RED);
                }
            }
        });
        super.onActivityCreated(savedInstanceState);
    }
}
