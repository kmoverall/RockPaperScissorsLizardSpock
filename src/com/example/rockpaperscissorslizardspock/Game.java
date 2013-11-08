package com.example.rockpaperscissorslizardspock;

import java.io.IOException;
import java.net.UnknownHostException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.javaclient.HTMLClient;

@SuppressLint("SetJavaScriptEnabled")
public class Game extends Activity {
	WebView webView;
	HTMLClient client;
	public void runCommand(final String cmd){
		System.err.println("JS cmd: "+cmd);
		this.runOnUiThread(new Runnable(){
			@Override
			public void run() {
				webView.loadUrl("javascript:"+cmd);
			}
		});
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		webView=(WebView) findViewById(R.id.webView1);
		Intent intent = getIntent();
		
		final Button valid;
		
		
		
		valid = new Button(this);
		valid.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					Intent intent = new Intent(Game.this,MainActivity.class);
					startActivity(intent);
			}
		});
		
		
		String port = "6666";
		port = intent.getStringExtra("port");
		int portNum = Integer.parseInt(port);
		String host = "10.20.63.3";
		host = intent.getStringExtra("host");
		String pName = "Mark";
		pName= intent.getStringExtra("player");
		
		try {
			client = new HTMLClient(portNum,host,pName,Game.this);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// add "client" var
		webView.addJavascriptInterface(client, "client");
		//add quitbutton to js interface
		webView.addJavascriptInterface(valid, "valid");
		
		// allow Web view to view pages
		webView.setWebViewClient(new WebViewClient(){
			@Override
			public void onPageFinished(WebView view, String url){
				// run game
				Thread t = new Thread(client);
				t.start();
			}
		});
		// enable alert()
		WebChromeClient alerts=new WebChromeClient();
		webView.setWebChromeClient(alerts);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("file:///android_asset/game.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

}
