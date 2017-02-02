package com.example.projecttalentoriginal;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ARpracticeWrong_Activity extends Activity {
	ImageView img1, img2, img3, img4, img5, img6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arpractice_wrong_);
		Button button = (Button) findViewById(R.id.button3);
		ImageView myImage = (ImageView) findViewById(R.id.question_image);
		myImage.setImageBitmap(decodeImage(getResources(),R.drawable.ar_002_main,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
		img1 = (ImageView) findViewById(R.id.imageView1);
		img1.setImageBitmap(decodeImage(getResources(),R.drawable.ar_002_1,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

		img2 = (ImageView) findViewById(R.id.imageView2);
		img2.setImageBitmap(decodeImage(getResources(),R.drawable.ar_002_2,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

		img3 = (ImageView) findViewById(R.id.imageView3);
		img3.setImageBitmap(decodeImage(getResources(),R.drawable.ar_002_3,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

		img4 = (ImageView) findViewById(R.id.imageView4);
		img4.setImageBitmap(decodeImage(getResources(),R.drawable.ar_002_4,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

		img5 = (ImageView) findViewById(R.id.imageView5);
        img5.setImageBitmap(decodeImage(getResources(),R.drawable.ar_002_5,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

        img6 = (ImageView) findViewById(R.id.imageView6);
        img6.setImageBitmap(decodeImage(getResources(),R.drawable.arrow_styled, myImage.getLayoutParams().width,myImage.getLayoutParams().height));

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            		Intent intent = new Intent(ARpracticeWrong_Activity.this, ARpractice2_Activity.class);
            		startActivity(intent);
            	
            }
        });
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(ARpracticeWrong_Activity.this, ARpractice1_Activity.class);
            	startActivity(intent);
            	
            }
        });
	}
    public static Bitmap decodeImage(Resources res, int resId, int reqWidth, int reqHeight){
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
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.arpractice_wrong_, menu);
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
