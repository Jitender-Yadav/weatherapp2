package com.example.t_jiyada.weatherapp2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.policy.*;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements AppPolicy {

    static EditText placetv;
    private static final String TAG = "JITU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placetv = (EditText) findViewById(R.id.t2);

        String name = placetv.getText().toString();
        if( MAMComponents.get(AppPolicy.class).getIsPinRequired()){
            Log.i(TAG,"iT IS TRUE");
        }
        else{
            Log.i(TAG,"It is false");
        }
    }
    public void onnclick(View view){

        Intent i = new Intent(this, showact.class);
        String name = placetv.getText().toString();
        i.putExtra("message",name);
        startActivity(i);
    }

    @Override
    public boolean getIsPinRequired() {
        return false;
    }
}
