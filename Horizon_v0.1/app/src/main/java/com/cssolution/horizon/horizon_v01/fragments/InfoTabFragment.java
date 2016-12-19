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
public class InfoTabFragment extends Fragment {
    public InfoTabFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workflow_info_tab, container, false);
    }
}
