package com.example.deepak.jobintentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, ExampleJobIntentService.class);
        intent.putExtra("input", editText.getText().toString());
        ExampleJobIntentService.enqueueWork(this,intent);
    }
}
