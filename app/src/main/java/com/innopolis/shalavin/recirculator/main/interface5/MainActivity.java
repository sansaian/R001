package com.innopolis.shalavin.recirculator.main.interface5;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.innopolis.shalavin.recirculator.R;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String mode = "usually";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Fragment fragmain = new FragmentBasicInterface5();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frgmCont, fragmain, "MainFrame");
        ft.commit();
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            Log.d("Test", "Test");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //asdasdasd
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
        //    return true;
       // }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        TextView modes= (TextView) findViewById(R.id.textView2);
        int id = item.getItemId();

        if (id == R.id.nav_power) {
            Toast.makeText(getApplicationContext(), "Вы выбрали Режим Профилактика", Toast.LENGTH_SHORT).show();
            //TextView modes= (TextView) findViewById(R.id.textView2);
            modes.setText("Профилктика");
            // Handle the camera action
        } else if (id == R.id.nav_modules) {
            Toast.makeText(getApplicationContext(), "Вы выбрали Режим Дома есть больной", Toast.LENGTH_SHORT).show();
            modes.setText("Дома есть больной");
        } else if (id == R.id.nav_equipment) {
            Toast.makeText(getApplicationContext(), "Вы выбрали Режим Ждем гостей", Toast.LENGTH_SHORT).show();
            modes.setText("Ждем гостей");
        } else if (id == R.id.nav_statistic) {
            Toast.makeText(getApplicationContext(), "Вы выбрали Режим По расписанию", Toast.LENGTH_SHORT).show();
            modes.setText("По расписанию");
        } else if (id == R.id.nav_settings) {
            Toast.makeText(getApplicationContext(), "Вы выбрали Режим Включен всегда", Toast.LENGTH_SHORT).show();
            modes.setText("Включен всегда");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

