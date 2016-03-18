package com.innopolis.shalavin.recirculator.interface5;


import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by Maxim on 05.03.2016.
 */
public class SendComand {
    private TextView textViewShowHumidity;
    private TextView textViewShowTemper;
    private ToggleButton onOffButton;
    private String mode;
    private String androidId;
    private TextView serverErrorText;

    public SendComand(String andriodId, TextView textViewShowHumidity, TextView textViewShowTemper, ToggleButton onOffButton,TextView serverErrorText) {
        this.textViewShowHumidity = textViewShowHumidity;
        this.textViewShowTemper = textViewShowTemper;
        this.onOffButton = onOffButton;
        this.androidId = andriodId;
        this.serverErrorText = serverErrorText;
    }

   private String getURLString() {
        //получает состояния кнопки toggle
        String switchonof;
        String url = null;
        if (onOffButton.isChecked()) {
            switchonof = "on";
        } else {
            switchonof = "off";
        }

        //получает данные о работающем режиме

        //формирует URL

        // url = "https://46.101.254.17:8000/commands/switch_" + switchonof + "_1_"+this.androidId;
        url = "http://46.101.254.17:8000/commands/switch_" + switchonof + "_1235_0002";
        //Log.d("MyLog","Idandroid"+this.androidId);
        return url;
    }

    public void sendComandonServer()
    {
       ATupdateData atUpdateData = new ATupdateData(this.textViewShowHumidity,this.textViewShowTemper,this.onOffButton,getURLString(),serverErrorText);
        atUpdateData.execute();
    }

}

