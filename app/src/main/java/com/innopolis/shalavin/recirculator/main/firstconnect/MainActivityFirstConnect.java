package com.innopolis.shalavin.recirculator.main.firstconnect;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.innopolis.shalavin.recirculator.R;

public class MainActivityFirstConnect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity_first_connect);
        Fragment fragmain = new DiscriptFirstConnect();
        FragmentTransaction fTransfirctConnect = getSupportFragmentManager().beginTransaction();
        fTransfirctConnect.replace(R.id.frgmContFirstConnect, fragmain, "DiscriptionFirstConnect");
        fTransfirctConnect.commit();
    }
}
