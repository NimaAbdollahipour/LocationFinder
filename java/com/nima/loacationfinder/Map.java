package com.nima.loacationfinder;

public class Map {
    protected int x;
    protected int y;
    protected int h;
    protected int nof;
    protected String ID=new String();
    protected Wifi_C[]w=new Wifi_C[4];
    public String toString(){
        return "\r\n"+ID+"\r\n"+nof+"\r\n"+x+"\r\n"+y+"\r\n"+h+w[0].toString()+w[1].toString()+w[2].toString()+w[3].toString();
    }
    public String toString2(){
        return "\r\n"+ID+"\r\n"+nof+"\r\n"+x+"\r\n"+y+"\r\n"+h;
    }
    public String toString3(){
        return w[0].toString()+w[1].toString()+w[2].toString()+w[3].toString();
    }
}
