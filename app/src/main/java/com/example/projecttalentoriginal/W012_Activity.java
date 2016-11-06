package com.example.projecttalentoriginal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class W012_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_w012_);
		Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText et = (EditText) findViewById(R.id.editText1);
            	String st= et.getText().toString();
            	if (st.length()==0) {
            		Intent intent = new Intent(W012_Activity.this, W013_Activity.class);
	        	    startActivity(intent);
            	}
            	else {
	               
	        		String s = MyGlobalVariables.getData();
	        		if (s.contains("w012:")){
	        			int p=s.indexOf("w012:");
	        			s = s.substring(0,p);
	        		}
	        		s+="w012:"+st+";";
	        		MyGlobalVariables.setData(s);	
	        		Intent intent = new Intent(W012_Activity.this, W013_Activity.class);
	        	    startActivity(intent);
            	}
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.w012_, menu);
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
