package com.youtubedownloader;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.facebook.react.ReactActivity;

import javax.annotation.Nullable;

public class MainActivity extends ReactActivity {
    private static final int CODE_DRAW_OVER_OTHER_APP_PERMISSION = 2084;

    @Nullable
    @Override
    protected String getMainComponentName() {
        return "YoutubeDownloader";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main_activity_layout);
//        findViewById(R.id.launch_floating_bubble).setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                initializeFloatingBubble();
//                finish(); // make the button vanish after click.
//            }
//        });
        initializeFloatingBubble();
    }

    /**
     * Set and initialize the floating bubble.
     */
    private void initializeFloatingBubble() {
        startService(new Intent(MainActivity.this, FloatingBubbleService.class));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODE_DRAW_OVER_OTHER_APP_PERMISSION) {
            if (resultCode == RESULT_OK) {
                initializeFloatingBubble();
            } else {
                Toast.makeText(this,
                        "Draw over other app permission not available. Closing the application.",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        stopService(new Intent(MainActivity.this, FloatingBubbleService.class));
    }
}