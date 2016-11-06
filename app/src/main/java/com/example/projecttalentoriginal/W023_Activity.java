package com.example.projecttalentoriginal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class W023_Activity extends Activity {
	RadioButton radioButton1;
	RadioButton radioButton2;
	RadioButton radioButton3;
	RadioButton radioButton4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_w023_);
		Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	String s = MyGlobalVariables.getData();
            	if (s.contains("w023:")){
        			int p=s.indexOf("w023:");
        			s = s.substring(0,p);
        		}
            	radioButton1 = (RadioButton)findViewById(R.id.radioButton11);
            	radioButton2 = (RadioButton)findViewById(R.id.radioButton12);
            	radioButton3 = (RadioButton)findViewById(R.id.radioButton13);
            	radioButton4 = (RadioButton)findViewById(R.id.radioButton14);
            	if(radioButton1.isChecked())
            		s+="w023_desktop:daily;";
            	else if(radioButton2.isChecked())
            		s+="w023_desktop:weekly;";
            	else if(radioButton3.isChecked())
            		s+="w023_desktop:monthly;";
            	else if(radioButton4.isChecked())
            		s+="w023_desktop:never;";
            	radioButton1 = (RadioButton)findViewById(R.id.radioButton21);
            	radioButton2 = (RadioButton)findViewById(R.id.radioButton22);
            	radioButton3 = (RadioButton)findViewById(R.id.radioButton23);
            	radioButton4 = (RadioButton)findViewById(R.id.radioButton24);
            	if(radioButton1.isChecked())
            		s+="w023_laptop:daily;";
            	else if(radioButton2.isChecked())
            		s+="w023_laptop:weekly;";
            	else if(radioButton3.isChecked())
            		s+="w023_laptop:monthly;";
            	else if(radioButton4.isChecked())
            		s+="w023_laptop:never;";
            	radioButton1 = (RadioButton)findViewById(R.id.radioButton31);
            	radioButton2 = (RadioButton)findViewById(R.id.radioButton32);
            	radioButton3 = (RadioButton)findViewById(R.id.radioButton33);
            	radioButton4 = (RadioButton)findViewById(R.id.radioButton34);
            	if(radioButton1.isChecked())
            		s+="w023_tablet:daily;";
            	else if(radioButton2.isChecked())
            		s+="w023_tablet:weekly;";
            	else if(radioButton3.isChecked())
            		s+="w023_tablet:monthly;";
            	else if(radioButton4.isChecked())
            		s+="w023_tablet:never;";
            	radioButton1 = (RadioButton)findViewById(R.id.radioButton41);
            	radioButton2 = (RadioButton)findViewById(R.id.radioButton42);
            	radioButton3 = (RadioButton)findViewById(R.id.radioButton43);
            	radioButton4 = (RadioButton)findViewById(R.id.radioButton44);
            	if(radioButton1.isChecked())
            		s+="w023_ereader:daily;";
            	else if(radioButton2.isChecked())
            		s+="w023_ereader:weekly;";
            	else if(radioButton3.isChecked())
            		s+="w023_ereader:monthly;";
            	else if(radioButton4.isChecked())
            		s+="w023_ereader:never;";
            	radioButton1 = (RadioButton)findViewById(R.id.radioButton51);
            	radioButton2 = (RadioButton)findViewById(R.id.radioButton52);
            	radioButton3 = (RadioButton)findViewById(R.id.radioButton53);
            	radioButton4 = (RadioButton)findViewById(R.id.radioButton54);
            	if(radioButton1.isChecked())
            		s+="w023_smartphone:daily;";
            	else if(radioButton2.isChecked())
            		s+="w023_smartphone:weekly;";
            	else if(radioButton3.isChecked())
            		s+="w023_smartphone:monthly;";
            	else if(radioButton4.isChecked())
            		s+="w023_smartphone:never;";
            	radioButton1 = (RadioButton)findViewById(R.id.radioButton61);
            	radioButton2 = (RadioButton)findViewById(R.id.radioButton62);
            	radioButton3 = (RadioButton)findViewById(R.id.radioButton63);
            	radioButton4 = (RadioButton)findViewById(R.id.radioButton64);
            	if(radioButton1.isChecked())
            		s+="w023_mobile:daily;";
            	else if(radioButton2.isChecked())
            		s+="w023_mobile:weekly;";
            	else if(radioButton3.isChecked())
            		s+="w023_mobile:monthly;";
            	else if(radioButton4.isChecked())
            		s+="w023_mobile:never;";
            	MyGlobalVariables.setData(s);
            	Intent intent = new Intent(W023_Activity.this, W014_Activity.class);
        	    startActivity(intent);
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.w023_, menu);
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
