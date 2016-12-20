package com.cssolution.horizon.horizon_v01.fragments;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cssolution.horizon.horizon_v01.R;
import com.cssolution.horizon.horizon_v01.activities.PhotoDetailActivity;
import com.cssolution.horizon.horizon_v01.adapters.CustomPhotosWorkflowListAdapter;

import java.util.Date;

/**
 * Created by Mohammad_T on 12/19/2016.
 */
public class PhotosTabFragment extends Fragment {

    private View photosTabLayout;
    private FloatingActionButton fab;
    private ListView photoList;
    private String[] comments = new String[]{"", ""};
    private Date[] dates = new Date[]{new Date(2016, 6, 4), new Date()};

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
        CustomPhotosWorkflowListAdapter adapter = new CustomPhotosWorkflowListAdapter(this.getActivity(), comments, dates);
        photoList.setAdapter(adapter);
        photoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                viewPhotoDetail(i);
            }
        });

        return photosTabLayout;
    }

    private void viewPhotoDetail(int position){
        Toast toast = Toast.makeText(this.getActivity(), "Open photo detail " + position, Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(this.getActivity(), PhotoDetailActivity.class);
        startActivity(intent);
    }

    // add photo from gallery or take directly from camera
    private void addPhoto(){
        Toast toast = Toast.makeText(this.getActivity(), "This is a button to add a photo", Toast.LENGTH_SHORT);
        toast.show();
    }
}
