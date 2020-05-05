package com.example.adminpanel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Intent;
import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private PhotosAdapter mPhotosAdapter;
    public void setConfig(RecyclerView recyclerView,Context context,List<Photo> photos,List<String> keys){
        mContext = context;
        mPhotosAdapter = new PhotosAdapter(photos, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mPhotosAdapter);
    }

    class PhotoItemView extends RecyclerView.ViewHolder {
        private TextView mLocation;
        private TextView mDescription;
        private TextView mLatitude;
        private TextView mLongitude;
        private String mImageUrl;
        private String mArMap;
        private String mPastImageUrl;
        private String mRecentImageUrl;

        private String key;

        public PhotoItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.photo_list_item, parent, false));
            mLocation = (TextView) itemView.findViewById(R.id.location);
            mDescription = (TextView) itemView.findViewById(R.id.description);
            mLatitude = (TextView) itemView.findViewById(R.id.latitude);
            mLongitude = (TextView) itemView.findViewById(R.id.longitude);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (mContext,Photo_detail_Activity.class);
                    intent.putExtra("key",key);
                    intent.putExtra("location",mLocation.getText().toString());
                    intent.putExtra("description",mDescription.getText().toString());
                    intent.putExtra("latitude",mLatitude.getText().toString());
                    intent.putExtra("longitude",mLongitude.getText().toString());
                    intent.putExtra("imageUrl",mImageUrl);
                    intent.putExtra("arMap",mArMap);
                    intent.putExtra("pastImageUrl",mPastImageUrl);
                    intent.putExtra("recentImageUrl",mRecentImageUrl);
                    mContext.startActivity(intent);
                }
            });
        }

        public void bind(Photo photo, String key) {
            mLocation.setText(photo.getmLocation());
            mDescription.setText(photo.getmDescription());
            mLatitude.setText(photo.getmLatitude().toString());
            mLongitude.setText(photo.getmLongitude().toString());
            mImageUrl = photo.getmImageUrl();
            mPastImageUrl = photo.getmPastImageUrl();
            mRecentImageUrl = photo.getmRecentImageUrl();
            mArMap = photo.getmARMap();

            this.key = key;
        }
    }

        class PhotosAdapter extends RecyclerView.Adapter<PhotoItemView>{
            private List<Photo> mPhotoList;
            private List<String> mKeys;

            public PhotosAdapter(List<Photo> mPhotoList,List<String> mKeys){
                this.mPhotoList = mPhotoList;
                this.mKeys = mKeys;
            }

            @NonNull
            @Override
            public PhotoItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new PhotoItemView(parent);
            }

            @Override
            public void onBindViewHolder(@NonNull PhotoItemView holder, int position) {
                holder.bind(mPhotoList.get(position),mKeys.get(position));
            }

            @Override
            public int getItemCount() {
                return mPhotoList.size();
            }
        }
    }
