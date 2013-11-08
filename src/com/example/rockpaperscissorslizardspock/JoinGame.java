package com.example.rockpaperscissorslizardspock;


import android.app.Activity;


import android.content.Intent;

import android.os.Bundle;


import android.view.Menu;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;


public class JoinGame extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_game);
    	
    	Button mJoin= (Button)findViewById(R.id.joinButton);
    	
    	mJoin.setOnClickListener(new View.OnClickListener(){
    		@Override
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    			Intent i = getIntent();
    			
    			Intent intent = new Intent(JoinGame.this,Game.class);
    		    
    		    String player = i.getStringExtra("name");
    		    
    		    EditText mHostName=(EditText)findViewById(R.id.editTextHostName);
    		    EditText mPortNumber=(EditText)findViewById(R.id.editTextPortNumber);
    		    
    		    
    		    String host = mHostName.getText().toString();
    			String port = mPortNumber.getText().toString();
    			
    		    intent.putExtra("player",player);
    		    intent.putExtra("host", host);
    		    intent.putExtra("port", port);
    		    startActivity(intent);

    			
    		    
    		}
    		
    	});
    
    
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.join_game, menu);
            return true;
    }
    
    
}