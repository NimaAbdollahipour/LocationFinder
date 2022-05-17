package com.nima.loacationfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class Wifi3 extends AppCompatActivity {
    String ID;
    Wifi_C w1=new Wifi_C();
    Wifi_C w2=new Wifi_C();
    Wifi_C w3=new Wifi_C();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi3);
        ID=getIntent().getExtras().getString("ID");
    }
    public void Click(View v){
        if(v.getId()==R.id.wifi3_next){
            if(((EditText)findViewById(R.id.Wifi3_SSID1)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi3_Y1)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi3_SSID2)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi3_SSID3)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi3_X1)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi3_X2)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi3_X3)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi3_Y2)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else if(((EditText)findViewById(R.id.Wifi3_Y3)).getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else {
                w1.SSID=((EditText)findViewById(R.id.Wifi3_SSID1)).getText().toString();
                w2.SSID=((EditText)findViewById(R.id.Wifi3_SSID2)).getText().toString();
                w3.SSID=((EditText)findViewById(R.id.Wifi3_SSID3)).getText().toString();
                w1.x=Integer.parseInt(((EditText)findViewById(R.id.Wifi3_X1)).getText().toString());
                w2.x=Integer.parseInt(((EditText)findViewById(R.id.Wifi3_X2)).getText().toString());
                w3.x=Integer.parseInt(((EditText)findViewById(R.id.Wifi3_X3)).getText().toString());
                w1.y=Integer.parseInt(((EditText)findViewById(R.id.Wifi3_Y1)).getText().toString());
                w2.y=Integer.parseInt(((EditText)findViewById(R.id.Wifi3_Y2)).getText().toString());
                w3.y=Integer.parseInt(((EditText)findViewById(R.id.Wifi3_Y3)).getText().toString());
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.openFileOutput("map2.txt", Context.MODE_PRIVATE));
                    Wifi_C w=new Wifi_C();
                    w.SSID="nothing";
                    outputStreamWriter.write(w1.toString()+w2.toString()+w3.toString()+w.toString());
                    outputStreamWriter.close();
                }
                catch (IOException e) {
                }
                this.finish();
            }
        }
    }
}