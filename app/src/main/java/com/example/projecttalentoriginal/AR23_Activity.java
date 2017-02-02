package com.example.projecttalentoriginal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AR23_Activity extends Activity {
	boolean[] selected={false,false,false,false,false};
	boolean click = false; int count=0;long ms;boolean empty=false;int count1=0;
	ImageView img1,img2,img3,img4,img5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ar23_);
		Date start = new Date();
		String s = MyGlobalVariables.getTime();		
		s+="ar23_start:"+start.toString()+";";
		MyGlobalVariables.setTime(s);
		ImageView myImage = (ImageView) findViewById(R.id.question_image);
	    myImage.setImageBitmap(decodeImage(getResources(),R.drawable.ar_11_main,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    myImage = (ImageView) findViewById(R.id.imageView1);
	    myImage.setImageBitmap(decodeImage(getResources(),R.drawable.ar_11_1,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    myImage = (ImageView) findViewById(R.id.imageView2);
	    myImage.setImageBitmap(decodeImage(getResources(),R.drawable.ar_11_2,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    myImage = (ImageView) findViewById(R.id.imageView3);
	    myImage.setImageBitmap(decodeImage(getResources(),R.drawable.ar_11_3,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    myImage = (ImageView) findViewById(R.id.imageView4);
	    myImage.setImageBitmap(decodeImage(getResources(),R.drawable.ar_11_4,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
	    
	    myImage = (ImageView) findViewById(R.id.imageView5);
	    myImage.setImageBitmap(decodeImage(getResources(),R.drawable.ar_11_5,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
		
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
		    		String s = MyGlobalVariables.getData();
	            	String ans= s.substring(s.indexOf("ar21:"));
	        		String[] l = new String[3];
	        		l = ans.split(";");count1=0;
	        		s=s.substring(0,s.indexOf("ar21:"));
	        		for(int i = 0;i<3;i++){
	        			if(i==0 && l[i].substring(l[i].indexOf(':')+1).equals("5")) {count1++;s+="ar21_score:1;";s+="ar21_ans:5;";}
	        			else if(i==1 && l[i].substring(l[i].indexOf(':')+1).equals("2")) {count1++;s+="ar22_score:1;";s+="ar22_ans:2;";}
	        			else if(i==2 && l[i].substring(l[i].indexOf(':')+1).equals("3")) {count1++;s+="ar23_score:1;";s+="ar23_ans:3;";}
	        			else
	        			{
	        				if(i==0){s+="ar21_score:0;";s+="ar21_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
	        				else if(i==1){s+="ar22_score:0;";s+="ar22_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
	        				else if(i==2){s+="ar23_score:0;";s+="ar23_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
	        			}
	        		}
	        		MyGlobalVariables.setData(s);

	        		TextView tv = (TextView) findViewById(R.id.message);
	        		tv.setVisibility(View.INVISIBLE);
	        		Date end = new Date();
		       		s = MyGlobalVariables.getTime();
		       		s+="ar23_end:"+end.toString()+";";
		       		s+="sec_ar_end:"+end.toString()+";";
		       		String t=MyGlobalVariables.getData();
		       		t+=s;MyGlobalVariables.setData(t);
		       		MyGlobalVariables.setTime("");
	        		Intent intent=null;
					create_textfile();
	        		intent = new Intent(AR23_Activity.this, SecVO_Activity.class);
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
    		if (s.contains("ar23:")){
    			int p=s.indexOf("ar23:");
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
        		s+="ar23:"+Integer.toString(u)+";";
        	}
        	else
        	{
        		s+="ar23:0"+";";
        		
            		TextView tv = (TextView) findViewById(R.id.message);
            		String t = getResources().getString(R.string.msg3);
       				 tv.setText(t);
       				 tv.setVisibility(View.VISIBLE);
       				 empty=true;
        	}
        	MyGlobalVariables.setData(s);
        	if((click && count>=2)){
        		click = false;
      		s = MyGlobalVariables.getData();
          	String ans= s.substring(s.indexOf("ar21:"));
      		String[] l = new String[3];
      		l = ans.split(";");count1=0;
      		s=s.substring(0,s.indexOf("ar21:"));
    		for(int i = 0;i<3;i++){
    			if(i==0 && l[i].substring(l[i].indexOf(':')+1).equals("5")) {count1++;s+="ar21_score:1;";s+="ar21_ans:5;";}
    			else if(i==1 && l[i].substring(l[i].indexOf(':')+1).equals("2")) {count1++;s+="ar22_score:1;";s+="ar22_ans:2;";}
    			else if(i==2 && l[i].substring(l[i].indexOf(':')+1).equals("3")) {count1++;s+="ar23_score:1;";s+="ar23_ans:3;";}
    			else
    			{
    				if(i==0){s+="ar21_score:0;";s+="ar21_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
    				else if(i==1){s+="ar22_score:0;";s+="ar22_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
    				else if(i==2){s+="ar23_score:0;";s+="ar23_ans:"+l[i].substring(l[i].indexOf(':')+1)+";";}
    			}
    		}
    		MyGlobalVariables.setData(s);

      		TextView tv = (TextView) findViewById(R.id.message);
      		tv.setVisibility(View.INVISIBLE);
      		Date end = new Date();
       		s = MyGlobalVariables.getTime();
       		s+="ar23_end:"+end.toString()+";";
       		s+="sec_ar_end:"+end.toString()+";";
       		String t=MyGlobalVariables.getData();
       		t+=s;MyGlobalVariables.setData(t);
       		MyGlobalVariables.setTime("");
      		Intent intent=null;
				create_textfile();
      		intent = new Intent(AR23_Activity.this, SecVO_Activity.class);
      		startActivity(intent);
        	}
        }
    });
	}
    public static Bitmap decodeImage(Resources res,int resId, int reqWidth,int reqHeight){
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
	public void create_textfile()
	{
		String f = Environment.getExternalStorageDirectory()+"/"+MyGlobalVariables.getUserName();
		String timeStamp = new SimpleDateFormat("_MMdd_HHmm").format(new Date());
		String fileName=f+ "/AR_"+MyGlobalVariables.getUserName()+timeStamp+".txt";
		String final_data = MyGlobalVariables.getData();
		String[] d = final_data.split(";");
		try {
			File myFile = new File(fileName);
			myFile.createNewFile();
			FileOutputStream fOut = new FileOutputStream(myFile);
			OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
			for(int i=0;i<d.length;i++)
				myOutWriter.append(d[i]+"\n");
			myOutWriter.close();
			fOut.close();
		} catch (Exception e) {
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ar23_, menu);
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
