package com.example.projecttalentoriginal;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SPpractice_Activity extends Activity {
	boolean[] selected={false,false,false,false,false};
	ImageView img1,img2,img3,img4,img5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sppractice_);
		ImageView myImage = (ImageView) findViewById(R.id.question_image);
	    myImage.setImageBitmap(decodeImage(getResources(),R.drawable.sp_001_main,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    img1 = (ImageView) findViewById(R.id.imageView1);
	    img1.setImageBitmap(decodeImage(getResources(),R.drawable.sp_001_1,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    img2 = (ImageView) findViewById(R.id.imageView2);
	    img2.setImageBitmap(decodeImage(getResources(),R.drawable.sp_001_2,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    img3 = (ImageView) findViewById(R.id.imageView3);
	    img3.setImageBitmap(decodeImage(getResources(),R.drawable.sp_001_3,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    img4 = (ImageView) findViewById(R.id.imageView4);
	    img4.setImageBitmap(decodeImage(getResources(),R.drawable.sp_001_4,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    img5 = (ImageView) findViewById(R.id.imageView5);
	    img5.setImageBitmap(decodeImage(getResources(),R.drawable.sp_001_5,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
		
	   
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
	            		Intent intent = new Intent(SPpractice_Activity.this, SPpracticeCorrect_Activity.class);
	            		startActivity(intent);
	            	}
	            	else {
	            		Intent intent = new Intent(SPpractice_Activity.this, SPpracticeWrong_Activity.class);
	            		startActivity(intent);
	            	}
	            		
	            	
	            }
	        });
	}
	public static Bitmap decodeImage(Resources res,int resid,int WIDTH,int HIGHT){
		 //Decode image size
		 BitmapFactory.Options o = new BitmapFactory.Options();
		 o.inJustDecodeBounds = true;
		 BitmapFactory.decodeResource(res,resid,o);

		 //The new size we want to scale to
		 final int REQUIRED_WIDTH=WIDTH;
		 final int REQUIRED_HIGHT=HIGHT;
		 //Find the correct scale value. It should be the power of 2.
		 int scale=1;
		 while(o.outWidth/scale/2>=REQUIRED_WIDTH && o.outHeight/scale/2>=REQUIRED_HIGHT)
		     scale*=2;

		 //Decode with inSampleSize
		 BitmapFactory.Options o2 = new BitmapFactory.Options();
		 o2.inSampleSize=scale;
		 return BitmapFactory.decodeResource(res,resid, o2);
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sppractice_, menu);
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
