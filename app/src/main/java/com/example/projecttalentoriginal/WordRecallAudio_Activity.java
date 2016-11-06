package com.example.projecttalentoriginal;



import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;


public class WordRecallAudio_Activity extends Activity {
	Handler handler;
	TextView tv;
 	//TextView tv;
 	//MediaRecorder mRecorder;
 	String fileName;
 	//Boolean isRecording;
 	//int recordTime,
 	int playTime,duration;
 	SeekBar seekBar;
 	MediaPlayer mPlayer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word_recall_audio_);
		seekBar=(SeekBar)findViewById(R.id.seek1);
		handler=new Handler();
		playIt();		
	}
	public void playIt(){
    	// Create MediaPlayer object
    	mPlayer = MediaPlayer.create(this, R.raw.wr_2_cogusa);
    	duration = mPlayer.getDuration();
        duration/=1000;
        seekBar.setMax(duration);
    	// set start time
    	playTime=0;

    	// Reset max and progress of the SeekBar
    	
    	seekBar.setProgress(0);
       //mPlayer.prepare();
	 mPlayer.start();
	 // Post the play progress
	 handler.post(UpdatePlayTime);

       
    }
	Runnable UpdatePlayTime=new Runnable(){
     	  public void run(){
     	  if(mPlayer.isPlaying()){
     		   //tv.setText(String.valueOf(playTime)); 
     		   // Update play time and SeekBar
     		   playTime+=1;      		        		   
     		   seekBar.setProgress(playTime);
     		   if(seekBar.getProgress() == duration){
				   //repeatNo += 1;
				   //playTime = 0;
				   //handler.postDelayed(this, 3000);
				   //seekBar.setProgress(playTime);
				   //mPlayer.start();
						if(MyGlobalVariables.repeatNo==3) {
							Intent intent = new Intent(WordRecallAudio_Activity.this, WordRecallRecord_Activity.class);
							startActivity(intent);
						}
				   	else{
							MyGlobalVariables.repeatNo+=1;
							tv = (TextView) findViewById(R.id.message);
							String t = getResources().getString(R.string.repeatmsg);
							tv.setText(t);
							tv.setVisibility(View.VISIBLE);

							final Handler handler = new Handler();
							handler.postDelayed(new Runnable() {
								@Override
								public void run() {
									tv.setVisibility(View.INVISIBLE);

									Intent intent = new Intent(WordRecallAudio_Activity.this, WordRecallAudio_Activity.class);
									startActivity(intent);
								}
							}, 3000);



						}

     		   }
     		   // Delay 1s before next call
			  if(seekBar.getProgress() != duration)
     		   handler.postDelayed(this, 1000);
     	  			}
     	  		}
     	  };

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.word_recall_audio_, menu);
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
