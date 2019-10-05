package com.example.a3lab4_22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AsyncClass.MyInterface {

    int counter = 1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        textView = findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        startAsync();
    }

    public void updateStatus(int progress, int id){
        textView.append("\nThread: " + id + " On Progress: " + progress + "%");
        if (progress == 100) {
            textView.append("\nThread: " + id + " On_Complete");
        }
    }

    public void startAsync() {
        new AsyncClass(this, counter).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, counter);
        textView.append("\nNew thread created with Id:" + counter);
        counter++;
    }
}
