package com.example.projecttalentoriginal;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NumberQuestions_Activity extends Activity {
	boolean empty=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_number_questions_);
		Date start = new Date();
		String s = MyGlobalVariables.getTime();
		s+="d178_start:"+start.toString()+";";
		MyGlobalVariables.setTime(s);
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
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	if (u.length()!=0)
            	{
            		//MyGlobalVariables g = new MyGlobalVariables();
            		
            		String s = MyGlobalVariables.getData();
            		if (s.contains("d178:")){
            			int p=s.indexOf("d178:");
            			s = s.substring(0,p);
            		}
            		s+="d178:"+u+";";
            		MyGlobalVariables.setData(s);
            		Date end = new Date();
            		 s = MyGlobalVariables.getTime();
            		s+="d178_end:"+end.toString()+";";
            		MyGlobalVariables.setTime(s);
            		Intent intent = new Intent(NumberQuestions_Activity.this, NumberQuestionsNext_Activity.class);
            	    startActivity(intent);
            	}
            	else if(u.length()==0 && !empty)
            	{
            		TextView tv = (TextView) findViewById(R.id.textView1);
            		tv.setVisibility(View.VISIBLE);
            		empty=true;
            	}
            	else if(u.length()==0 && empty)
            	{
            		Date end = new Date();
            		String s = MyGlobalVariables.getTime();
            		s+="d178_end:"+end.toString()+";";
            		MyGlobalVariables.setTime(s);
            		Intent intent = new Intent(NumberQuestions_Activity.this, NumberQuestionsNext_Activity.class);
            	    startActivity(intent);
            	}

            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.number_questions_, menu);
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
