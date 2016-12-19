package com.cssolution.horizon.horizon_v01.fragments;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cssolution.horizon.horizon_v01.R;

/**
 * Created by Mohammad_T on 12/19/2016.
 */
public class PhotosTabFragment extends Fragment {

    private View photosTabLayout;
    private FloatingActionButton fab;
    private ListView photoList;

    public PhotosTabFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        photosTabLayout = inflater.inflate(R.layout.fragment_workflow_photos_tab, container, false);

        fab = (FloatingActionButton) photosTabLayout.findViewById(R.id.fabWorkflowPhotosTab);
        fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#092048")));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPhoto();
            }
        });

        photoList = (ListView) photosTabLayout.findViewById(R.id.photoWorkflowPhotosTabListView);

        return photosTabLayout;
    }

    // add photo from gallery or take directly from camera
    private void addPhoto(){

    }
}
