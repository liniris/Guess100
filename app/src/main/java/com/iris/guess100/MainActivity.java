package com.iris.guess100;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void findViews(View view){
        
        EditText edNumber = (EditText) findViewById(R.id.number);
        TextView tvSecert = (TextView) findViewById(R.id.secret);
        TextView tvInfo = (TextView) findViewById(R.id.info);
        Button btSend = (Button) findViewById(R.id.send);
    }
}
