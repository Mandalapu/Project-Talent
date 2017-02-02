package com.example.projecttalentoriginal;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VO53_Activity extends ActionBarActivity {
    long ms;
    boolean click = false;
    boolean empty=false;
    int count=0;
    RadioGroup radioGroup;
    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vo53_);

        Date start = new Date();
        String s = MyGlobalVariables.getTime();
        //s+="sec_vo_start:"+start.toString()+";";
        s+="vo53_start:"+start.toString()+";";
        MyGlobalVariables.setTime(s);


        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                ms=millisUntilFinished;
                if(millisUntilFinished>=55000 && click && !empty){
                    click = false;
                    TextView tv = (TextView) findViewById(R.id.message);
                    String t = getResources().getString(R.string.msg1);
                    tv.setText(t);
                    tv.setVisibility(View.VISIBLE);
                }
                else if(click && !empty)
                {
                    click = false;
                    TextView tv = (TextView) findViewById(R.id.message);
                    tv.setVisibility(View.INVISIBLE);
                    Date end = new Date();
                    String s = MyGlobalVariables.getTime();
                    s+="vo53_end:"+end.toString()+";";
                    s+="sec_vo_end:"+end.toString()+";";
                    String t=MyGlobalVariables.getData();
                    t+=s;MyGlobalVariables.setData(t);
                    MyGlobalVariables.setTime("");
                    Intent intent=null;
                    create_textfile();
                    intent = new Intent(VO53_Activity.this, SecNS_Activity.class);
                    startActivity(intent);
                }
            }
            public void onFinish() {
                if(!click){
                    TextView tv = (TextView) findViewById(R.id.message);
                    String t = getResources().getString(R.string.msg2);
                    tv.setText(t);
                    tv.setVisibility(View.VISIBLE);
                    count++;
                }
            }
        }.start();


        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                click = true;count++;
                radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                String s = MyGlobalVariables.getData();
                int p;
                if (s.contains("vo53:")){
                    p=s.indexOf("vo53:");
                    s = s.substring(0,p);
                }
                if (s.contains("vo53_score:")){
                    p=s.indexOf("vo53_score:");
                    s = s.substring(0,p);
                }
                if (s.contains("vo53_ans:")){
                    p=s.indexOf("vo53_ans:");
                    s = s.substring(0,p);
                }

                if (selectedId == -1)
                {
                    s+="vo53:0"+";";
                    MyGlobalVariables.q31 = 0;
                    s+="vo53_score:"+Integer.toString(MyGlobalVariables.qx3)+";";
                    s+="vo53_ans:3;";

                    TextView tv = (TextView) findViewById(R.id.message);
                    String t = getResources().getString(R.string.msg3);
                    tv.setText(t);
                    tv.setVisibility(View.VISIBLE);
                    empty=true;
                }
                else
                {
                    radioButton = (RadioButton)findViewById(selectedId);
                    int idx = radioGroup.indexOfChild(radioButton);


//                    String string,u;
//                    string = radioButton.getI
//                    u = string.substring(string.length() - 1));

                    if(idx==3)
                        MyGlobalVariables.qx3=1;
                    s+="vo53:"+Integer.toString(idx)+";";
                    s+="vo53_score:"+Integer.toString(MyGlobalVariables.qx3)+";";
                    s+="vo53_ans:3;";
                    // MyGlobalVariables g = new MyGlobalVariables();
                    empty=false;
                }
                MyGlobalVariables.setData(s);
                if((click && count>=2)){
                    click = false;
                    TextView tv = (TextView) findViewById(R.id.message);
                    tv.setVisibility(View.INVISIBLE);
                    Date end = new Date();
                    s = MyGlobalVariables.getTime();
                    s+="vo53_end:"+end.toString()+";";
                    s+="sec_vo_end:"+end.toString()+";";
                    String t=MyGlobalVariables.getData();
                    t+=s;MyGlobalVariables.setData(t);
                    MyGlobalVariables.setTime("");
                    Intent intent=null;
                    create_textfile();
                    intent = new Intent(VO53_Activity.this, SecNS_Activity.class);
                    startActivity(intent);
                }


            }
        });
    }
    public void create_textfile()
    {
        String f = Environment.getExternalStorageDirectory()+"/"+MyGlobalVariables.getUserName();
        String timeStamp = new SimpleDateFormat("_MMdd_HHmm").format(new Date());
        String fileName=f+ "/VO_"+MyGlobalVariables.getUserName()+timeStamp+".txt";
        String final_data = MyGlobalVariables.getData();
        String[] d = final_data.split(";");
        try {
            File myFile = new File(fileName);
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            for(int i=0;i<d.length;i++)
                myOutWriter.append(d[i]+"\n");
            myOutWriter.close();
            fOut.close();
        } catch (Exception e) {
        }
    }

}

