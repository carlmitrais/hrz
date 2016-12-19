package com.cssolution.horizon.horizon_v01.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.cssolution.horizon.horizon_v01.R;

/**
 * Created by Mohammad_T on 12/14/2016.
 */
public class WelcomeScreenSlideFragment extends Fragment {

    private int pageNumber;
    private static final String ARG_PAGE = "page";

    public WelcomeScreenSlideFragment(){
    }

    public static WelcomeScreenSlideFragment create(int pageNum){
        WelcomeScreenSlideFragment fragment = new WelcomeScreenSlideFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNum);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        RelativeLayout layout = (RelativeLayout) root.findViewById(R.id.screenSlidePage);

        // change the background color of the welcome screen
        // edit this block when there is a fix design already available
        switch (pageNumber){
            case 0:
                layout.setBackgroundColor(0xFF3C4E67);
                break;
            case 1:
                layout.setBackgroundColor(0xFF202279);
                break;
            case 2:
                layout.setBackgroundColor(0xFF732879);
                break;
        }

        return  root;
    }
}
