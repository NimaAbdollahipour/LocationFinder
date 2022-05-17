package com.nima.loacationfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class Wifi4 extends AppCompatActivity {
    String ID;
    Wifi_C w1;
    Wifi_C w2;
    Wifi_C w3;
    Wifi_C w4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi4);
        ID=getIntent().getExtras().getString("ID");
    }
    public void Click(View v){
        if(v.getId()==R.id.Wifi4_save){
            if(((EditText)findViewById(R.id.Wifi4_SSID1)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi4_Y1)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi4_SSID2)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi4_SSID3)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi4_SSID4)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi4_X1)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi4_X2)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi4_X3)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi4_X4)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi4_Y2)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi4_Y3)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi4_Y4)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            } else if(((EditText)findViewById(R.id.Wifi4_Z1)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi4_Z2)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi4_Z3)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi4_Z4)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else {
                w1.SSID=((EditText)findViewById(R.id.Wifi4_SSID1)).getText().toString();
                w2.SSID=((EditText)findViewById(R.id.Wifi4_SSID2)).getText().toString();
                w3.SSID=((EditText)findViewById(R.id.Wifi4_SSID3)).getText().toString();
                w4.SSID=((EditText)findViewById(R.id.Wifi4_SSID4)).getText().toString();
                w1.x=Integer.parseInt(((EditText)findViewById(R.id.Wifi4_X1)).getText().toString());
                w2.x=Integer.parseInt(((EditText)findViewById(R.id.Wifi4_X2)).getText().toString());
                w3.x=Integer.parseInt(((EditText)findViewById(R.id.Wifi4_X3)).getText().toString());
                w4.x=Integer.parseInt(((EditText)findViewById(R.id.Wifi4_X4)).getText().toString());
                w1.y=Integer.parseInt(((EditText)findViewById(R.id.Wifi4_Y1)).getText().toString());
                w2.y=Integer.parseInt(((EditText)findViewById(R.id.Wifi4_Y2)).getText().toString());
                w3.y=Integer.parseInt(((EditText)findViewById(R.id.Wifi4_Y3)).getText().toString());
                w4.y=Integer.parseInt(((EditText)findViewById(R.id.Wifi4_Y4)).getText().toString());
                w1.z=Integer.parseInt(((EditText)findViewById(R.id.Wifi4_Z1)).getText().toString());
                w2.z=Integer.parseInt(((EditText)findViewById(R.id.Wifi4_Z2)).getText().toString());
                w3.z=Integer.parseInt(((EditText)findViewById(R.id.Wifi4_Z3)).getText().toString());
                w4.z=Integer.parseInt(((EditText)findViewById(R.id.Wifi4_Z4)).getText().toString());
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.openFileOutput("maps.txt", Context.MODE_APPEND));
                    outputStreamWriter.append(w1.toString()+w2.toString()+w3.toString()+w4.toString());
                    outputStreamWriter.close();
                }
                catch (IOException e) {
                }
                this.finish();
            }
        }
    }
}