package com.example.projecttalentoriginal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Set5Item3_Activity extends Activity {
	boolean click=false;int count=0,count1=0;long ms;boolean empty=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set5_item3_);
		EditText uid=(EditText) findViewById(R.id.editText1);
		uid.requestFocus();
		Date start = new Date();
		String s = MyGlobalVariables.getTime();
		s+="nsa53_start:"+start.toString()+";";
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
		    		String s = MyGlobalVariables.getData();
            		String ans= s.substring(s.indexOf("nsa51:"));
            		String[] l = new String[3];
            		l = ans.split(";");count1=0;
            		s=s.substring(0,s.indexOf("nsa51:"));
            		for(int i = 0;i<3;i++){
            			if(i==0 && l[i].substring(l[i].indexOf(':')+1).equals("17")) {count1++;s+="nsa51_score:1;";s+="nsa51_ans:17;";}
            			else if(i==1 && l[i].substring(l[i].indexOf(':')+1).equals("7")) {count1++;s+="nsa52_score:1;";s+="nsa52_ans:7;";}
            			else if(i==2 && l[i].substring(l[i].indexOf(':')+1).equals("72,76")) {count1++;s+="nsa53_score:1;";s+="nsa53_ans:72,76;";}
            			else if(i==2 && l[i].substring(l[i].indexOf(':')+1).equals("78,82")) {count1++;s+="nsa53_score:1;";s+="nsa53_ans:78,82;";}
            			else
            			{
            				if(i==0){s+="nsa51_score:0;";s+="nsa51_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
            				else if(i==1){s+="nsa52_score:0;";s+="nsa52_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
            				else if(i==2){s+="nsa53_score:0;";s+="nsa53_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
            			}
            		}
               		MyGlobalVariables.setData(s);
            		TextView tv = (TextView) findViewById(R.id.message);
            		tv.setVisibility(View.INVISIBLE);
            		Date end = new Date();
             		 s = MyGlobalVariables.getTime();
             		s+="nsa53_end:"+end.toString()+";";
             		s+="sec_ns_end:"+end.toString()+";";
             		String t=MyGlobalVariables.getData();
             		t+=s;MyGlobalVariables.setData(t);
             		MyGlobalVariables.setTime("");
					create_textfile();
		    		Intent intent = new Intent(Set5Item3_Activity.this, SecRF_Activity.class);
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
		  ImageView img = (ImageView) findViewById(R.id.imageView1);
	       img.setOnClickListener(new View.OnClickListener() {
	           public void onClick(View v) {
	               // Perform action on click
	        	   EditText uid=(EditText) findViewById(R.id.editText1);
	            	EditText uid1=(EditText) findViewById(R.id.editText2);
	            	uid.clearFocus();
	            	uid1.requestFocus();
	           }
	       });
	       
		Button button = (Button) findViewById(R.id.Button09);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	EditText uid1=(EditText) findViewById(R.id.editText2);
            	if (uid1.isFocused()){
            		String u=uid1.getText().toString();
            		u+='0';
                	uid1.setText(u);
            	}
            	else {
            		String u=uid.getText().toString();
            		u+='0';
                	uid.setText(u);
            	}
            }
        });
        button = (Button) findViewById(R.id.Button11);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	EditText uid1=(EditText) findViewById(R.id.editText2);
            	if (uid1.isFocused()){
            		String u=uid1.getText().toString();
            		u+='9';
                	uid1.setText(u);
            	}
            	else {
            		String u=uid.getText().toString();
            		u+='9';
                	uid.setText(u);
            	}
            }
        });
        button = (Button) findViewById(R.id.Button01);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	EditText uid1=(EditText) findViewById(R.id.editText2);
            	if (uid1.isFocused()){
            		String u=uid1.getText().toString();
            		u+='8';
                	uid1.setText(u);
            	}
            	else {
            		String u=uid.getText().toString();
            		u+='8';
                	uid.setText(u);
            	}
            }
        });
        button = (Button) findViewById(R.id.Button02);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	EditText uid1=(EditText) findViewById(R.id.editText2);
            	if (uid1.isFocused()){
            		String u=uid1.getText().toString();
            		u+='7';
                	uid1.setText(u);
            	}
            	else {
            		String u=uid.getText().toString();
            		u+='7';
                	uid.setText(u);
            	}
            }
        });
        button = (Button) findViewById(R.id.Button03);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	EditText uid1=(EditText) findViewById(R.id.editText2);
            	if (uid1.isFocused()){
            		String u=uid1.getText().toString();
            		u+='6';
                	uid1.setText(u);
            	}
            	else {
            		String u=uid.getText().toString();
            		u+='6';
                	uid.setText(u);
            	}
            }
        });
        button = (Button) findViewById(R.id.Button04);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	EditText uid1=(EditText) findViewById(R.id.editText2);
            	if (uid1.isFocused()){
            		String u=uid1.getText().toString();
            		u+='5';
                	uid1.setText(u);
            	}
            	else {
            		String u=uid.getText().toString();
            		u+='5';
                	uid.setText(u);
            	}
            }
        });
        button = (Button) findViewById(R.id.Button05);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	EditText uid1=(EditText) findViewById(R.id.editText2);
            	if (uid1.isFocused()){
            		String u=uid1.getText().toString();
            		u+='4';
                	uid1.setText(u);
            	}
            	else {
            		String u=uid.getText().toString();
            		u+='4';
                	uid.setText(u);
            	}
            }
        });
        button = (Button) findViewById(R.id.Button06);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	EditText uid1=(EditText) findViewById(R.id.editText2);
            	if (uid1.isFocused()){
            		String u=uid1.getText().toString();
            		u+='3';
                	uid1.setText(u);
            	}
            	else {
            		String u=uid.getText().toString();
            		u+='3';
                	uid.setText(u);
            	}
            }
        });
        button = (Button) findViewById(R.id.Button07);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	EditText uid1=(EditText) findViewById(R.id.editText2);
            	if (uid1.isFocused()){
            		String u=uid1.getText().toString();
            		u+='2';
                	uid1.setText(u);
            	}
            	else {
            		String u=uid.getText().toString();
            		u+='2';
                	uid.setText(u);
            	}
            }
        });
        button = (Button) findViewById(R.id.Button08);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	EditText uid1=(EditText) findViewById(R.id.editText2);
            	if (uid1.isFocused()){
            		String u=uid1.getText().toString();
            		u+='1';
                	uid1.setText(u);
            	}
            	else {
            		String u=uid.getText().toString();
            		u+='1';
                	uid.setText(u);
            	}
            }
        });
        button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	EditText uid1=(EditText) findViewById(R.id.editText2);
            	uid.setText("");
            	uid1.setText("");
            	uid1.clearFocus();
            	uid.requestFocus();
            }
        });
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	click = true;count++;
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	EditText uid1=(EditText) findViewById(R.id.editText2);
            	String u1=uid1.getText().toString();
            	String s = MyGlobalVariables.getData();
        		if (s.contains("nsa53:")){
        			int p=s.indexOf("nsa53:");
        			s = s.substring(0,p);
        		}
        		if (u.length()!=0 && u1.length()!=0)
            	{
        			s+="nsa53:"+u+","+u1+";";
            	}
            	else
            	{
            		if(u.length()==0) u = "-1";
                	if (u1.length()==0) u1 = "-1";
                	s+="nsa53:"+u+","+u1+";";
                	
                		TextView tv = (TextView) findViewById(R.id.message);
                		String t = getResources().getString(R.string.msg3);
           				 tv.setText(t);
           				 tv.setVisibility(View.VISIBLE);
           				empty=true;
                	
            	}
        		MyGlobalVariables.setData(s);
        		if((click && count==2)){
            		click = false;
            		s = MyGlobalVariables.getData();
            		String ans= s.substring(s.indexOf("nsa51:"));
            		String[] l = new String[3];
            		l = ans.split(";");count1=0;
            		s=s.substring(0,s.indexOf("nsa51:"));
            		for(int i = 0;i<3;i++){
            			if(i==0 && l[i].substring(l[i].indexOf(':')+1).equals("17")) {count1++;s+="nsa51_score:1;";s+="nsa51_ans:17;";}
            			else if(i==1 && l[i].substring(l[i].indexOf(':')+1).equals("7")) {count1++;s+="nsa52_score:1;";s+="nsa52_ans:7;";}
            			else if(i==2 && l[i].substring(l[i].indexOf(':')+1).equals("72,76")) {count1++;s+="nsa53_score:1;";s+="nsa53_ans:72,76;";}
            			else if(i==2 && l[i].substring(l[i].indexOf(':')+1).equals("78,82")) {count1++;s+="nsa53_score:1;";s+="nsa53_ans:78,82;";}
            			else
            			{
            				if(i==0){s+="nsa51_score:0;";s+="nsa51_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
            				else if(i==1){s+="nsa52_score:0;";s+="nsa52_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
            				else if(i==2){s+="nsa53_score:0;";s+="nsa53_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
            			}
            		}
               		MyGlobalVariables.setData(s);
            		TextView tv = (TextView) findViewById(R.id.message);
            		tv.setVisibility(View.INVISIBLE);
            		Date end = new Date();
             		 s = MyGlobalVariables.getTime();
             		s+="nsa53_end:"+end.toString()+";";
             		s+="sec_ns_end:"+end.toString()+";";
             		String t=MyGlobalVariables.getData();
             		t+=s;MyGlobalVariables.setData(t);
             		MyGlobalVariables.setTime("");
					create_textfile();
            		Intent intent = new Intent(Set5Item3_Activity.this, SecRF_Activity.class);
               		startActivity(intent);
            	}
            }
        });
        
	}
	public void create_textfile()
	{
		String f = Environment.getExternalStorageDirectory()+"/"+MyGlobalVariables.getUserName();
		String timeStamp = new SimpleDateFormat("_MMdd_HHmm").format(new Date());
		String fileName=f+ "/NS_"+MyGlobalVariables.getUserName()+timeStamp+".txt";
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
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.set5_item3_, menu);
		return true;
	}
	@Override
	public void onBackPressed()
	{

	   //thats it
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
