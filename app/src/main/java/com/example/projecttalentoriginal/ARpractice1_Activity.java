package com.example.projecttalentoriginal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ARpractice1_Activity extends Activity {
	boolean[] selected={false,false,false,false,false};
	ImageView img1,img2,img3,img4,img5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arpractice1_);
		
		img1 = (ImageView) findViewById(R.id.imageView1);
		img2 = (ImageView) findViewById(R.id.imageView2);
		img3 = (ImageView) findViewById(R.id.imageView3);
		img4 = (ImageView) findViewById(R.id.imageView4);
		img5 = (ImageView) findViewById(R.id.imageView5);
		img1.setPadding(1, 1, 1, 1);
		img2.setPadding(1, 1, 1, 1);
		img3.setPadding(1, 1, 1, 1);
		img4.setPadding(1, 1, 1, 1);
		img5.setPadding(1, 1, 1, 1);
        img1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	selected[0]=true;
            	selected[1]=false;
            	selected[2]=false;
            	selected[3]=false;
            	selected[4]=false;
            	img1.setBackgroundColor(Color.parseColor("#000000"));
            	img2.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img3.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img4.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img5.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	selected[0]=false;
            	selected[1]=true;
            	selected[2]=false;
            	selected[3]=false;
            	selected[4]=false;
            	img1.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img2.setBackgroundColor(Color.parseColor("#000000"));
            	img3.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img4.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img5.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	selected[0]=false;
            	selected[1]=false;
            	selected[2]=true;
            	selected[3]=false;
            	selected[4]=false;
            	img1.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img2.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img3.setBackgroundColor(Color.parseColor("#000000"));
            	img4.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img5.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	selected[0]=false;
            	selected[1]=false;
            	selected[2]=false;
            	selected[3]=true;
            	selected[4]=false;
            	img1.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img2.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img3.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img4.setBackgroundColor(Color.parseColor("#000000"));
            	img5.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	selected[0]=false;
            	selected[1]=false;
            	selected[2]=false;
            	selected[3]=false;
            	selected[4]=true;
            	img1.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img2.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img3.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img4.setBackgroundColor(Color.parseColor("#FFFFFF"));
            	img5.setBackgroundColor(Color.parseColor("#000000"));
            }
        });
        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	if(selected[4]) {
            		Intent intent = new Intent(ARpractice1_Activity.this, ARpracticeCorrect_Activity.class);
            		startActivity(intent);
            	}
            	else {
            		Intent intent = new Intent(ARpractice1_Activity.this, ARpracticeWrong_Activity.class);
            		startActivity(intent);
            	}
            		
            	
            }
        });
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(ARpractice1_Activity.this, ARans1_Activity.class);
            	startActivity(intent);
            	
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.arpractice1_, menu);
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
