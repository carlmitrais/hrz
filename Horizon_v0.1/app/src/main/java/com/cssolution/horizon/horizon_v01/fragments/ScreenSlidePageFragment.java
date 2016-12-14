package com.cssolution.horizon.horizon_v01.fragments;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cssolution.horizon.horizon_v01.R;
import com.cssolution.horizon.horizon_v01.adapters.ScreenSlidePageAdapter;

/**
 * Created by Mohammad_T on 12/14/2016.
 */
public class ScreenSlidePageFragment extends Fragment {

    private int pageNumber;
    private static final String ARG_PAGE = "page";

    public ScreenSlidePageFragment(){
    }

    public static ScreenSlidePageFragment create(int pageNum){
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
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
//        ImageView image1 = (ImageView) root.findViewById(R.id.imageView1);
//        ImageView image2 = (ImageView) root.findViewById(R.id.imageView2);
//        ImageView image3 = (ImageView) root.findViewById(R.id.imageView3);

        // change the background color of the welcome screen
        // edit this block when there is a fix design already available
        switch (pageNumber){
            case 0:
                layout.setBackgroundColor(0xFF3C4E67);
                //image1.setImageAlpha(1);
//                image1.setPadding(0, 0, 0, 10);
                break;
            case 1:
                layout.setBackgroundColor(0xFF202279);
                //image2.setImageAlpha(1);
//                image2.setPadding(0, 0, 0, 10);
                break;
            case 2:
                layout.setBackgroundColor(0xFF732879);
                //image3.setImageAlpha(1);
//                image3.setPadding(0, 0, 0, 10);
                break;
        }

        return  root;
    }
}
