package com.cssolution.horizon.horizon_v01.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cssolution.horizon.horizon_v01.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mohammad_T on 12/19/2016.
 */
public class CustomPhotosWorkflowListAdapter extends BaseAdapter {

    private Activity context;
    private String[] comments;
    private Date[] dates;

    public CustomPhotosWorkflowListAdapter(Activity context, String[] comments, Date[] dates){
        this.context = context;
        this.comments = comments;
        this.dates = dates;
    }

    @Override
    public int getCount() {
        return comments.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_photo_list_item, null, true);

        TextView date = (TextView) rowView.findViewById(R.id.datePhotoWorkflowPhotosTabLabel);
        ImageView picture = (ImageView) rowView.findViewById(R.id.photoWorkflowPhotosTabImage);
        TextView comment = (TextView) rowView.findViewById(R.id.photoCommentWorkflowPhotosTabLabel);

        date.setText(new SimpleDateFormat("MMM dd").format(dates[i]));

        return rowView;
    }
}
