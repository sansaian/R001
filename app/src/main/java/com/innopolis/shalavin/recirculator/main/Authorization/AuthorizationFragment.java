package com.innopolis.shalavin.recirculator.main.Authorization;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.innopolis.shalavin.recirculator.R;
import com.innopolis.shalavin.recirculator.main.interface5.MainActivity;

public class AuthorizationFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button enterButton;
    Button registButton;

    public AuthorizationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AuthorizationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AuthorizationFragment newInstance(String param1, String param2) {
        AuthorizationFragment fragment = new AuthorizationFragment();
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
        View v = inflater.inflate(R.layout.authorization_fragment, container, false);
        enterButton = (Button) v.findViewById(R.id.enterButton);
        registButton = (Button) v.findViewById(R.id.registrButton);
        enterButton.setOnClickListener(this);
        registButton.setOnClickListener(this);
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
        /////////////////////////////////////////
        switch (v.getId()) {

            case R.id.enterButton:

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.registrButton:

                Fragment fragmentnReg = new RegistrationFragment();
                FragmentTransaction fTrans = getFragmentManager().beginTransaction();
                fTrans.replace(R.id.frgmContStart, fragmentnReg, "RegistrationFragment");
                fTrans.addToBackStack(null);
                fTrans.commit();
                break;
            default:
                break;
        }
        ////////////////////////////////////////
        //проверка ввода пароля и логина

    }


}
