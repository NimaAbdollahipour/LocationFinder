package com.nima.loacationfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class CreateImage extends AppCompatActivity {
    Bitmap [] images;
    int[][]A;
    Map map=new Map();
    int n;
    int x;
    int y;
    int h;
    int scale;
    int counter=0;
    String ID;
    EditText tt1;
    EditText tt2;
    EditText tt3;
    EditText tt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tt2=(EditText) findViewById(R.id.draw_X2_text);
        tt1=(EditText)findViewById(R.id.draw_X1_text);
        tt4=(EditText)findViewById(R.id.draw_Y2_text);
        tt3=(EditText)findViewById(R.id.draw_Y1_text);
        setContentView(R.layout.create_image);
        Bundle bundle=getIntent().getExtras();
        n=bundle.getInt("floor_number");
        x=bundle.getInt("X");
        y=bundle.getInt("Y");
        h=bundle.getInt("H");
        ID=bundle.getString("ID");
        map.x=x;
        map.y=y;
        map.nof=n;
        map.h=h;
        map.ID=ID;
        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStreamWriter = new OutputStreamWriter(this.openFileOutput("map1.txt", Context.MODE_PRIVATE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            outputStreamWriter.append(map.toString2());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scale=Math.min(1000/x,1000/y);
        ////////////////////////////////////////////////////////////////////////////////////////
        scale=1;
        //////////////////////////////////////////////////////////////////////////////////////
        A=new int[x*scale][y*scale];
        images=new Bitmap[n];
        images[0]=Bitmap.createBitmap(x*scale,y*scale, Bitmap.Config.RGB_565);
        for(int i=0;i<(x)*scale;i++)
            for(int j=0;j<(y)*scale;j++) {
                images[0].setPixel(i, j, 0);
                A[i][j]=0;
            }
        ((ImageView)findViewById(R.id.map_drawing_img)).setImageBitmap(images[0]);
    }
    public void Click(View v) throws IOException {
        int x1=Math.min(Integer.parseInt(((EditText)findViewById(R.id.draw_X1_text)).getText().toString()),Integer.parseInt(((EditText)findViewById(R.id.draw_X2_text)).getText().toString()));
        int x2=Math.max(Integer.parseInt(((EditText)findViewById(R.id.draw_X1_text)).getText().toString()),Integer.parseInt(((EditText)findViewById(R.id.draw_X2_text)).getText().toString()));
        int y1=Math.min(Integer.parseInt(((EditText)findViewById(R.id.draw_Y1_text)).getText().toString()),Integer.parseInt(((EditText)findViewById(R.id.draw_Y2_text)).getText().toString()));
        int y2=Math.max(Integer.parseInt(((EditText)findViewById(R.id.draw_Y1_text)).getText().toString()),Integer.parseInt(((EditText)findViewById(R.id.draw_Y2_text)).getText().toString()));
        if(v.getId()==R.id.draw){
                for(int i=x1*scale;i<(x2+1)*scale;i++)
                    for(int j=y1*scale;j<(y2+1)*scale;j++) {
                        images[counter].setPixel(i, j, 255 * 256);
                        A[i][j]=1;
                    }
                ((ImageView)findViewById(R.id.map_drawing_img)).setImageBitmap(images[counter]);
        }
        if(v.getId()==R.id.clean){
                for(int i=x1*scale;i<(x2+1)*scale;i++)
                    for(int j=y1*scale;j<(y2+1)*scale;j++) {
                        images[counter].setPixel(i, j, 255 * 256);
                        A[i][j]=0;
                    }
                ((ImageView)findViewById(R.id.map_drawing_img)).setImageBitmap(images[counter]);
        }
        if(v.getId()==R.id.next){
            n--;
            if(counter<map.nof){
                save();
                counter++;

                if(counter<map.nof) {
                    images[counter] = Bitmap.createBitmap(x * scale, y * scale, Bitmap.Config.ARGB_8888);
                    for(int i=0;i<(x)*scale;i++)
                        for(int j=0;j<(y)*scale;j++) {
                            images[counter].setPixel(i, j, 0);
                            A[i][j]=0;
                        }
                }
            }
            if(n<=0){
                if(map.nof==1) {
                    Intent intent = new Intent(CreateImage.this, Wifi3.class);
                    intent.putExtra("ID",ID);
                    startActivity(intent);
                    this.finish();
                }else{
                    Intent intent1 = new Intent(CreateImage.this, Wifi4.class);
                    intent1.putExtra("ID",ID);
                    startActivity(intent1);
                    this.finish();

                }
            }
        }
    }
    private void save() throws IOException {
        images[0].compress(Bitmap.CompressFormat.PNG,100,this.openFileOutput("image.png",MODE_PRIVATE));
    }
}