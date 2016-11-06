package com.example.projecttalentoriginal;


import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Set3Item3_Activity extends Activity {
	boolean click = false; int count=0;int count1=0;long ms;boolean empty=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set3_item3_);
		Date start = new Date();
		String s = MyGlobalVariables.getTime();
		s+="nsa33_start:"+start.toString()+";";
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
		    		Intent intent = null;
		    		String s = MyGlobalVariables.getData();
	            	String ans= s.substring(s.indexOf("nsa31:"));
	        		String[] l = new String[3];
	        		l = ans.split(";");count1=0;
	        		s=s.substring(0,s.indexOf("nsa31:"));
	        		for(int i = 0;i<3;i++){
	        			if(i==0 && l[i].substring(l[i].indexOf(':')+1).equals("10")) {count1++;s+="nsa31_score:1;";s+="nsa31_ans:10;";}
	        			else if(i==1 && l[i].substring(l[i].indexOf(':')+1).equals("41")) {count1++;s+="nsa32_score:1;";s+="nsa32_ans:41;";}
	        			else if(i==2 && l[i].substring(l[i].indexOf(':')+1).equals("12")) {count1++;s+="nsa33_score:1;";s+="nsa33_ans:12;";}
	        			else
	        			{
	        				if(i==0){s+="nsa31_score:0;";s+="nsa31_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
	        				else if(i==1){s+="nsa32_score:0;";s+="nsa32_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
	        				else if(i==2){s+="nsa33_score:0;";s+="nsa33_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
	        			}
	        		}
	        		MyGlobalVariables.setData(s);
	        		TextView tv = (TextView) findViewById(R.id.message);
	        		tv.setVisibility(View.INVISIBLE);
		    		if(count1==0)
	        			intent = new Intent(Set3Item3_Activity.this, Set1Item1_Activity.class);
	        		else if(count1==1)
	        			intent = new Intent(Set3Item3_Activity.this, Set2Item1_Activity.class);
	        		else if(count1==2)
	        			intent = new Intent(Set3Item3_Activity.this, Set4Item1_Activity.class);
	        		else if(count1==3)
	        			intent = new Intent(Set3Item3_Activity.this, Set5Item1_Activity.class);
		    		Date end = new Date();
	        		 s = MyGlobalVariables.getTime();
	        		s+="nsa33_end:"+end.toString()+";";
	        		String t=MyGlobalVariables.getData();
            		t+=s;MyGlobalVariables.setData(t);
            		MyGlobalVariables.setTime("");
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
		Button button = (Button) findViewById(R.id.Button09);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
        	EditText uid=(EditText) findViewById(R.id.editText1);
        	String u=uid.getText().toString();
        	u+='0';
        	uid.setText(u);
        }
    });
    button = (Button) findViewById(R.id.Button11);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
        	EditText uid=(EditText) findViewById(R.id.editText1);
        	String u=uid.getText().toString();
        	u+='9';
        	uid.setText(u);
        }
    });
    button = (Button) findViewById(R.id.Button01);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
        	EditText uid=(EditText) findViewById(R.id.editText1);
        	String u=uid.getText().toString();
        	u+='8';
        	uid.setText(u);
        }
    });
    button = (Button) findViewById(R.id.Button09);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
        	EditText uid=(EditText) findViewById(R.id.editText1);
        	String u=uid.getText().toString();
        	u+='0';
        	uid.setText(u);
        }
    });
    button = (Button) findViewById(R.id.Button02);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
        	EditText uid=(EditText) findViewById(R.id.editText1);
        	String u=uid.getText().toString();
        	u+='7';
        	uid.setText(u);
        }
    });
    button = (Button) findViewById(R.id.Button03);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
        	EditText uid=(EditText) findViewById(R.id.editText1);
        	String u=uid.getText().toString();
        	u+='6';
        	uid.setText(u);
        }
    });
    button = (Button) findViewById(R.id.Button04);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
        	EditText uid=(EditText) findViewById(R.id.editText1);
        	String u=uid.getText().toString();
        	u+='5';
        	uid.setText(u);
        }
    });
    button = (Button) findViewById(R.id.Button05);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
        	EditText uid=(EditText) findViewById(R.id.editText1);
        	String u=uid.getText().toString();
        	u+='4';
        	uid.setText(u);
        }
    });
    button = (Button) findViewById(R.id.Button06);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
        	EditText uid=(EditText) findViewById(R.id.editText1);
        	String u=uid.getText().toString();
        	u+='3';
        	uid.setText(u);
        }
    });
    button = (Button) findViewById(R.id.Button07);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
        	EditText uid=(EditText) findViewById(R.id.editText1);
        	String u=uid.getText().toString();
        	u+='2';
        	uid.setText(u);
        }
    });
    button = (Button) findViewById(R.id.Button08);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
        	EditText uid=(EditText) findViewById(R.id.editText1);
        	String u=uid.getText().toString();
        	u+='1';
        	uid.setText(u);
        }
    });
    button = (Button) findViewById(R.id.button9);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
        	EditText uid=(EditText) findViewById(R.id.editText1);
        	uid.setText("");
        }
    });
    button = (Button) findViewById(R.id.button3);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
        	click = true;count++;
        	EditText uid=(EditText) findViewById(R.id.editText1);
        	String u=uid.getText().toString();
        	String s = MyGlobalVariables.getData();
    		if (s.contains("nsa33:")){
    			int p=s.indexOf("nsa33:");
    			s = s.substring(0,p);
    		}
        	if (u.length()!=0)
        	{
        		s+="nsa33:"+u+";";
        	}
        	if(u.length()==0)
        	{
        		s+="nsa33:"+"-1"+";";
        		
        		TextView tv = (TextView) findViewById(R.id.message);
        		String t = getResources().getString(R.string.msg3);
   				 tv.setText(t);
   				 tv.setVisibility(View.VISIBLE);
   				empty=true;
        	}
        	MyGlobalVariables.setData(s);    		
    		Intent intent = null;    	    
        	if((click && count==2)){
        		click = false;
        		s = MyGlobalVariables.getData();
            	String ans= s.substring(s.indexOf("nsa31:"));
        		String[] l = new String[3];
        		l = ans.split(";");count1=0;
        		s=s.substring(0,s.indexOf("nsa31:"));
        		for(int i = 0;i<3;i++){
        			if(i==0 && l[i].substring(l[i].indexOf(':')+1).equals("10")) {count1++;s+="nsa31_score:1;";s+="nsa31_ans:10;";}
        			else if(i==1 && l[i].substring(l[i].indexOf(':')+1).equals("41")) {count1++;s+="nsa32_score:1;";s+="nsa32_ans:41;";}
        			else if(i==2 && l[i].substring(l[i].indexOf(':')+1).equals("12")) {count1++;s+="nsa33_score:1;";s+="nsa33_ans:12;";}
        			else
        			{
        				if(i==0){s+="nsa31_score:0;";s+="nsa31_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
        				else if(i==1){s+="nsa32_score:0;";s+="nsa32_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
        				else if(i==2){s+="nsa33_score:0;";s+="nsa33_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
        			}
        		}
        		MyGlobalVariables.setData(s);
        		TextView tv = (TextView) findViewById(R.id.message);
        		tv.setVisibility(View.INVISIBLE);
        		if(count1==0)
        			intent = new Intent(Set3Item3_Activity.this, Set1Item1_Activity.class);
        		else if(count1==1)
        			intent = new Intent(Set3Item3_Activity.this, Set2Item1_Activity.class);
        		else if(count1==2)
        			intent = new Intent(Set3Item3_Activity.this, Set4Item1_Activity.class);
        		else if(count1==3)
        			intent = new Intent(Set3Item3_Activity.this, Set5Item1_Activity.class);
        		Date end = new Date();
        		 s = MyGlobalVariables.getTime();
        		s+="nsa33_end:"+end.toString()+";";String t=MyGlobalVariables.getData();
        		t+=s;MyGlobalVariables.setData(t);
        		MyGlobalVariables.setTime("");
        		startActivity(intent);
        	}
        }
    });
        /*button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	if (u.length()!=0)
            	{
            		//MyGlobalVariables g = new MyGlobalVariables();
            		String s = MyGlobalVariables.getData();
            		if (s.contains("nsa33:")){
            			int p=s.indexOf("nsa33:");
            			s = s.substring(0,p);
            		}
            		s+="nsa33:"+u+";";            		
            		String ans= s.substring(s.indexOf("nsa31:"));
            		String[] l = new String[3];
            		l = ans.split(";");int count=0;
            		for(int i = 0;i<3;i++){
            			if(i==0 && l[i].substring(l[i].indexOf(':')+1).equals("10")) count++;
            			else if(i==1 && l[i].substring(l[i].indexOf(':')+1).equals("41")) count++;
            			else if(i==2 && l[i].substring(l[i].indexOf(':')+1).equals("12")) count++;
            		}
            		s=s.substring(0,s.indexOf("nsa31:"));
            		s+="nsa3:"+ Integer.toString(count);
            		MyGlobalVariables.setData(s);
            		Intent intent = null;
            		if(count==0)
            			intent = new Intent(Set3Item3_Activity.this, Set1Item1_Activity.class);
            		else if(count==1)
            			intent = new Intent(Set3Item3_Activity.this, Set2Item1_Activity.class);
            		else if(count==2)
            			intent = new Intent(Set3Item3_Activity.this, Set4Item1_Activity.class);
            		else if(count==3)
            			intent = new Intent(Set3Item3_Activity.this, Set5Item1_Activity.class);
            	    startActivity(intent);
            	}
            	else
            	{
            		Toast msg = Toast.makeText(getBaseContext(), "PLEASE ENTER A NUMBER",Toast.LENGTH_LONG);
            	    msg.show();
            	}
            }
        });*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.set3_item3_, menu);
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
