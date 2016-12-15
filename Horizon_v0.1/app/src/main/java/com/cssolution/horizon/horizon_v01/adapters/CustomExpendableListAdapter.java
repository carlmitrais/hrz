package com.cssolution.horizon.horizon_v01.adapters;

import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.cssolution.horizon.horizon_v01.R;

/**
 * Created by Mohammad_T on 12/13/2016.
 */
public class CustomExpendableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandableListGroup;
    private HashMap<String, List<String>> expandableListItem;

    public CustomExpendableListAdapter(Context context, List<String> expandableListGroup, HashMap<String, List<String>> expandableListItem){
        this.context = context;
        this.expandableListGroup = expandableListGroup;
        this.expandableListItem = expandableListItem;
    }

    @Override
    public int getGroupCount() {
        return expandableListGroup.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return expandableListItem.get(expandableListGroup.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return expandableListGroup.get(i);
    }

    @Override
    public Object getChild(int i, int j) {
        return expandableListItem.get(expandableListGroup.get(i)).get(j);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int j) {
        return j;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        final String groupTitle = (String) getGroup(i);
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_group, null);
        }

        TextView groupTextView = (TextView)view.findViewById(R.id.expandableGroup);
        groupTextView.setTypeface(null, Typeface.BOLD);
        groupTextView.setText(groupTitle);

        TextView itemCount = (TextView)view.findViewById(R.id.customerListCount);
        itemCount.setTypeface(null, Typeface.BOLD);
        itemCount.setText(String.valueOf(getChildrenCount(i)));

        return view;
    }

    @Override
    public View getChildView(int i, int j, boolean b, View view, ViewGroup viewGroup) {
        final String expandedListText = (String) getChild(i, j);
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_item, null);
        }

        TextView itemTextView = (TextView)view.findViewById(R.id.expandableItem);
        itemTextView.setText(expandedListText);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int j) {
        return true;
    }
}
