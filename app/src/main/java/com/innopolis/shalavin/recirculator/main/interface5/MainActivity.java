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
import com.innopolis.shalavin.recirculator.main.Modes.DialogForGuestModes;
import com.innopolis.shalavin.recirculator.main.Modes.DiologForChooseAmountRecirculator;
import com.innopolis.shalavin.recirculator.main.Modes.FragmentCustomMode;
import com.innopolis.shalavin.recirculator.main.Settings.FragmentChangeLocation;
import com.innopolis.shalavin.recirculator.main.Settings.FragmentNotification;
import com.innopolis.shalavin.recirculator.main.Settings.FragmentPersonalInformation;
import com.innopolis.shalavin.recirculator.main.Settings.Support.FragmentDialogSupportDevice;
import com.innopolis.shalavin.recirculator.main.Settings.Support.FragmentSupportDeviceAuto;
import com.innopolis.shalavin.recirculator.main.Settings.Support.FragmentSupportDeviceCustom;
import com.innopolis.shalavin.recirculator.main.firstconnect.DiscriptFirstConnect;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment fragmain = new FragmentBasicInterface5();
    // FragmentTransaction ft;
    DialogForGuestModes dialogForGuestModes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frgmCont, fragmain, "MainFrame");
        ft.commit();
       // setSupportActionBar(toolbar);
      //  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
  //              this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.setDrawerListener(toggle);
        //toggle.syncState();
      //  NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
      //  navigationView.setNavigationItemSelectedListener(this);
        dialogForGuestModes = new DialogForGuestModes();
    }

    @Override
    public void onBackPressed() {
      //  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
     //   if (drawer.isDrawerOpen(GravityCompat.START)) {
      //      drawer.closeDrawer(GravityCompat.START);
     //   } else {
            super.onBackPressed();
    //        Log.d("Test", "Test");
    //    }
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
        Log.d("MyLog", "id selected item" + id);
        //noinspection SimplifiableIfStatement
        // if (id == R.id.action_settings) {
        //    return true;
        // }

        return super.onOptionsItemSelected(item);
    }

    //method which call when dialog close
    public void openFragmentSupport(int checkedRadiobutton) {
        Log.d("MyLog", "radiogroup in MainActivity " + checkedRadiobutton);
        Fragment fragment;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (checkedRadiobutton == 2131493019) {
            fragment = new FragmentSupportDeviceCustom();
            ft.replace(R.id.frgmCont, fragment, "2222");
        } else if (checkedRadiobutton == 2131493020) {
            fragment = new FragmentSupportDeviceAuto();
            ft.replace(R.id.frgmCont, fragment, "2222");
        }
        ft.commit();
    }

    public void openFragmentModes(String modes) {
        Bundle bundle = new Bundle();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (modes) {
            case "nav_power":

                bundle.putString("ID_FRAME_ACTIVITY", "nav_power");
                fragmain.setArguments(bundle);
                ft.replace(R.id.frgmCont, fragmain, "mode practice");
                ft.commit();
                break;
            case "nav_modules":

                bundle.putString("ID_FRAME_ACTIVITY", "nav_modules");
                fragmain.setArguments(bundle);
                ft.replace(R.id.frgmCont, fragmain, "person is sick");
                ft.commit();
                break;
            case "nav_equipment":

                bundle.putString("ID_FRAME_ACTIVITY", "nav_equipment");
                fragmain.setArguments(bundle);
                ft.replace(R.id.frgmCont, fragmain, "meet with friends");
                ft.commit();
                break;
            case "nav_settings":

                bundle.putString("ID_FRAME_ACTIVITY", "nav_settings");
                fragmain.setArguments(bundle);
                ft.replace(R.id.frgmCont, fragmain, "work all time");
                ft.commit();
                break;
            case "smart":

                bundle.putString("ID_FRAME_ACTIVITY", "smart");
                fragmain.setArguments(bundle);
                ft.replace(R.id.frgmCont, fragmain, "smart");
                ft.commit();
                break;
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        TextView modes = (TextView) findViewById(R.id.textView2);
        int id = item.getItemId();
        Bundle bundle = new Bundle();
        DiologForChooseAmountRecirculator fragmentdialog = new DiologForChooseAmountRecirculator();
        if (id == R.id.nav_power) {
            //DiologForChooseAmountRecirculator fragmentdialog = new DiologForChooseAmountRecirculator();
            if (modes == null) {
                bundle.putString("ID_FRAME_ACTIVITY", "nav_power");
                fragmentdialog.setArguments(bundle);
            } else {
                modes.setText("Профилктика");
                Toast.makeText(getApplicationContext(), "Вы выбрали Режим Профилактика", Toast.LENGTH_SHORT).show();
            }
            fragmentdialog.show(getFragmentManager(), "profilactic");
            // Handle the camera action
        } else if (id == R.id.nav_modules) {
            if (modes == null) {
                bundle.putString("ID_FRAME_ACTIVITY", "nav_modules");
                fragmentdialog.setArguments(bundle);
            } else {

                modes.setText("Дома есть больной");
                Toast.makeText(getApplicationContext(), "Вы выбрали Режим Дома есть больной", Toast.LENGTH_SHORT).show();
            }
            fragmentdialog.show(getFragmentManager(), "person is sick");

        } else if (id == R.id.nav_equipment) {
            if (modes == null) {
                bundle.putString("ID_FRAME_ACTIVITY", "nav_equipment");
                fragmentdialog.setArguments(bundle);
            } else {
                modes.setText("Ждем гостей");
                Toast.makeText(getApplicationContext(), "Вы выбрали Режим Ждем гостей", Toast.LENGTH_SHORT).show();
            }
            fragmentdialog.show(getFragmentManager(), "meet with friends");

        } else if (id == R.id.nav_statistic) {
            fragment = new FragmentCustomMode();
            ft.replace(R.id.frgmCont, fragment, "schedule");
            ft.commit();

        } else if (id == R.id.nav_settings) {
            if (modes == null) {
                bundle.putString("ID_FRAME_ACTIVITY", "nav_settings");
                fragmentdialog.setArguments(bundle);
            } else {
                Toast.makeText(getApplicationContext(), "Вы выбрали Режим Включен всегда", Toast.LENGTH_SHORT).show();
                modes.setText("Включен всегда");
            }
            fragmentdialog.show(getFragmentManager(), "work all time");

        } else if (id == R.id.smart) {
            if (modes == null) {
                bundle.putString("ID_FRAME_ACTIVITY", "smart");
                fragmentdialog.setArguments(bundle);
            } else {
                Toast.makeText(getApplicationContext(), "Вы выбрали Режим Интелектуальный", Toast.LENGTH_SHORT).show();
                modes.setText("Интелектуальный");
            }
            fragmentdialog.show(getFragmentManager(), "smart");

        } else if (id == R.id.holydays) {
            Toast.makeText(getApplicationContext(), "Вы выбрали Режим В отпуске", Toast.LENGTH_SHORT).show();
            dialogForGuestModes.show(getFragmentManager(), "sdad");
            modes.setText("В отпуске");

        } else if (id == R.id.nav_notification) {
            fragment = new FragmentNotification();
            ft.replace(R.id.frgmCont, fragment, "1111");
            ft.commit();
        } else if (id == R.id.nav_location) {
            fragment = new FragmentChangeLocation();
            ft.replace(R.id.frgmCont, fragment, "2222");
            ft.commit();
        } else if (id == R.id.nav_newconnect) {
            fragment = new DiscriptFirstConnect();
            bundle.putInt("ID_FRAME_ACTIVITY", R.id.frgmCont);
            fragment.setArguments(bundle);
            ft.replace(R.id.frgmCont, fragment, "33333");
            ft.commit();
        } else if (id == R.id.service) {
            FragmentDialogSupportDevice fragmentDialogSupportDevice = new FragmentDialogSupportDevice();
            fragmentDialogSupportDevice.show(this.getFragmentManager(), "sdad");

        } else if (id == R.id.personal_data) {
            fragment = new FragmentPersonalInformation();
            ft.replace(R.id.frgmCont, fragment, "34323");
            ft.commit();
        }
      //  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
      //  drawer.closeDrawer(GravityCompat.START);


        return true;
    }
}

