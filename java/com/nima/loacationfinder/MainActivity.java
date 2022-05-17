package com.nima.loacationfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    int s=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Click(View v) throws IOException {
        if(v.getId()==R.id.quit_button){
            this.finish();
        }
        if(v.getId()==R.id.Choose_map){
            Intent intent=new Intent(MainActivity.this,LocationView.class);
//            FileInputStream fis = this.openFileInput("save.txt");
//            InputStreamReader isr = new InputStreamReader(fis);
//            BufferedReader bufferedReader = new BufferedReader(isr);
//            s=Integer.parseInt(bufferedReader.readLine());
//            intent.putExtra("nop",1);
            startActivity(intent);
        }
        if(v.getId()==R.id.create_button){
//            FileInputStream fis = this.openFileInput("save.txt");
//            InputStreamReader isr = new InputStreamReader(fis);
//            BufferedReader bufferedReader = new BufferedReader(isr);
//            s=Integer.parseInt(bufferedReader.readLine());
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.openFileOutput("save.txt", Context.MODE_PRIVATE));
//            outputStreamWriter.write(s+1+"");
//            outputStreamWriter.close();
            EditText t1=findViewById(R.id.X_text);
            EditText t2=findViewById(R.id.Y_text);
            EditText t3=findViewById(R.id.H_text);
            EditText t4=findViewById(R.id.floor_n_text);
            EditText t5=findViewById(R.id.ID_text);
            CheckBox c=findViewById(R.id.multi_story_check);
            if(t1.getText().toString().isEmpty()||t2.getText().toString().isEmpty()||
                    t3.getText().toString().isEmpty()||(c.isChecked() && t4.getText().toString().isEmpty())
                    ||t5.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(MainActivity.this, CreateImage.class);
                intent.putExtra("X", Integer.parseInt(t1.getText().toString()));
                intent.putExtra("Y", Integer.parseInt(t2.getText().toString()));
                intent.putExtra("H", Integer.parseInt(t3.getText().toString()) );
                if (c.isChecked()) {
                    intent.putExtra("floor_number", Integer.parseInt(t3.getText().toString()));
                }else{
                intent.putExtra("floor_number", 1);
                }
                intent.putExtra("ID",t5.getText().toString());
                startActivity(intent);
            }
        }
    }
}