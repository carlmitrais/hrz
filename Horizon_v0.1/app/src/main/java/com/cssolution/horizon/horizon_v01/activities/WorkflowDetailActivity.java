package com.cssolution.horizon.horizon_v01.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.cssolution.horizon.horizon_v01.R;

public class WorkflowDetailActivity extends AppCompatActivity {

    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String status = intent.getStringExtra("status");
        String clientName = intent.getStringExtra("client");

        // set custom action bar title
        View customActionBar = getLayoutInflater().inflate(R.layout.custom_action_bar, null);
        ((TextView) customActionBar.findViewById(R.id.customActionBarTitle)).setText(clientName);
        android.support.v7.app.ActionBar.LayoutParams param = new android.support.v7.app.ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(customActionBar, param);

        // set the trade type, location, and workflow type
        // may be changed when the actual design available
        setContentView(R.layout.activity_workflow_detail);
        ((TextView) findViewById(R.id.tradeTypeTextView)).setText("Roofing, Gutters");
        ((TextView) findViewById(R.id.clientAddressTextView)).setText("411 Hayes Avenue Hayes, Nebraska 69032");
        ((TextView) findViewById(R.id.workflowStatus)).setText(status.toUpperCase());

        tableLayout = (TableLayout) findViewById(R.id.dynamicTableLayout);

    }

    // construct a form for Lead type
    private void addLeadForm(){

    }

    // construct a form for Prospect type
    private void addProspectForm(){

    }

    // construct a form for Accepted type
    private void addAcceptedForm(){

    }

    // construct a form for Completed type
    private void addCompletedForm(){

    }

    //  construct a form for Invoiced type
    private void addInvoicedForm(){

    }
}
