package com.cssolution.horizon.horizon_v01.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cssolution.horizon.horizon_v01.R;

/**
 * Created by Mohammad_T on 12/19/2016.
 */
public class AboutTabFragment extends Fragment {
    public AboutTabFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workflow_about_tab, container, false);
    }
}
