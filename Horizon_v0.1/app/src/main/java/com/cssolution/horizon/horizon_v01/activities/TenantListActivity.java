package com.cssolution.horizon.horizon_v01.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cssolution.horizon.horizon_v01.R;

public class TenantListActivity extends AppCompatActivity {

    String[] tenants = new String[]{"Head Quarter", "Tenant 1", "Tenant 2", "Tenant 3", "Tenant 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Locations");
        setContentView(R.layout.activity_tenant_list);

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
