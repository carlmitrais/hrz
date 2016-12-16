package com.cssolution.horizon.horizon_v01.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.cssolution.horizon.horizon_v01.R;

public class WorkflowDetailActivity extends AppCompatActivity {

    private final static int CALENDAR = 0;
    private final static int YESNO = 1;
    private final static int UPLOAD = 2;

    String[] workflowStatus = new String[]{"LEAD", "PROSPECT", "PRODUCTION", "COMPLETED", "INVOICE"};

    int[] leadWorkflow = new int[]{CALENDAR, YESNO, UPLOAD};
    Boolean[] passLeadWorkflow = new Boolean[]{true, false, false};

    int[] prospectWorkflow = new int[]{YESNO, UPLOAD, CALENDAR};
    Boolean[] passProspectWorkflow = new Boolean[]{true, false, false};

    int[] productionWorkflow = new int[]{YESNO, CALENDAR, UPLOAD};
    Boolean[] passProductionWorkflow = new Boolean[]{true, false, false};

    int[] completedWorkflow = new int[]{YESNO, UPLOAD, CALENDAR};
    Boolean[] passCompletedWorkflow = new Boolean[]{true, false, false};

    int[] invoiceWorkflow = new int[]{YESNO, CALENDAR, UPLOAD};
    Boolean[] passInvoiceWorkflow = new Boolean[]{false, false, false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int workflowId = intent.getIntExtra("workflow_id", -1);
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
        ((TextView) findViewById(R.id.workflowStatus)).setText(workflowStatus[workflowId]);

        switch (workflowId){
            case 0:
                addStepsForm(leadWorkflow, passLeadWorkflow);
                break;
            case 1:
                addStepsForm(prospectWorkflow, passProspectWorkflow);
                break;
            case 2:
                addStepsForm(productionWorkflow, passProductionWorkflow);
                break;
            case 3:
                addStepsForm(completedWorkflow, passCompletedWorkflow);
                break;
            case 4:
                addStepsForm(invoiceWorkflow, passInvoiceWorkflow);
                break;
        }

    }

    // construct a form for Lead type
    private void addStepsForm(int[] workflowStep, Boolean[] passWorkflowStep){
        for (int i = 0; i < workflowStep.length; i++){
            // initialize step view and step passed checkbox controls
            View view = new View(this);
            CheckBox checkBox = new CheckBox(this);

            // set the step form type
            switch(workflowStep[i]){
                case CALENDAR:
                    view = getLayoutInflater().inflate(R.layout.custom_cell_create_appointment, null);
                    checkBox = (CheckBox) view.findViewById(R.id.appointmentCheckBox);
                    break;

                case YESNO:
                    view = getLayoutInflater().inflate(R.layout.custom_cell_yes_no_statement, null);
                    checkBox = (CheckBox) view.findViewById(R.id.yesNoCheckBox);
                    break;

                case UPLOAD:
                    view = getLayoutInflater().inflate(R.layout.custom_cell_upload_document, null);
                    checkBox = (CheckBox) view.findViewById(R.id.uploadCheckBox);
                    break;
            }

            ((TextView) view.findViewById(R.id.rowNumber)).setText(String.valueOf(i + 1) + ".");

            // set passed steps
            if (passWorkflowStep[i]){
                checkBox.setVisibility(View.VISIBLE);
                view.setEnabled(false);
            }

            // add the step to screen
            ((LinearLayout) findViewById(R.id.dynamicLeadLayout)).addView(view, i);
        }
    }
}
