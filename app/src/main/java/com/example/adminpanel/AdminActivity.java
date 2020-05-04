package com.example.adminpanel;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.os.Bundle;


public class AdminActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_main);
        mRecyclerView =(RecyclerView) findViewById(R.id.recylerview_photos);
        new FirebaseDatabaseHelper().readPhotos(new FirebaseDatabaseHelper.DataStatus(){
            @Override
                    public void DataIsLoaded(List<Photo> photos,List<String> keys){
                        new RecyclerView_Config().setConfig(mRecyclerView,AdminActivity.this,
                                photos,keys);
            }

            @Override
            public void DataIsUpdated(){

            }

            @Override
            public void DataIsDeleted(){

            }
        });
    }
}
