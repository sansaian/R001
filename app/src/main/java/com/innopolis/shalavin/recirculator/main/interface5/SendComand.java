package com.innopolis.shalavin.recirculator.main.interface5;


import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by Maxim on 05.03.2016.
 */
public class SendComand {
    private TextView textViewShowHumidity;
    private TextView textViewShowCO;
    private TextView textViewShowCO2;
    private TextView textViewPressure;
    private TextView textViewShowTemper;
    private ToggleButton onOffButton;
    private String mode;
    private String androidId;
    private TextView serverErrorText;

    public SendComand(String andriodId,TextView textViewShowHumidity, TextView textViewShowTemper, ToggleButton onOffButton, TextView textViewShowCO, TextView textViewShowCO2, TextView textViewPressure) {
        this.textViewShowCO = textViewShowCO;
        this.textViewShowCO2 = textViewShowCO2;
        this.textViewPressure = textViewPressure;
        this.textViewShowTemper = textViewShowTemper;
        this.textViewShowHumidity = textViewShowHumidity;
        this.onOffButton = onOffButton;
        this.androidId = andriodId;
        this.serverErrorText = serverErrorText;
    }

   private String getURLString() {
        //получает состояния кнопки toggle
        String switchonof;
        String url = null;
        if (onOffButton.isChecked()) {
            switchonof = "1";
        } else {
            switchonof = "0";
        }

        //формирует URL

        url = "https://doctorair.tk/commands/account_request_12QfBKI5wQ_{\"on\":"+switchonof+",\"mode\":1,\"mode_param\":\"\"}";
        //url = "http://87.117.188.21/commands/switch_" + switchonof + "_1235_0002";
        //Log.d("MyLog","Idandroid"+this.androidId);
        return url;
    }

    public void sendComandonServer()
    {
       ATupdateData atUpdateData = new ATupdateData(this.textViewShowHumidity,this.textViewShowTemper,this.onOffButton,getURLString(),this.textViewShowCO,this.textViewShowCO2,this.textViewPressure);
        atUpdateData.execute();
    }

}

