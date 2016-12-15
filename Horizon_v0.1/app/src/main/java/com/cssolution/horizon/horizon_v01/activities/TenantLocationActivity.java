package com.cssolution.horizon.horizon_v01.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cssolution.horizon.horizon_v01.R;

public class TenantLocationActivity extends AppCompatActivity {

    String[] tenants = new String[]{"Head Quarter", "Tenant 1", "Tenant 2", "Tenant 3", "Tenant 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View customActionBar = getLayoutInflater().inflate(R.layout.custom_action_bar, null);
        ((TextView) customActionBar.findViewById(R.id.customActionBarTitle)).setText("Locations");
        android.support.v7.app.ActionBar.LayoutParams param = new android.support.v7.app.ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(customActionBar, param);

        setContentView(R.layout.activity_tenant_location);

        ListView tenantListView = (ListView)findViewById(R.id.tenantListView);
        tenantListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tenants));
        tenantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openTenantCustomerList();
            }
        });
    }

    private void openTenantCustomerList(){
        Intent intent = new Intent(this, CustomerListActivity.class);
        startActivity(intent);
    }
}
