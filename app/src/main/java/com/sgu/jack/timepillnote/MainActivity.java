package com.sgu.jack.timepillnote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionsMenu fabMenu;
    private FloatingActionButton fabNormal, fabTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabNormal = (FloatingActionButton) findViewById(R.id.fab_normal);
        fabMenu = (FloatingActionsMenu) findViewById(R.id.fabMenu);
        fabTime = (FloatingActionButton) findViewById(R.id.fab_time);

        fabNormal.setOnClickListener(this);
        fabTime.setOnClickListener(this);
        fabMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_normal:
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                startActivity(intent);
                //this.overridePendingTransition(R.anim.activity_open,0);
                break;
        }
        fabMenu.toggle();   //收起悬浮菜单按钮d
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //双击退出
    private long exitTime = 0;

    public void doExitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, R.string.press_again_exit_app, Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        doExitApp();
    }
}
