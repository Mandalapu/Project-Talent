package com.example.projecttalentoriginal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class W018_Activity extends Activity {
	RadioGroup radioGroup;
	RadioButton radioButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_w018_);
		Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
            	int selectedId = radioGroup.getCheckedRadioButtonId();
            	if (selectedId == -1) {
            		Intent intent = new Intent(W018_Activity.this, W019_Activity.class);
	        	    startActivity(intent);
            	}
            	else {
	                radioButton = (RadioButton)findViewById(selectedId);
	               // MyGlobalVariables g = new MyGlobalVariables();
	        		String s = MyGlobalVariables.getData();
	        		if (s.contains("w018:")){
	        			int p=s.indexOf("w018:");
	        			s = s.substring(0,p);
	        		}
	        		s+="w018:"+ radioButton.getText() +";";
	        		MyGlobalVariables.setData(s);	
	        		Intent intent = new Intent(W018_Activity.this, W019_Activity.class);
	        	    startActivity(intent);
            	}
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.w018_, menu);
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
