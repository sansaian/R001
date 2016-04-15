package com.innopolis.shalavin.recirculator.main.interface5;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.innopolis.shalavin.recirculator.R;

import java.util.Timer;
import java.util.TimerTask;


public class FragmentBasicInterface5 extends Fragment implements CompoundButton.OnCheckedChangeListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView textViewShowTemper;
    TextView textViewShowHumidity;
    ToggleButton onOffButton;
    TextView serverErrorText;
    //режим работы приложения
    String mode = "usually";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentBasicInterface5() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBasicInterface5.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBasicInterface5 newInstance(String param1, String param2) {
        FragmentBasicInterface5 fragment = new FragmentBasicInterface5();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_basic_interface5, container, false);
        textViewShowTemper = (TextView) v.findViewById(R.id.textShowTemper);
        textViewShowHumidity = (TextView) v.findViewById(R.id.textShowHumidity);
       // serverErrorText = (TextView) v.findViewById(R.id.serverErrorText);
        onOffButton = (ToggleButton) v.findViewById(R.id.onOffButton);
        onOffButton.setOnCheckedChangeListener(this);
        callAsynchronousTask();
        return v;
    }

    //Метод вызывающий ATupdateData по расписанию можно сделать паблик и передавать в атрибуты
    public void callAsynchronousTask() {

        //final String url = "http://46.101.254.17:8000/commands/info_1235_0002";
        final String url = "http://87.117.188.21:8000/commands/info_1235_0002";


        final Handler handler = new Handler();
        Timer timer = new Timer();

        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            ATupdateData atUpdateData = new ATupdateData(textViewShowHumidity,textViewShowTemper,onOffButton, url,serverErrorText);
                            atUpdateData.execute();
                        } catch (Exception e) {
                        }
                    }
                });
            }
        };
        timer.schedule(doAsynchronousTask, 0, 60000); //execute in every 1 минута=60000
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }




    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //возможно не стоит вызыать getActivity так как есть метод Attach
        String androidId = Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.ANDROID_ID);
        SendComand sendComand = new SendComand( androidId, textViewShowHumidity, textViewShowTemper,onOffButton,serverErrorText);
        sendComand.sendComandonServer();

    }
}

