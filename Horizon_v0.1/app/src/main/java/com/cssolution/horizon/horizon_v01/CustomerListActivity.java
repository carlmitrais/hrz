package com.cssolution.horizon.horizon_v01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomerListActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListGroup;
    HashMap<String, List<String>> expandableListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        initializeDummyData();
        expandableListAdapter = new CustomExpendableListAdapter(this, expandableListGroup, expandableListItem);

        expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);
        expandableListView.setAdapter(expandableListAdapter);


    }

    private void initializeDummyData(){
        // dummy data for group title
        expandableListGroup = new ArrayList<String>();
        expandableListGroup.add("Lead");
        expandableListGroup.add("Prospect");
        expandableListGroup.add("Accepted");
        expandableListGroup.add("Completed");
        expandableListGroup.add("Invoiced");

        // dummy data for group's item
        List<String> leadItems = new ArrayList<String>();
        leadItems.add("John Doe");
        leadItems.add("Kimberly K");
        leadItems.add("Josh Bun");

        List<String> prospectItems = new ArrayList<String>();
        prospectItems.add("Denny Chan");
        prospectItems.add("Sammy West");
        prospectItems.add("Prince Owe");

        List<String> acceptedItems = new ArrayList<String>();
        acceptedItems.add("Black Smith");
        acceptedItems.add("Blue Lagoon");
        acceptedItems.add("Kennedy Ken");

        List<String> completedItems = new ArrayList<String>();
        completedItems.add("Sheila Mill");
        completedItems.add("Rebecca T");
        completedItems.add("John Key");

        List<String> invoicedItems = new ArrayList<String>();
        invoicedItems.add("Andry Boy");
        invoicedItems.add("Shane C");
        invoicedItems.add("Andrew G");

        expandableListItem = new HashMap<String, List<String>>();
        expandableListItem.put(expandableListGroup.get(0), leadItems);
        expandableListItem.put(expandableListGroup.get(1), prospectItems);
        expandableListItem.put(expandableListGroup.get(2), acceptedItems);
        expandableListItem.put(expandableListGroup.get(3), completedItems);
        expandableListItem.put(expandableListGroup.get(4), invoicedItems);
    }
}
