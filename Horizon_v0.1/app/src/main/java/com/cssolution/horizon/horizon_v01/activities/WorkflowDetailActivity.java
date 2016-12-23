package com.cssolution.horizon.horizon_v01.activities;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.cssolution.horizon.horizon_v01.R;
import com.cssolution.horizon.horizon_v01.adapters.CustomViewPagerAdapter;
import com.cssolution.horizon.horizon_v01.fragments.AboutTabFragment;
import com.cssolution.horizon.horizon_v01.fragments.ActivitiesTabFragment;
import com.cssolution.horizon.horizon_v01.fragments.InfoTabFragment;
import com.cssolution.horizon.horizon_v01.fragments.PhotosTabFragment;

public class WorkflowDetailActivity extends AppCompatActivity {

    private final static int CALENDAR = 0;
    private final static int YESNO = 1;
    private final static int UPLOAD = 2;

    String[] workflowStatus = new String[]{"LEAD", "PROSPECT", "PRODUCTION", "COMPLETED", "INVOICE"};

    int[] leadWorkflow = new int[]{CALENDAR, YESNO, UPLOAD, YESNO, UPLOAD};
    Boolean[] passLeadWorkflow = new Boolean[]{true, false, false};

    int[] prospectWorkflow = new int[]{YESNO, UPLOAD, CALENDAR};
    Boolean[] passProspectWorkflow = new Boolean[]{true, false, false};

    int[] productionWorkflow = new int[]{YESNO, CALENDAR, UPLOAD};
    Boolean[] passProductionWorkflow = new Boolean[]{true, false, false};

    int[] completedWorkflow = new int[]{YESNO, UPLOAD, CALENDAR};
    Boolean[] passCompletedWorkflow = new Boolean[]{true, false, false};

    int[] invoiceWorkflow = new int[]{YESNO, CALENDAR, UPLOAD};
    Boolean[] passInvoiceWorkflow = new Boolean[]{false, false, false};

    private ViewPager pager;
    private TabLayout tabLayout;

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // set the trade type, location, and workflow type
        // may be changed when the actual design available
        setContentView(R.layout.activity_workflow_detail);
        ((TextView) findViewById(R.id.tradeTypeTextView)).setText("Roofing, Gutters");
        ((TextView) findViewById(R.id.clientAddressTextView)).setText("411 Hayes Avenue Hayes\n Nebraska 69032");

        pager = (ViewPager) findViewById(R.id.workflowPager);
        setupTabPager(pager, workflowId);

        tabLayout = (TabLayout) findViewById(R.id.workflowTab);
        tabLayout.setupWithViewPager(pager);

        ((ImageView) findViewById(R.id.leadLocationImageView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locationIntent = new Intent(view.getContext(), LeadLocationActivity.class);
                startActivity(locationIntent);
            }
        });
    }

    private void setupTabPager(ViewPager pager, int workflowId){
        int[] workflow = new int[]{};
        Boolean[] passWorkflow = new Boolean[]{};

        switch (workflowId){
            case 0:
                workflow = leadWorkflow;
                passWorkflow = passLeadWorkflow;
                break;
            case 1:
                workflow = prospectWorkflow;
                passWorkflow = passProspectWorkflow;
                break;
            case 2:
                workflow = productionWorkflow;
                passWorkflow = passProductionWorkflow;
                break;
            case 3:
                workflow = completedWorkflow;
                passWorkflow = passCompletedWorkflow;
                break;
            case 4:
                workflow = invoiceWorkflow;
                passWorkflow = passInvoiceWorkflow;
                break;
            default:
                workflow = leadWorkflow;
                passWorkflow = passLeadWorkflow;
                break;
        }

        CustomViewPagerAdapter pagerAdapter = new CustomViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(ActivitiesTabFragment.create(workflow, passWorkflow), "Activities");
        pagerAdapter.addFragment(new AboutTabFragment(), "About");
        pagerAdapter.addFragment(new PhotosTabFragment(), "Photos");
        pagerAdapter.addFragment(new InfoTabFragment(), "Info");

        pager.setAdapter(pagerAdapter);
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
