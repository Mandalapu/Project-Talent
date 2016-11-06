package com.example.projecttalentoriginal;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SP21_Activity extends Activity {
	boolean[] selected={false,false,false,false,false};
	ImageView img1,img2,img3,img4,img5;
	boolean click = false; int count=0;long ms;boolean empty=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sp21_);
		Date start = new Date();
		String s = MyGlobalVariables.getTime();		
		s+="sp21_start:"+start.toString()+";";
		MyGlobalVariables.setTime(s);
		ImageView myImage = (ImageView) findViewById(R.id.question_image);
	    myImage.setImageBitmap(decodeImage(getResources(),R.drawable.sp_7_main,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    myImage = (ImageView) findViewById(R.id.imageView1);
	    myImage.setImageBitmap(decodeImage(getResources(),R.drawable.sp_7_1,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    myImage = (ImageView) findViewById(R.id.imageView2);
	    myImage.setImageBitmap(decodeImage(getResources(),R.drawable.sp_7_2,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    myImage = (ImageView) findViewById(R.id.imageView3);
	    myImage.setImageBitmap(decodeImage(getResources(),R.drawable.sp_7_3,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    myImage = (ImageView) findViewById(R.id.imageView4);
	    myImage.setImageBitmap(decodeImage(getResources(),R.drawable.sp_7_4,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    myImage = (ImageView) findViewById(R.id.imageView5);
	    myImage.setImageBitmap(decodeImage(getResources(),R.drawable.sp_7_5,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
		
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
		    		TextView tv = (TextView) findViewById(R.id.message);
	        		tv.setVisibility(View.INVISIBLE);
	        		Date end = new Date();
	        		String s = MyGlobalVariables.getTime();
	        		s+="sp21_end:"+end.toString()+";";
	        		MyGlobalVariables.setTime(s);
		    		Intent intent = new Intent(SP21_Activity.this, SP22_Activity.class);
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
           	click = true;count++;
           	String s = MyGlobalVariables.getData();
       		if (s.contains("sp21:")){
       			int p=s.indexOf("sp21:");
       			s = s.substring(0,p);
       		}
           	if (selected[0] || selected[1] || selected[2] || selected[3] || selected[4])
           	{
           		int u=0;
           		if(selected[0])u=1;
           		else if(selected[1])u=2;
           		else if(selected[2])u=3;
           		else if(selected[3])u=4;
           		else if(selected[4])u=5;
           		s+="sp21:"+Integer.toString(u)+";";
           	}
           	else
           	{
           		s+="sp21:0"+";";
           		
               		TextView tv = (TextView) findViewById(R.id.message);
               		String t = getResources().getString(R.string.msg3);
          				 tv.setText(t);
          				 tv.setVisibility(View.VISIBLE);
          				 empty=true;
           	}
           	MyGlobalVariables.setData(s);
           	if((click && count>=2)){
           		click = false;
           		TextView tv = (TextView) findViewById(R.id.message);
           		tv.setVisibility(View.INVISIBLE);
           		Date end = new Date();
        		 s = MyGlobalVariables.getTime();
        		s+="sp21_end:"+end.toString()+";";
        		MyGlobalVariables.setTime(s);
           		Intent intent = new Intent(SP21_Activity.this, SP22_Activity.class);
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
		getMenuInflater().inflate(R.menu.sp21_, menu);
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
