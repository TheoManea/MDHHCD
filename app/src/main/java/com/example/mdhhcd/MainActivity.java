package com.example.mdhhcd;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Button btnSend;
    private ArrayList<String> listeDevices = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.button);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // première étape on regarde si le bluetooth est activé, sinon ça sert à rien de continuer le process
                if(!checkBluetooth())
                {
                    Toast toast = Toast.makeText(MainActivity.this,
                            "Merci d'activer le bluetooth avant de pouvoir continuer " , Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    // si le bluetooth et activé on peut commencer à chercher les appareils distants
                    getAllBluetoothDevices();
                }
            }
        });

    }

    private void getAllBluetoothDevices()
    {
        // on vide l'array pour éviter les doublons si il y a déjà eu une recherche au préalable
        this.listeDevices.clear();

        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        for (BluetoothDevice device : bluetoothAdapter.getBondedDevices())
            this.listeDevices.add(device.getName() + System.lineSeparator() + device.getAddress());

        System.out.println("--------------------------------------------------- Liste des appareils bluetooth : ---------------------------------------------------\n");

        for(String d : this.listeDevices)
            System.out.println(d);

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------\n");

    }

    private boolean checkBluetooth(){
        BluetoothAdapter myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(myBluetoothAdapter.isEnabled()){
            return true;
        } else {
            return false;
        }
    }

}