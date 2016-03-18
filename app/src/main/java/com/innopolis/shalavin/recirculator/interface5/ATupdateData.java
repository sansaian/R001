package com.innopolis.shalavin.recirculator.interface5;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

//обновление данных с устройства
public class ATupdateData extends AsyncTask<Void, Void, String> {
    JSONObject dataJsonObj;
    private TextView textViewShowHumidity;
    private TextView serverErrorText;
    private TextView textViewShowTemper;
    private ToggleButton onOffButton;
    private int jsonhave = 0;
    private String urlString;
    String[] dataFromSensors = new String[4];

    public ATupdateData(TextView textViewShowHumidity, TextView textViewShowTemper, ToggleButton onOffButton, String urlString, TextView serverErrorText) {

        this.textViewShowHumidity = textViewShowHumidity;
        this.textViewShowTemper = textViewShowTemper;
        this.onOffButton = onOffButton;
        this.serverErrorText = serverErrorText;
        this.urlString = urlString;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        //даем знать что данные не загруженны
    }

    @Override
    protected String doInBackground(Void... params) {
        jsonhave = 0;
        //  dataJsonObj = getJsonObject();
        try {
            parsJson(getJsonObject());
        } catch (JSONException e) {
            Log.d("MyLog", "проблема распарсить JSON ");
            jsonhave = 2;
        }
        return "fhc";
    }

    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.d("MyLog", "jsonhave1 " + jsonhave);
        switch (jsonhave) {
            case 0: {
                textViewShowTemper.setText(dataFromSensors[0]);
                textViewShowHumidity.setText(dataFromSensors[1]);
                onOffButton.setChecked(Boolean.valueOf(dataFromSensors[2]));
                break;
            }
            case 1: {
                textViewShowTemper.setText("0");
                textViewShowHumidity.setText("0");
                //вывод сообщения
                //serverErrorText.setText("Ошибка1 подключения");
                //serverErrorText.setVisibility(View.VISIBLE);
                break;
            }
            case 2: {

                textViewShowTemper.setText("0");
                textViewShowHumidity.setText("0");
                //вывод сообщения
                // serverErrorText.setText("Ошибка2 на стороне сервера");
                //serverErrorText.setVisibility(View.VISIBLE);
                break;
            }
        }


    }

    //метод который коннектится к серваку и выдает json как JsonObject
    private JSONObject getJsonObject() {
        String resultJson = "";
        do {
            try {
                URL url = new URL(this.urlString);
                Log.d("MyLog", "адрес" + this.urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                resultJson = readInputStream(inputStream);
                Log.d("MyLog", "ответ сервера JSON " + resultJson);
                dataJsonObj = new JSONObject(resultJson);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                Log.d("MyLog", "проблемы с сервером");
                ///сообщить пользователю  том что проблемы с сервером
                // может стоит сделать определенное количество повторений потом сообщать что пиздец
                //проблема когда ушли в сон он не останавливается.
                sleep();
            }
        }
        while (resultJson.isEmpty());
        jsonhave = 0;
        return dataJsonObj;
    }

    //кладет в сон поток
    void sleep() {
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //считать поток вернуть
    private String readInputStream(InputStream inputStream) {
        String resultreadInputStream = "";
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultreadInputStream = buffer.toString();
        return resultreadInputStream;
    }

    private String[] parsJson(JSONObject dataJsonObj) throws JSONException {

        try {
            JSONArray events = dataJsonObj.getJSONArray("info");

            Log.d("MyLog", "not error in parsJson1 ");
            for (int i = 0; i < events.length(); i++) {
                JSONObject jsonEvent = events.getJSONObject(i);
                String co = "", co2 = "", onoff = "";
                Iterator<String> iter = jsonEvent.keys();
                while (iter.hasNext()) {
                    String key = iter.next();
                    switch (key) {
                        case "co2":
                            co2 = jsonEvent.getString("co2");
                            break;

                        case "co":
                            co = jsonEvent.getString("co");
                            break;
                        case "on":
                            onoff = jsonEvent.getString("on");
                            break;
                    }
                    dataFromSensors[0] = co2;
                    dataFromSensors[1] = co;
                    dataFromSensors[2] = onoff;
                    jsonhave = 0;
                }

            }
        } catch (Exception e) {
            jsonhave = 2;
            Log.d("MyLog", "ошибка не верный json ");
        }
        return dataFromSensors;
    }

}

