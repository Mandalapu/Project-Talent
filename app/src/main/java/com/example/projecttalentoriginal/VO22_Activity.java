package com.example.projecttalentoriginal;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Date;

public class VO22_Activity extends ActionBarActivity {
    long ms;
    boolean click = false;
    boolean empty=false;
    int count=0;
    RadioGroup radioGroup;
    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vo22_);

        Date start = new Date();
        String s = MyGlobalVariables.getTime();
        //s+="sec_vo_start:"+start.toString()+";";
        s+="vo22_start:"+start.toString()+";";
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
                    s+="vo22_end:"+end.toString()+";";
                    MyGlobalVariables.setTime(s);
                    Log.e("stringvo",s);
                    Intent intent = new Intent(VO22_Activity.this, VO23_Activity.class);
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
                if (s.contains("vo22:")){
                    p=s.indexOf("vo22:");
                    s = s.substring(0,p);
                }
                if (s.contains("vo22_score:")){
                    p=s.indexOf("vo22_score:");
                    s = s.substring(0,p);
                }
                if (s.contains("vo22_ans:")){
                    p=s.indexOf("vo22_ans:");
                    s = s.substring(0,p);
                }

                if (selectedId == -1)
                {
                    s+="vo22:0"+";";
                    MyGlobalVariables.q31 = 0;
                    s+="vo22_score:"+Integer.toString(MyGlobalVariables.qx2)+";";
                    s+="vo22_ans:2;";

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
                    if(idx==2)
                        MyGlobalVariables.qx2=1;

                    s+="vo22:"+Integer.toString(idx)+";";
                    s+="vo22_score:"+Integer.toString(MyGlobalVariables.qx2)+";";
                    s+="vo22_ans:2;";
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
                    s+="vo22_end:"+end.toString()+";";
                    Log.e("stringvo",s);
                    MyGlobalVariables.setTime(s);
                    Intent intent = new Intent(VO22_Activity.this, VO23_Activity.class);
                    startActivity(intent);
                }


            }
        });
    }

}

