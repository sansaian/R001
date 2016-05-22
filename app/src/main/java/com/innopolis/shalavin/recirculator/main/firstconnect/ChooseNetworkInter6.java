package com.innopolis.shalavin.recirculator.main.firstconnect;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.innopolis.shalavin.recirculator.R;

public class ChooseNetworkInter6 extends ListFragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button connectNetworkButton;
    String[] names = { "Network1","Network2","Network3" };
    DialogChoiceNetwork dialogChoiceNetwork1;

    public ChooseNetworkInter6() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChooseNetworkInter6.
     */
    // TODO: Rename and change types and number of parameters
    public static ChooseNetworkInter6 newInstance(String param1, String param2) {
        ChooseNetworkInter6 fragment = new ChooseNetworkInter6();
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
        View v = inflater.inflate(R.layout.fragment_choose_network_inter6, container, false);
        connectNetworkButton= (Button) v.findViewById(R.id.connectNetworkButton);
        connectNetworkButton.setOnClickListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
        dialogChoiceNetwork1 = new DialogChoiceNetwork();

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

    public void onListItemClick(ListView l, View v, int position, long id) {
        dialogChoiceNetwork1.show(getActivity().getFragmentManager(),"sdad");



    }
    @Override
    public void onClick(View v) {
        Fragment finishInputDevice = new FinishInputDevice();
        FragmentTransaction fTransfirctConnect = getFragmentManager().beginTransaction();
        Bundle bundle = getArguments();
        if (bundle != null) {
            int  msg = bundle.getInt("ID_FRAME_ACTIVITY");
            try {
                Integer i1 = new Integer(msg);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("ID_FRAME_ACTIVITY", R.id.frgmCont);
                finishInputDevice.setArguments(bundle);
                fTransfirctConnect.replace(i1, finishInputDevice, "FindDeviceFragment");
            } catch (NumberFormatException e) {
                System.err.println("Неверный формат строки!");
            }
        } else {
            fTransfirctConnect.replace(R.id.frgmContFirstConnect, finishInputDevice, "FindDeviceFragment");
        }
        fTransfirctConnect.commit();

    }
}
