package com.apptreak.convertx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.math.RoundingMode;


public class Length extends Fragment implements View.OnClickListener {
    private Button btnCm, btnM, btnMm, btnKm, btnCmOp, btnMop, btnMmOp, btnKmOp;
    TextView inputUnit, output;
    EditText txtInput;
    RelativeLayout lengthLayout;
    java.text.DecimalFormat df = new java.text.DecimalFormat("#.#####");
    double inputNo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        lengthLayout = (RelativeLayout) inflater.inflate(R.layout.length_layout, container, false);

        btnCm = (Button) lengthLayout.findViewById(R.id.btnCm);
        btnCmOp = (Button) lengthLayout.findViewById(R.id.btnCmOp);
        btnM = (Button) lengthLayout.findViewById(R.id.btnM);
        btnMop = (Button) lengthLayout.findViewById(R.id.btnMOp);
        btnMm = (Button) lengthLayout.findViewById(R.id.btnMm);
        btnMmOp = (Button) lengthLayout.findViewById(R.id.btnMmOp);
        btnKm = (Button) lengthLayout.findViewById(R.id.btnKm);
        btnKmOp = (Button) lengthLayout.findViewById(R.id.btnKmOp);

        inputUnit = (TextView) lengthLayout.findViewById(R.id.inputUnit);
        output = (TextView) lengthLayout.findViewById(R.id.txtOp);
        txtInput = (EditText) lengthLayout.findViewById(R.id.txtInput);


        btnCm.setOnClickListener(this);
        btnCmOp.setOnClickListener(this);
        btnM.setOnClickListener(this);
        btnMop.setOnClickListener(this);
        btnKm.setOnClickListener(this);
        btnKmOp.setOnClickListener(this);
        btnMm.setOnClickListener(this);
        btnMmOp.setOnClickListener(this);


        return lengthLayout;
    }


    @Override
    public void onClick(View v) {
        df.setRoundingMode(RoundingMode.CEILING);
        inputNo = Double.parseDouble(txtInput.getText().toString());
        switch (v.getId()) {
            case R.id.btnCm:
                inputUnit.setText(R.string.btn_cm);
                if (output.getText().toString().endsWith("cm")){
                    convertToCm();
                }
                break;
            case R.id.btnM:
                inputUnit.setText(R.string.btn_m);
                if (output.getText().toString().endsWith("cm")){
                    convertToCm();
                }
                break;
            case R.id.btnKm:
                inputUnit.setText(R.string.btn_km);
                if (output.getText().toString().endsWith("cm")){
                    convertToCm();
                }
                break;
            case R.id.btnMm:
                inputUnit.setText(R.string.btn_mm);
                if (output.getText().toString().endsWith("cm")){
                    convertToCm();
                }
                break;
            case R.id.btnCmOp:
                convertToCm();
                break;
            case R.id.btnMmOp:

                break;
            case R.id.btnKmOp:

                break;
            case R.id.btnMOp:

                break;

        }
    }

    void convertToCm() {
        if (inputUnit.getText().toString().equalsIgnoreCase("m")) {
            output.setText(String.format("%s", df.format(inputNo * 100) + " cm"));
        } else if (inputUnit.getText().toString().equalsIgnoreCase("mm")) {
            output.setText(String.format("%s", df.format(inputNo / 10) + " cm"));
        } else if (inputUnit.getText().toString().equalsIgnoreCase("km")) {
            output.setText(String.format("%s", df.format(inputNo * 100000) + " cm"));
        } else {
            output.setText(String.format("%s", df.format(inputNo) + " cm"));
        }
    }
}
