package com.calc.calculator;

import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	public TextView tv;
	public String display = "";
	public String Currentoperator = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView) findViewById(R.id.out);
		tv.setText(display);
	}
	
	private void updatescreen() {
		tv.setText(display);
	}

	public void onClickNumber(View v) {
		Button b = (Button) v;
		display += b.getText();
		updatescreen();
	}

	public void onClickOpreator(View v) {
		Button b = (Button) v;
		display += b.getText();
		Currentoperator = b.getText().toString();
		updatescreen();
	}

	public void Clear() {
		display = "";
		Currentoperator = "";
	}
	
	public void onClickClear(View v){
		Clear();
		updatescreen();
	}

	public double operation(String a, String b, char op) {
		switch (op) {
		case '+':
			return Double.valueOf(a) + Double.valueOf(b);
		case '-':
			return Double.valueOf(a) - Double.valueOf(b);
		case '*':
			return Double.valueOf(a) * Double.valueOf(b);
		case '/':
			try {
				return Double.valueOf(a) / Double.valueOf(b);
			} catch (Exception e) {
				Log.d("Calc", e.getMessage());
			}
		default:
			return 1;
		}
	}

	public void onClickEqul(View v) {
		String[] operation = display.split(Pattern.quote(Currentoperator));
		if (operation.length < 2)
			return;
		Double result = operation(operation[0], operation[1], Currentoperator.charAt(0));

		tv.setText(display + "\n" + String.valueOf(result));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
