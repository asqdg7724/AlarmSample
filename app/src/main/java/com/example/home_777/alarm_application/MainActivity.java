package com.example.home_777.alarm_application;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    Button btnAlarmAdd = (Button) findViewById(R.id.btnAlarmAdd);
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("아두이노 연동 어플");

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabAlarmSpec = tabHost.newTabSpec("ALARM").setIndicator("알람");
        tabAlarmSpec.setContent(R.id.tabAlarm);
        tabHost.addTab(tabAlarmSpec);

        intent = new Intent(this, stopwatch.class);
        TabHost.TabSpec tabStopSpec = tabHost.newTabSpec("STOPWATCH").setIndicator("스톱워치");
        tabStopSpec.setContent(R.id.tabStop);
        tabHost.addTab(tabStopSpec);

        TabHost.TabSpec tabTimerSpec = tabHost.newTabSpec("TIMER").setIndicator("타이머");
        tabTimerSpec.setContent(R.id.tabTimer);
        tabHost.addTab(tabTimerSpec);

        tabHost.setCurrentTab(0);

        btnAlarmAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), alarm_add.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.linkswitch_menu, menu);
        MenuItem item = menu.findItem(R.id.linckswitch);
        item.setActionView(R.layout.linkswitch_layout);
        return true;
    }
}
