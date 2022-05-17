package com.nima.loacationfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class LocationView extends AppCompatActivity {
    int S;
    int H;
    int X;
    int Y;
    int Hv;
    int Wv;
    Map map=new Map();
    int nop;
    int str1=0;
    int str2=0;
    int str3=0;
    int str4=0;
    double d1;
    double d2;
    double d3;
    double d4;
    int A[][];
    int[]person=new int[3];
    P2D[]p2=new P2D[3];
    P3D[]p3=new P3D[4];
    int scale;
    String ID;
    int number;
    Bitmap[]bitmaps;
    Wifi_C[]wifi_cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_view);
//        //S=getIntent().getExtras().getInt("Selected");
//        S=getIntent().getExtras().getInt("nop");
        ////////////////////////////////////////////////////////////////////////////////////////////
        FileInputStream fis = null;
        try {
            fis = this.openFileInput("map1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bufferedReader = new BufferedReader(isr);
        try {
            bufferedReader.readLine();
            //for(int i=0;i<1;i++){
                map=new Map();
                map.ID=bufferedReader.readLine();
                map.nof=Integer.parseInt(bufferedReader.readLine());
                map.x=Integer.parseInt(bufferedReader.readLine());
                map.y=Integer.parseInt(bufferedReader.readLine());
                map.h=Integer.parseInt(bufferedReader.readLine());
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Hv=((ImageView) findViewById(R.id.imageView)).getHeight();
        Wv=((ImageView) findViewById(R.id.imageView)).getWidth();
        scale=Math.min(Hv/map.y,Wv/map.x);
        ////////////////////////////////////////////////////////////////////////////////////////////
        FileInputStream fis1 = null;
        try {
            fis1 = this.openFileInput("map2.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr1 = new InputStreamReader(fis1);
        BufferedReader bufferedReader1 = new BufferedReader(isr1);
        try {
            bufferedReader1.readLine();
            for(int j=0;j<4;j++){
                map.w[j]=new Wifi_C();
                map.w[j].SSID=bufferedReader1.readLine();
                map.w[j].x=Integer.parseInt(bufferedReader1.readLine());
                map.w[j].y=Integer.parseInt(bufferedReader1.readLine());
                map.w[j].z=Integer.parseInt(bufferedReader1.readLine());

            }
            bufferedReader1.close();
            }
            catch (IOException e) {
            e.printStackTrace();
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        scale = Math.min(1000 / map.x, 1000 / map.y);
        scale=1;
        ////////////////////////////////////////////////////////////////////////////////////////////
        bitmaps=new Bitmap[map.nof];
        A=new int[map.x][map.y];
//        for(int i=0;i<map.nof;i++) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        try {
            bitmaps[0] = BitmapFactory.decodeStream(this.openFileInput("image.png"), null, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        }

        ((ImageView) findViewById(R.id.imageView)).setImageBitmap(bitmaps[0]);
        for(int i=0;i<3;i++){
            p2[i]=new P2D();
        }
        for(int i=0;i<4;i++){
            p3[i]=new P3D();
        }
        if(map.nof==1) {
            for(int i=0;i<3;i++){
                p2[i]=new P2D();
                p2[i].x=map.w[i].x/10.0;
                p2[i].y=map.w[i].y/10.0;
            }
            Thread thread = new Thread() {

                @Override
                public void run() {
                    System.out.println(getMacAddr());
                    try {
                        while (!this.isInterrupted()) {
                            Thread.sleep(100);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    WifiControl();
                        d1 = ((-str1) - 30) / 5;
                        d2 = ((-str2) - 30) / 5;
                        d3 = ((-str3) - 30) / 5;
                        person[0] = (int) (P2D.solve(p2[0], p2[1], p2[2], d1, d2, d3).x * 10);
                        person[1] = (int) (P2D.solve(p2[0], p2[1], p2[2], d1, d2, d3).y * 10);
                        show();
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                    }
                }
            };

            thread.start();
        }else {
            for(int i=0;i<4;i++){
                p3[i]=new P3D();
                p3[i].x=map.w[i].x/10.0;
                p3[i].y=map.w[i].y/10.0;
                p3[i].z=map.w[i].z/10.0;
            }
            Thread thread = new Thread() {

                @Override
                public void run() {

                    try {
                        while (!this.isInterrupted()) {
                            Thread.sleep(100);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if(str1!=0 && str2!=0 && str3!=0 && str4!=0) {
                                        WifiControl();
                                        d1 = ((-str1) - 30) / 5;
                                        d2 = ((-str2) - 30) / 5;
                                        d3 = ((-str3) - 30) / 5;
                                        d4 = ((-str4) - 30) / 5;
                                        person[0] = (int) (P3D.solve(p3[0], p3[1], p3[2], p3[3], d1, d2, d3, d4).x * 10);
                                        person[1] = (int) (P3D.solve(p3[0], p3[1], p3[2], p3[3], d1, d2, d3, d4).y * 10);
                                        person[2] = (int) (P3D.solve(p3[0], p3[1], p3[2], p3[3], d1, d2, d3, d4).z * 10);
                                        show();
                                    }
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                    }
                }
            };
        }
    }
    public void WifiControl(){
        WifiManager wifiManager = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        int numberOfLevels = 100;
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int level = WifiManager.calculateSignalLevel(wifiInfo.getRssi(), numberOfLevels);
//        person[0]=(((-wifiInfo.getRssi())-30)/5)*100;
//        person[1]=750;
        List<ScanResult> wifiList = wifiManager.getScanResults();
        for(int i=0;i<wifiList.size();i++){
            if(wifiList.get(i).SSID.equals(map.w[0].SSID))
                str1=wifiList.get(i).level;
            else if(wifiList.get(i).SSID.equals(map.w[1].SSID)){
                str2=wifiList.get(i).level;
            }else if(wifiList.get(i).SSID.equals(map.w[2].SSID)){
                str3=wifiList.get(i).level;
            }else if(map.nof>1){
                if(wifiList.get(i).SSID.equals(map.w[3].SSID)){
                    str1=wifiList.get(i).level;
                }
            }
        }
        System.out.println(str1);
    }
    public void Click(View v){
        if(v.getId()==R.id.nav_view_quit){
            this.finish();
        }
    }
    public void show(){
        findViewById(R.id.person).setX(person[0]*scale+(Wv-scale*map.x)+((ImageView)findViewById(R.id.imageView)).getX());
        findViewById(R.id.person).setY(person[1]*scale+(Hv-scale*map.y)+((ImageView)findViewById(R.id.imageView)).getX());
    }
    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    String hex = Integer.toHexString(b & 0xFF);
                    if (hex.length() == 1)
                        hex = "0".concat(hex);
                    res1.append(hex.concat(":"));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
        }
        return "";
    }
}
