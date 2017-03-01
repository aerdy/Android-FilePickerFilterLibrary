package com.necistudio.filepickerdocumentlibrary;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.necistudio.libarary.FilePickerActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnPick;
    private TextView txtPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPick = (Button) findViewById(R.id.btnPick);
        txtPath = (TextView)findViewById(R.id.txtPath);
        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FilePickerActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String path = data.getStringExtra("path");
                txtPath.setText(path);
                Log.e("data",path);
            }else{
                Log.e("data","cance");
            }
        }
    }
}
