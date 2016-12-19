package com.cssolution.horizon.horizon_v01.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cssolution.horizon.horizon_v01.R;

/**
 * Created by Mohammad_T on 12/19/2016.
 */
public class ActivitiesTabFragment extends Fragment {

    private final static int CALENDAR = 0;
    private final static int YESNO = 1;
    private final static int UPLOAD = 2;

    private int[] workflowStep;
    private static Boolean[] passWorkflowStep;

    View viewLayout;

    public ActivitiesTabFragment() {

    }

    public static ActivitiesTabFragment create(int[] workflowStep, Boolean[] passWorkflowStep){
        ActivitiesTabFragment fragment = new ActivitiesTabFragment();
        fragment.workflowStep = workflowStep;
        fragment.passWorkflowStep = passWorkflowStep;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewLayout = inflater.inflate(R.layout.fragment_workflow_activities_tab, container, false);
        addStepsForm(workflowStep, passWorkflowStep);
        return viewLayout;
    }

    // construct a form for Lead type
    private void addStepsForm(int[] workflowStep, Boolean[] passWorkflowStep) {
        for (int i = 0; i < workflowStep.length; i++) {
            // initialize step view and step passed checkbox controls
            View view = new View(getActivity());
            CheckBox checkBox = new CheckBox(getActivity());

            // set the step form type
            switch (workflowStep[i]) {
                case CALENDAR:

                    view = getActivity().getLayoutInflater().inflate(R.layout.custom_cell_create_appointment, null);
                    checkBox = (CheckBox) view.findViewById(R.id.appointmentCheckBox);
                    break;

                case YESNO:
                    view = getActivity().getLayoutInflater().inflate(R.layout.custom_cell_yes_no_statement, null);
                    checkBox = (CheckBox) view.findViewById(R.id.yesNoCheckBox);
                    break;

                case UPLOAD:
                    view = getActivity().getLayoutInflater().inflate(R.layout.custom_cell_upload_document, null);
                    checkBox = (CheckBox) view.findViewById(R.id.uploadCheckBox);
                    break;
            }

            ((TextView) view.findViewById(R.id.rowNumber)).setText(String.valueOf(i + 1) + ".");

            // set passed steps
            if (i < passWorkflowStep.length ){
                if (passWorkflowStep[i]) {
                    checkBox.setVisibility(View.VISIBLE);
                }
            }

            // add the step to screen
            ((LinearLayout) viewLayout.findViewById(R.id.dynamicWorkflowActivitiesLayout)).addView(view, i);
        }
    }
}
