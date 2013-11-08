package com.example.rockpaperscissorslizardspock;

<<<<<<< HEAD
=======
import android.R.string;
>>>>>>> 990327cb707df087fdda709bd333e1ab78c07d80
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
<<<<<<< HEAD

=======
>>>>>>> 990327cb707df087fdda709bd333e1ab78c07d80

public class MainActivity extends Activity {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
<<<<<<< HEAD

	    Button joinButton = (Button)findViewById(R.id.button2);
	    
	    joinButton.setOnClickListener(new View.OnClickListener() {

	      @Override
	      public void onClick(View view) {
	        Intent intent = new Intent(MainActivity.this, JoinGame.class);
	        
	        String name = ((EditText)findViewById(R.id.editText1)).getText().toString();
	        
	        intent.putExtra("name", name);
	        startActivity(intent);
	      }

	    });
=======
	
	

	
	
>>>>>>> 990327cb707df087fdda709bd333e1ab78c07d80
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
