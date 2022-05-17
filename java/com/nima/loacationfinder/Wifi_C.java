package com.nima.loacationfinder;

public class Wifi_C {
    protected  int x=0;
    protected int y=0;
    protected int z=0;
    protected String SSID="";

    @Override
    public String toString() {
        return "\r\n"+SSID+"\r\n"+x+"\r\n"+y+"\r\n"+z;
    }
}
