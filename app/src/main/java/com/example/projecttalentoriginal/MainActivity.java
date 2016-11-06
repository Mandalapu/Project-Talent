package com.example.projecttalentoriginal;




import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Date start = new Date();
		String s = MyGlobalVariables.getData();
		s+="sur_start:"+start.toString()+";";
		MyGlobalVariables.setData(s);
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
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	if (u.length()!=0)
            	{
            		//MyGlobalVariables g = new MyGlobalVariables();
            		if(u.length()>5){
            			Toast.makeText(getBaseContext(), "USERNAME SHOULD NOT BE MORE THAN 5 DIGITS",Toast.LENGTH_LONG).show();
                    	uid.setText("");
            		}
            		else{
            		MyGlobalVariables.setUserName(u);
            		String s = MyGlobalVariables.getData();
            		if (s.contains("username:")){
            			int p=s.indexOf("username:");
            			s = s.substring(0,p);
            		}
            		s+="username:"+u+";";
            		MyGlobalVariables.setData(s);
            		Intent intent = new Intent(MainActivity.this, AgreementActivity.class);
//            	    EditText editText = (EditText) findViewById(R.id.edit_message);
//            	    String message = editText.getText().toString();
//            	    intent.putExtra(EXTRA_MESSAGE, message);
            	    startActivity(intent);
            		}
            	}
            	else
            	{
            		Toast msg = Toast.makeText(getBaseContext(), "PLEASE ENTER YOUR USERNAME",Toast.LENGTH_LONG);
            	    msg.show();
            	}

            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
