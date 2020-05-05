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
    private EditText mDescription_editText;
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
    private String imageUrl;
    private String arMap;
    private String pastImageUrl;
    private String recentImageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_detail);

        key = getIntent().getStringExtra("key");
        location = getIntent().getStringExtra("location");
        desription = getIntent().getStringExtra("description");
        latitude = getIntent().getStringExtra("latitude");
        longitude = getIntent().getStringExtra("longitude");
        imageUrl = getIntent().getStringExtra("imageUrl");
        arMap = getIntent().getStringExtra("arMap");
        pastImageUrl = getIntent().getStringExtra("pastImageUrl");
        recentImageUrl = getIntent().getStringExtra("recentImageUrl");

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
                Photo photo = new Photo();
                photo.setmLocation(mLocation_editText.getText().toString());
                photo.setmDescription(mDescription_editText.getText().toString());
                photo.setmLatitude(Double.parseDouble(mLatitude_editText.getText().toString()));
                photo.setmLongitude(Double.parseDouble(mLongitude_editText.getText().toString()));
                photo.setmImageUrl(imageUrl);
                photo.setmARMap(arMap);
                photo.setmPastImageUrl(pastImageUrl);
                photo.setmRecentImageUrl(recentImageUrl);

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
