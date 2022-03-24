package com.example.mdhhcd;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.AsyncTask;

import java.io.InputStream;

public class SendData extends AsyncTask<Void, Void, Integer> {

    private Context context;
    private InputStream input;
    private BluetoothDevice target;

    public SendData(InputStream input, BluetoothDevice target, Context context)
    {
        this.context = context;
        this.target = target;
        this.input = input;
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        return null;
    }
}
