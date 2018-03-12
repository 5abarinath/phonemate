package com.droidbots.phonemate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SmartphoneActivity extends AppCompatActivity {

    private TextView os, display, chipset, ram, storage, camera, battery, cores, connect,
    audio, network, dimensions, availColors;

    private ImageView image, flipkartImage;
    Phone phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        phone = (Phone) getIntent().getSerializableExtra("smartphone");

        image = findViewById(R.id.deviceImage);
        flipkartImage = findViewById(R.id.flipkartImage);

        flipkartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(phone.getFlipkartLink()));
                startActivity(intent);
            }
        });

        this.setTitle(phone.getName().split("\\(")[0].trim());

        Picasso.get()
                .load(phone.getImgsrc())
                .resize(250,500)
                .into(image);

        os = findViewById(R.id.os);
        display = findViewById(R.id.display);
        chipset = findViewById(R.id.chipset);
        ram = findViewById(R.id.ram);
        storage = findViewById(R.id.storage);
        camera = findViewById(R.id.camera);
        battery = findViewById(R.id.battery);
        cores = findViewById(R.id.cores);
        connect = findViewById(R.id.connect);
        audio = findViewById(R.id.audio);
        network = findViewById(R.id.network);
        dimensions = findViewById(R.id.dimensions);
        availColors = findViewById(R.id.availColors);

        os.setText(checkForNull(phone.getOperatingSystem()));
        display.setText(checkForNull(phone.getDisplayType()));
        dimensions.setText(checkForNull(phone.getDisplaySize()));
        chipset.setText(checkForNull(phone.getProcessorType()));
        ram.setText(checkForNull(phone.getRAM()));
        storage.setText(checkForNull(phone.getInternalStorage()));
        camera.setText(checkForNull(phone.getPrimaryCamera()));
        battery.setText(checkForNull(phone.getBatteryCapacity()));
        connect.setText(checkForNull(phone.getInternetConnectivity()));
        audio.setText(checkForNull(phone.getAudioJack()));
        network.setText(checkForNull(phone.getNetworkType()));
        availColors.setText(checkForNull(phone.getColor()));
        cores.setText(checkForNull(phone.getProcessorCore()));
    }

    public String checkForNull(String str) {
        if(str == null || str.equals(""))
            return "-";
        else
            return str;
    }

}
