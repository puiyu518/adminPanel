package com.example.adminpanel;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Photo_detail_Activity extends AppCompatActivity {

    private EditText mLocation_editText;
    private EditText mDesription_editText;
    private EditText mLatitude_editText;
    private EditText mLongitude_editText;
    private Button mUpdate_btn;
    private Button mDelete_btn;
    private Button mBack_btn;

    private String key;
    private String location;
    private String desription;
    private String latitude;
    private String longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_detail);

        key = getIntent().getStringExtra("key");
        location = getIntent().getStringExtra("location");
        desription = getIntent().getStringExtra("desription");
        latitude = getIntent().getStringExtra("latitude");
        longitude = getIntent().getStringExtra("longitude");

        mLocation_editText = (EditText) findViewById(R.id.location);
        mDescription_editText = (EditText) findViewById(R.id.description);
        mLatitude_editText = (EditText) findViewById(R.id.latitude);
        mLongitude_editText = (EditText) findViewById(R.id.longitude);

        mUpdate_btn = (Button) findViewById(R.id.update);
        mDelete_btn = (Button) findViewById(R.id.delete);
        mBack_btn = (Button) findViewById(R.id.back_button);

        mUpdate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TempImageName =mLocation_editText.getText().toString();
                String TempDescription =mDescription_editText.getText().toString();
                String TempImageLatitude =mLatitude_editText.getText().toString();
                String TempImageLongitude =mLongitude_editText.getText().toString();

                Photo photo = new Photo(TempImageName,TempDescription,TempImageLatitude, TempImageLongitude);

                new FirebaseDatabaseHelper().updatePhoto(key, photo, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Photo> photos, List<String> keys) {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(Photo_detail_Activity.this,"Data has been updated successfully",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });

        mDelete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseHelper().deletePhoto(key, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Photo> photos, List<String> keys) {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(Photo_detail_Activity.this, "Data has been deleted", Toast.LENGTH_LONG).show();
                        finish();
                        return;

                    }
                });
            }
        });

        mBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); return;
            }
        });
    }
}
