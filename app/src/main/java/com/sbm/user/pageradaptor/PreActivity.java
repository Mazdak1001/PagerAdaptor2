package com.sbm.user.pageradaptor;

import android.content.Context;
import android.content.Intent;
import android.icu.util.TimeUnit;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sbm.user.pageradaptor.MainActivity;
import com.sbm.user.pageradaptor.R;

public class PreActivity extends AppCompatActivity {
    Button ButtonGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre);
        onclickListener();

    }
    private void onclickListener() {
        ButtonGo=(Button)findViewById(R.id.ButtonGo);
        final Context context=this;
        ButtonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MainActivity.class);
                startActivity(intent);


            }
        });
    }
}
