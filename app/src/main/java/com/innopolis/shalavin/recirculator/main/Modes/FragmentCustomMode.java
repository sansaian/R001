package com.innopolis.shalavin.recirculator.main.Modes;

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
import com.innopolis.shalavin.recirculator.main.interface5.FragmentBasicInterface5;


public class FragmentCustomMode extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
Button buttonAccept;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public FragmentCustomMode() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCustomMode.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCustomMode newInstance(String param1, String param2) {
        FragmentCustomMode fragment = new FragmentCustomMode();
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
        View v = inflater.inflate(R.layout.fragment_fragment_custom_mode, container, false);
        buttonAccept= (Button) v.findViewById(R.id.buttonAccept);
        buttonAccept.setOnClickListener(this);
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
        Bundle bundle = new Bundle();
        Fragment fragmentBasicInterface5 = new FragmentBasicInterface5();
        bundle.putString("ID_FRAME_ACTIVITY", "nav_statistic");
        fragmentBasicInterface5.setArguments(bundle);
        FragmentTransaction fTransfirctConnect = getFragmentManager().beginTransaction();
        fTransfirctConnect.replace(R.id.frgmCont , fragmentBasicInterface5, "asdasdad");
        fTransfirctConnect.commit();
    }
}
