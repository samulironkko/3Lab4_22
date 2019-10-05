package com.example.a3lab4_22;

import android.os.AsyncTask;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class AsyncClass extends AsyncTask<Integer, Integer, String> {

    private int progress = 0;
    private int id;
    private MyInterface callBackInterface;

    public interface MyInterface {
        void updateStatus(int progress, int id);
    }

    public AsyncClass(MyInterface myInterface, int i) {
        callBackInterface = myInterface;
        id = i;
    }


    @Override
    protected String doInBackground(Integer... integers) {
        try {
            while (progress < 100) {
                progress = progress + 10;
                publishProgress(progress);
                sleep(3000);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ("Complete");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        callBackInterface.updateStatus(progress, id);
    }

}
