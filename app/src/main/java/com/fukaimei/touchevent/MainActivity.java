package com.fukaimei.touchevent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_event_dispatch).setOnClickListener(this);
        findViewById(R.id.btn_event_intercept).setOnClickListener(this);
        findViewById(R.id.btn_touch_single).setOnClickListener(this);
        findViewById(R.id.btn_touch_multiple).setOnClickListener(this);
        findViewById(R.id.btn_signature).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_event_dispatch) {
            Intent intent = new Intent(this, EventDispatchActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_event_intercept) {
            Intent intent = new Intent(this, EventInterceptActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_touch_single) {
            Intent intent = new Intent(this, TouchSingleActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_touch_multiple) {
            Intent intent = new Intent(this, TouchMultipleActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_signature) {
            Intent intent = new Intent(this, SignatureActivity.class);
            startActivity(intent);
        }
    }

    private boolean bExit = false;

//	@Override
//	public void onBackPressed() {
//		if (bExit) {
//			finish();
//			return;
//		}
//		bExit = true;
//		Toast.makeText(this, "再按一次返回键退出!", Toast.LENGTH_SHORT).show();
//	}

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (bExit) {
                finish();
            }
            bExit = true;
            Toast.makeText(this, "再按一次返回键退出!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

}
