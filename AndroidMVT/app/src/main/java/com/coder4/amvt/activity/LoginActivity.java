package com.coder4.amvt.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.coder4.amvt.R;
import com.coder4.amvt.agent.LoginAgent;

/**
 * Created by coder4 on 2017/5/22.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Button btn = (Button)findViewById(R.id.btnLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fake now, so must success
                LoginAgent.shared.login();
                setResult(RESULT_OK);
                finish();
            }
        });
    }


}
