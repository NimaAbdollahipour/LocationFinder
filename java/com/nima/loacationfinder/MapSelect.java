package com.nima.loacationfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MapSelect extends AppCompatActivity {
    Map[]map;
    int nop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nop = getIntent().getExtras().getInt("nop");
        map=new Map[nop];
        FileInputStream fis = null;
        try {
            fis = this.openFileInput("maps.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bufferedReader = new BufferedReader(isr);
        try {
            bufferedReader.readLine();
            for(int i=0;i<nop;i++){
                map[i]=new Map();
                map[i].ID=bufferedReader.readLine();
                map[i].nof=Integer.parseInt(bufferedReader.readLine());
                map[i].x=Integer.parseInt(bufferedReader.readLine());
                map[i].y=Integer.parseInt(bufferedReader.readLine());
                map[i].h=Integer.parseInt(bufferedReader.readLine());
                if(map[i].nof>1) {
                    for (int j = 0; j < 4; j++) {
                        map[i].w[j] = new Wifi_C();
                        map[i].w[j].SSID = bufferedReader.readLine();
                        map[i].w[j].x = Integer.parseInt(bufferedReader.readLine());
                        map[i].w[j].y = Integer.parseInt(bufferedReader.readLine());
                        map[i].w[j].z = Integer.parseInt(bufferedReader.readLine());
                    }
                }else
                    for (int j = 0; j < 3; j++) {
                    map[i].w[j] = new Wifi_C();
                    map[i].w[j].SSID = bufferedReader.readLine();
                    map[i].w[j].x = Integer.parseInt(bufferedReader.readLine());
                    map[i].w[j].y = Integer.parseInt(bufferedReader.readLine());
                    map[i].w[j].z = Integer.parseInt(bufferedReader.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//    public void Click(View v){
//        int a=0;
//        if(v.getId()==R.id.button3){
//            a=1;
//            Intent intent=new Intent(MapSelect.this,LocationView.class);
//            intent.putExtra("Selected",a);
//            startActivity(intent);
//        }
//        if(v.getId()==R.id.button3){
//            a=2;
//            Intent intent=new Intent(MapSelect.this,LocationView.class);
//            intent.putExtra("Selected",a);
//            startActivity(intent);
//        }
//        if(v.getId()==R.id.button3){
//            a=3;
//            Intent intent=new Intent(MapSelect.this,LocationView.class);
//            intent.putExtra("Selected",a);
//            startActivity(intent);
//        }
//        if(v.getId()==R.id.button3){
//            a=4;
//            Intent intent=new Intent(MapSelect.this,LocationView.class);
//            intent.putExtra("Selected",a);
//            startActivity(intent);
//        }
//        if(v.getId()==R.id.button3){
//            a=5;
//            Intent intent=new Intent(MapSelect.this,LocationView.class);
//            intent.putExtra("Selected",a);
//            startActivity(intent);
//        }
//        if(v.getId()==R.id.button3){
//            a=6;
//            Intent intent=new Intent(MapSelect.this,LocationView.class);
//            intent.putExtra("Selected",a);
//            startActivity(intent);
//        }
//        if(v.getId()==R.id.button3){
//            a=7;
//            Intent intent=new Intent(MapSelect.this,LocationView.class);
//            intent.putExtra("Selected",a);
//            startActivity(intent);
//        }
//        if(v.getId()==R.id.button3){
//            a=8;
//            Intent intent=new Intent(MapSelect.this,LocationView.class);
//            intent.putExtra("Selected",a);
//            startActivity(intent);
//        }
//        if(v.getId()==R.id.button3){
//            a=9;
//            Intent intent=new Intent(MapSelect.this,LocationView.class);
//            intent.putExtra("Selected",a);
//            startActivity(intent);
//        }
//        if(v.getId()==R.id.button3){
//            a=10;
//            Intent intent=new Intent(MapSelect.this,LocationView.class);
//            intent.putExtra("Selected",a);
//            startActivity(intent);
//        }
//    }
}