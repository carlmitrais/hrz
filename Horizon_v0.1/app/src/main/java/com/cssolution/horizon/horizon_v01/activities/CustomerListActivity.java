package com.cssolution.horizon.horizon_v01.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cssolution.horizon.horizon_v01.R;
import com.cssolution.horizon.horizon_v01.adapters.CustomExpendableListAdapter;

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

        View customActionBar = getLayoutInflater().inflate(R.layout.custom_action_bar, null);
        ((TextView) customActionBar.findViewById(R.id.customActionBarTitle)).setText("Workflow");
        android.support.v7.app.ActionBar.LayoutParams param = new android.support.v7.app.ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(customActionBar, param);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_customer_list);

        initializeDummyData();
        expandableListAdapter = new CustomExpendableListAdapter(this, expandableListGroup, expandableListItem);

        expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableList, View view, int workflowId, int clientPosition, long id) {
                String client = expandableListItem.get(expandableListGroup.get(workflowId)).get(clientPosition);
                openWorkflowDetail(workflowId, client);
                return false;
            }
        });

    }

    private void openWorkflowDetail(int workflowId, String client){
        Intent intent = new Intent(this, WorkflowDetailActivity.class);
        intent.putExtra("workflow_id", workflowId);
        intent.putExtra("client", client);
        startActivity(intent);
    }

    private void initializeDummyData(){
        // dummy data for group title
        expandableListGroup = new ArrayList<String>();
        expandableListGroup.add("Lead");
        expandableListGroup.add("Prospect");
        expandableListGroup.add("Production");
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

        List<String> productionItems = new ArrayList<String>();
        productionItems.add("Black Smith");
        productionItems.add("Blue Lagoon");
        productionItems.add("Kennedy Ken");

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
        expandableListItem.put(expandableListGroup.get(2), productionItems);
        expandableListItem.put(expandableListGroup.get(3), completedItems);
        expandableListItem.put(expandableListGroup.get(4), invoicedItems);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
