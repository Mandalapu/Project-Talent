package com.example.projecttalentoriginal;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SecD_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec_d_);
		Date start = new Date();
		String s = MyGlobalVariables.getData();
		s+="sec_d_start:"+start.toString()+";";
		MyGlobalVariables.setData(s);
		 Button button = (Button) findViewById(R.id.button3);
	       button.setOnClickListener(new View.OnClickListener() {
	           public void onClick(View v) {
	               // Perform action on click
	           	     		
		        		Intent intent = new Intent(SecD_Activity.this, BackwardCount_Activity.class);
		        	    startActivity(intent);
	           }
	       });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sec_d_, menu);
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
