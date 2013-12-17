package com.hivebrain.glass.relax;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//import com.hivebrain.andrewjohnson.confidence.R;

import com.google.android.glass.media.Camera;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

        
        

		
		
		getWindow().setFormat(PixelFormat.TRANSLUCENT); 

		
		
		VideoView videoHolder = (VideoView) findViewById(R.id.videoView1);
		
        videoHolder = new VideoView(this); 
        videoHolder.setMediaController(new MediaController(this)); 
        setContentView(videoHolder); 

        
        String uriFormatString = "android.resource://" + getPackageName() + "/%d";
        String uriString = String.format(uriFormatString, R.raw.glassrelax);
        
        
        
        videoHolder.setVideoURI(Uri.parse(uriString)); 
        videoHolder.requestFocus(); 
        
        videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {


            	//mp.start();  //Un-comment this to loop
            	
            	finish();
            	
            }
        });
        
        
        
        videoHolder.start(); 
		
		
		
		
		

		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)  {
	      if (keyCode == KeyEvent.KEYCODE_BACK) {
	    	  
	    	  finish();
	    	  
	          return super.onKeyDown(keyCode,event);
	      }

	   return super.onKeyDown(keyCode, event);
	}

	


	
}
