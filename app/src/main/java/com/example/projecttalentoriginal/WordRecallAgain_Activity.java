package com.example.projecttalentoriginal;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class WordRecallAgain_Activity extends Activity {
	Handler handler;
 	//TextView tv;
 	MediaRecorder mRecorder;
 	String fileName;
 	Boolean isRecording;
 	int recordTime;//,playTime;
 	SeekBar seekBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word_recall_again_);
		Date start = new Date();
		String s = MyGlobalVariables.getData();
		s+="d148_start:"+start.toString()+";";
		MyGlobalVariables.setData(s);
		seekBar=(SeekBar)findViewById(R.id.seek1);
	    seekBar.setMax(60);
        handler=new Handler();
        String f = Environment.getExternalStorageDirectory()+"/"+MyGlobalVariables.getUserName();
		String timeStamp = new SimpleDateFormat("_MMdd_HHmm").format(new Date());
		fileName=f+ "/DR_"+MyGlobalVariables.getUserName()+timeStamp+".mp3";
        isRecording=false;
	}
	 public void startRecording(View view){
		 Button btn = (Button) findViewById(R.id.tbrecord);
		 btn.setVisibility(View.INVISIBLE);
	    	if(!isRecording){
	    	 //Create MediaRecorder and initialize audio source, output format, and audio encoder	
	    	  mRecorder = new MediaRecorder();
	       mRecorder.setAudioSource( MediaRecorder.AudioSource.MIC);
	       mRecorder.setOutputFormat( MediaRecorder.OutputFormat.THREE_GPP);
	       mRecorder.setOutputFile(fileName);
	       mRecorder.setAudioEncoder( MediaRecorder.AudioEncoder.AMR_NB);
	       // Starting record time
	       recordTime=0;
	       // Show TextView that displays record time
	       //tv.setVisibility(TextView.VISIBLE);
	       try {
	          mRecorder.prepare();
	       } catch (IOException e) {
	          Log.e("LOG_TAG", "prepare failed");
	       }
	       	// Start record job
	       	mRecorder.start();
	       	// Change isRecroding flag to true
	       	isRecording=true;
	       	// Post the record progress
	       	handler.post(UpdateRecordTime);
	    	}
	    }
	    public void stopRecording(){
	    	if(isRecording){
	    		// Stop recording and release resource
	    		mRecorder.stop();
	    		mRecorder.release();
	    		mRecorder = null;
	    		// Change isRecording flag to false
	    		isRecording=false;
	    		Date end = new Date();
        		String s = MyGlobalVariables.getData();
        		s+="d148_duration:60;d148_end:"+end.toString()+";";
				Date sec_d_end = new Date();
				s += "sec_d_end:"+sec_d_end.toString()+";";
        		MyGlobalVariables.setData(s);
	    		Intent intent = new Intent(WordRecallAgain_Activity.this, SecAR_Activity.class);
	    	    startActivity(intent);
	    		// Hide TextView that shows record time
	    		//tv.setVisibility(TextView.GONE);
	    		//seekBar.setProgress(0);
//	    		playIt(); // Play the audio
//	    		tv=(TextView)findViewById(R.id.textView1);
//	    	    tv.setVisibility(TextView.VISIBLE);
	    	}
	    }
	    Runnable UpdateRecordTime=new Runnable(){
	    	  public void run(){
	    	  if(isRecording){
	    		   //tv.setText(String.valueOf(recordTime));     		
	    		   recordTime+=1;
	    		   seekBar.setProgress(recordTime);
	    		   
	    		    // Delay 1s before next call   		   
	    		   handler.postDelayed(this, 1000);
	    		   if(recordTime==60)
	    		   {
	    			   //View v=(View)findViewById(R.id.tbstop);
	    			   stopRecording();
	    		   }
	    	  			}
	    	  		}
	    	  };

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.word_recall_again_, menu);
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
