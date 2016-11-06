package com.example.projecttalentoriginal;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
 
 public class AudioRecordTest extends ActionBarActivity {
 	Handler handler;
 	TextView tv;
 	MediaRecorder mRecorder;
 	String fileName;
 	Boolean isRecording;
 	int recordTime,playTime;
 	SeekBar seekBar;
 	MediaPlayer mPlayer;
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_audio_record_test); 
       //tv=(TextView)findViewById(R.id.txttime);
       seekBar=(SeekBar)findViewById(R.id.seek1);
       seekBar.setMax(10);
       handler=new Handler();
       String f = Environment.getExternalStorageDirectory()+"/"+MyGlobalVariables.getUserName();
       File userDirectory = new File(f);
       userDirectory.mkdirs();
		String timeStamp = new SimpleDateFormat("_MMdd_HHmm").format(new Date());
		fileName=f+ "/AT_"+MyGlobalVariables.getUserName()+timeStamp+".mp3";
       isRecording=false;
       Button button = (Button) findViewById(R.id.button3);
       button.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               // Perform action on click
           	     	mPlayer.stop();
	        		Intent intent = new Intent(AudioRecordTest.this, SecD_Activity.class);
	        	    startActivity(intent);
           }
       });
    
       
    }
    
    public void startRecording(View view){
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
    public void stopRecording(View view){
    	if(isRecording){
    		// Stop recording and release resource
    		mRecorder.stop();
    		mRecorder.release();
    		mRecorder = null;
    		// Change isRecording flag to false
    		isRecording=false;
    		// Hide TextView that shows record time
    		//tv.setVisibility(TextView.GONE);
    		seekBar.setProgress(0);
    		playIt(); // Play the audio
    		tv=(TextView)findViewById(R.id.textView1);
    	    tv.setVisibility(TextView.VISIBLE);
    	    Button btn=(Button) findViewById(R.id.button3);
    	    btn.setVisibility(View.VISIBLE);
    	}
    }
    
    public void playIt(){
    	// Create MediaPlayer object
    	mPlayer = new MediaPlayer();
    	// set start time
    	playTime=0;
    	// Reset max and progress of the SeekBar
    	seekBar.setMax(recordTime);
    	seekBar.setProgress(0);
       try {
       	// Initialize the player and start playing the audio
         mPlayer.setDataSource(fileName);
         mPlayer.prepare();
         mPlayer.start();
         // Post the play progress
         handler.post(UpdatePlayTime);
       } catch (IOException e) {
         Log.e("LOG_TAG", "prepare failed");
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
    		   if(recordTime==10)
    		   {
    			   View v=(View)findViewById(R.id.tbstop);
    			   stopRecording(v);
    		   }
    	  			}
    	  		}
    	  };
    Runnable UpdatePlayTime=new Runnable(){
       	  public void run(){
       	  if(mPlayer.isPlaying()){
       		   //tv.setText(String.valueOf(playTime)); 
       		   // Update play time and SeekBar
       		   playTime+=1;      		        		   
       		   seekBar.setProgress(playTime);
       		   // Delay 1s before next call
       		   handler.postDelayed(this, 1000);
       	  			}
       	  		}
       	  };
    
   
 }