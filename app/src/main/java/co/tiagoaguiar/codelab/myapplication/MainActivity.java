package co.tiagoaguiar.codelab.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private View btnhs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnhs = findViewById(R.id.btn_hs);

		btnhs.setOnClickListener(view -> {
			Intent intent = new Intent(MainActivity.this, MenuActivity.class);
			startActivity(intent);
		});
	}
}