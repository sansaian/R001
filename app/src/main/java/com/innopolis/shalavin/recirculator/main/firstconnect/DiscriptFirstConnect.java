package com.innopolis.shalavin.recirculator.main.firstconnect;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.innopolis.shalavin.recirculator.R;


public class DiscriptFirstConnect extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    Button startSerchButton;

    public DiscriptFirstConnect() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiscriptFirstConnect newInstance(String param1, String param2) {
        DiscriptFirstConnect fragment = new DiscriptFirstConnect();
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

        View v = inflater.inflate(R.layout.fragment_discription_first_connect, container, false);
        startSerchButton = (Button) v.findViewById(R.id.startSearchButton);
        startSerchButton.setOnClickListener(this);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

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
    public void onClick(View v) {
        Fragment findDeviceFragment = new FindDevice();
        FragmentTransaction fTransfirctConnect = getFragmentManager().beginTransaction();
        Bundle bundle = getArguments();
        if (bundle != null) {
            int  msg = bundle.getInt("ID_FRAME_ACTIVITY");
            try {
                Integer i1 = new Integer(msg);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("ID_FRAME_ACTIVITY", R.id.frgmCont);
                findDeviceFragment.setArguments(bundle);
                fTransfirctConnect.replace(i1, findDeviceFragment, "FindDeviceFragment");
            } catch (NumberFormatException e) {
                System.err.println("Неверный формат строки!");
            }
        } else {
            fTransfirctConnect.replace(R.id.frgmContFirstConnect, findDeviceFragment, "FindDeviceFragment");
        }
        fTransfirctConnect.commit();
    }
}
