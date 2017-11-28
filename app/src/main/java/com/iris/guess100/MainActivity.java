package com.iris.guess100;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
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
        this.findViews();
    }
    int i = (int)(Math.random()*100)+1;
    int min = 1;
    int max = 100;
    public void findViews() {

        EditText edNumber = (EditText) findViewById(R.id.number);
        TextView tvSecert = (TextView) findViewById(R.id.secret);
        TextView tvInfo = (TextView) findViewById(R.id.info);
        Button btSend = (Button) findViewById(R.id.send);
        String secert = String.valueOf(i);
        tvSecert.setText(secert);
    }
    public void send(View view) {
        final EditText edNumber = (EditText) findViewById(R.id.number);
        int number = Integer.parseInt(edNumber.getText().toString());
        //String secert = String.valueOf(i);
        //TextView tvSecert = (TextView) findViewById(R.id.secret);
        //tvSecert.setText(secert);
        if (number < i && number < max && number > min) {
            min = number;
            new AlertDialog.Builder(this)
                    .setMessage(min + " to " + max)
                    .setPositiveButton("Ok", null)
                    .show();
            edNumber.setText("");
        } else if (number > i && number < max && number > min) {
            max = number;
            new AlertDialog.Builder(this)
                    .setMessage(min + " to " + max)
                        .setPositiveButton("Ok", null)
                        .show();
            edNumber.setText("");
            } else if (number > max || number < min) {
                    new AlertDialog.Builder(this)
                        .setMessage("請輸入" + min + " to " + max)
                        .setPositiveButton("Ok", null)
                        .show();
            edNumber.setText("");
            } else if (number == i) {
                    new AlertDialog.Builder(this)
                        .setMessage("答對了")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int re) {
                                int i2 = (int)(Math.random()*100)+1;
                                min = 1;
                                max = 100;
                                String secert = String.valueOf(i2);
                                TextView tvSecert = (TextView) findViewById(R.id.secret);
                                tvSecert.setText(secert);
                                edNumber.setText("");
                                i = i2;
                            }

                        })
                        .show();

            }

        }


}
