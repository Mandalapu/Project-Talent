package com.example.projecttalentoriginal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

@SuppressLint("SimpleDateFormat")
public class W013_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_w013_);
		JSONObject obj = new JSONObject();
		Date end = new Date();
		String s = MyGlobalVariables.getData();
		s+="sec_wrap_end:"+end.toString()+";";
		s+="sur_end:"+end.toString()+";";
		MyGlobalVariables.setData(s);
		String final_data = MyGlobalVariables.getData();
		String f = Environment.getExternalStorageDirectory()+"/"+MyGlobalVariables.getUserName();
		String timeStamp = new SimpleDateFormat("_MMdd_HHmm").format(new Date());
		String fileName=f+ "/final_data_"+MyGlobalVariables.getUserName()+timeStamp+".txt";

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
		for(int i=0;i<d.length;i++) {
			String tag = d[i].substring(0,d[i].indexOf(':'));
			String value = d[i].substring(d[i].indexOf(':')+1);
			boolean intg=false;
			if(tag.contains("_start") || tag.contains("_end")) {
				SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
				Date n=null;
				try {
					n = sdf.parse(value);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				value = df.format(n);
				try {
					obj.put(tag,value);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(tag.equals("birthmonth")) {
				int m=0;
				String[] mon={"","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
				m=Arrays.asList(mon).indexOf(value);
				try {
					obj.put(tag,m);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(tag.equals("username")) {

				int user_nm=Integer.parseInt(value);
				String user_name_formatted=String.format("%05d",user_nm);
				try {
					obj.put(tag, user_name_formatted);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try
				{
					Integer.parseInt(value);
					intg=true;
				} catch (NumberFormatException ex)
				{
					intg=false;
				}
				if(intg){
					try {
						obj.put(tag, Integer.parseInt(value));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					try {
						obj.put(tag, value);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			fileName=f+ "/final_data_"+MyGlobalVariables.getUserName()+timeStamp+".json";
			//fileName=f+ "/final_data_"+MyGlobalVariables.getUserName()+".json";
			try {
				File myFile = new File(fileName);
				myFile.createNewFile();
				FileOutputStream fOut = new FileOutputStream(myFile);
				OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
				myOutWriter.append(obj.toString());
				myOutWriter.close();
				fOut.close();
			} catch (Exception e) {
			}
		}


	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.w013_, menu);
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