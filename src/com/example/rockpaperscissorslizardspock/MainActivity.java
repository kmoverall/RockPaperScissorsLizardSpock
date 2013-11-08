package com.example.rockpaperscissorslizardspock;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	    Button joinButton = (Button)findViewById(R.id.button2);
	    
	    joinButton.setOnClickListener(new View.OnClickListener() {

	      @Override
	      public void onClick(View view) {
	        Intent intent = new Intent(MainActivity.this, JoinGame.class);
	        EditText editText=(EditText)findViewById(R.id.editPersonName);
	        String name = editText.getText().toString();
	        intent.putExtra("name", name);
	        startActivity(intent);
	      }

	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
