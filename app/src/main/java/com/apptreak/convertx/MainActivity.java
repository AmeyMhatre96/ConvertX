package com.apptreak.convertx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private EditText txtInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInput = (EditText) findViewById(R.id.txtInput);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCmOp:

                break;
        }
    }
}
