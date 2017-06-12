package com.example.t_jiyada.weatherapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class showact extends AppCompatActivity {

    static TextView placetv;
    static TextView temptv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showact);

        placetv = (TextView) findViewById(R.id.tt2);
        temptv = (TextView) findViewById(R.id.tt1);

        Bundle data = getIntent().getExtras();

        if(data==null){
            return;
        }


        String name = data.getString("message");

        DownloadTask task = new DownloadTask();
        task.execute("http://api.openweathermap.org/data/2.5/weather?q="+name+"&appid=0249ace57a95b26b61308516f85df240");

       // placetv.setText(name);

    }
    public void onnnclick(View view){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
