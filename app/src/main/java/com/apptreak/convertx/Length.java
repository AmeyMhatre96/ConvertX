package com.apptreak.convertx;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.math.RoundingMode;

import static android.content.Context.INPUT_METHOD_SERVICE;


public class Length extends Fragment implements View.OnClickListener {
    private Button btnCm, btnM, btnMm, btnKm, btnCmOp, btnMop, btnMmOp, btnKmOp, btnMicrometer, btnMicrometerOp, btnNanometer, btnNanoMeterOp, btnFt, btnFtOp, btnInch, btnInchOp;
    public TextView lengthInputUnit, LengthOutput;
   public  EditText txtLengthInput;
    RelativeLayout lengthLayout;
    java.text.DecimalFormat df;
    double lengthInputNo;

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
        btnMicrometer = (Button) lengthLayout.findViewById(R.id.btnMicrometer);
        btnMicrometerOp = (Button) lengthLayout.findViewById(R.id.btnMicrometerOp);
        btnNanometer = (Button) lengthLayout.findViewById(R.id.btnNanometer);
        btnNanoMeterOp = (Button) lengthLayout.findViewById(R.id.btnNanometerOp);
        btnFt = (Button) lengthLayout.findViewById(R.id.btnFoot);
        btnFtOp = (Button) lengthLayout.findViewById(R.id.btnFootOp);
        btnInch = (Button) lengthLayout.findViewById(R.id.btnInch);
        btnInchOp = (Button) lengthLayout.findViewById(R.id.btnInchOp);

        lengthLayout.setOnClickListener(this);


        lengthInputUnit = (TextView) lengthLayout.findViewById(R.id.inputUnitLength);
        LengthOutput = (TextView) lengthLayout.findViewById(R.id.txtOpLength);
        txtLengthInput = (EditText) lengthLayout.findViewById(R.id.txtInputLength);


        btnCm.setOnClickListener(this);
        btnCmOp.setOnClickListener(this);
        btnM.setOnClickListener(this);
        btnMop.setOnClickListener(this);
        btnKm.setOnClickListener(this);
        btnKmOp.setOnClickListener(this);
        btnMm.setOnClickListener(this);
        btnMmOp.setOnClickListener(this);
        btnMicrometer.setOnClickListener(this);
        btnMicrometerOp.setOnClickListener(this);
        btnNanometer.setOnClickListener(this);
        btnNanoMeterOp.setOnClickListener(this);
        btnFt.setOnClickListener(this);
        btnFtOp.setOnClickListener(this);
        btnInch.setOnClickListener(this);
        btnInchOp.setOnClickListener(this);


        return lengthLayout;
    }

    void hideSoftKeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void clear(){
     Log.d("asfe","afsa");

        LengthOutput.setText("");

    }
//updated
    void decimalFormat(double input) {
        if (input > 100000000000.0) {
            df = new java.text.DecimalFormat("0.#####E0");
        } else {
            df = new java.text.DecimalFormat("#.#####");
        }
        df.setRoundingMode(RoundingMode.CEILING);
    }




    @Override
    public void onClick(View v) {
        if (txtLengthInput.getText().toString().length() != 0) {
            lengthInputNo = Double.parseDouble(txtLengthInput.getText().toString());
        } else {
            lengthInputNo = 0;
        }
        hideSoftKeyboard();
        switch (v.getId()) {
            case R.id.btnCm:
                lengthInputUnit.setText(R.string.btn_cm);
                checkOp();
                break;
            case R.id.btnM:
                lengthInputUnit.setText(R.string.btn_m);
                checkOp();
                break;
            case R.id.btnKm:
                lengthInputUnit.setText(R.string.btn_km);
                checkOp();
                break;
            case R.id.btnMm:
                lengthInputUnit.setText(R.string.btn_mm);
                checkOp();
                break;
            case R.id.btnCmOp:
                convertToCm();
                break;
            case R.id.btnMmOp:
                convertToMm();
                break;
            case R.id.btnKmOp:
                convertToKm();
                break;
            case R.id.btnMOp:
                convertToM();
                break;
            case R.id.btnMicrometer:
                lengthInputUnit.setText(R.string.btn_μm);
                checkOp();
                break;
            case R.id.btnNanometer:
                lengthInputUnit.setText(R.string.btn_nm);
                checkOp();
                break;
            case R.id.btnFoot:
                lengthInputUnit.setText(R.string.btn_ft);
                checkOp();
                break;
            case R.id.btnInch:
                lengthInputUnit.setText(R.string.btn_inch);
                checkOp();
                break;
            case R.id.btnMicrometerOp:
                convertToMicro();
                break;
            case R.id.btnNanometerOp:
                convertToNano();
                break;
            case R.id.btnFootOp:
                convertToFoot();
                break;
            case R.id.btnInchOp:
                convertToInch();
                break;
        }
    }

    void checkOp() {
        if (LengthOutput.getText().toString().endsWith("mm")) {
            convertToMm();
        } else if (LengthOutput.getText().toString().endsWith(" m")) {
            convertToM();
        } else if (LengthOutput.getText().toString().endsWith("cm")) {
            convertToCm();
        } else if (LengthOutput.getText().toString().endsWith("km")) {
            convertToKm();
        } else if (LengthOutput.getText().toString().endsWith("μm")) {
            convertToMicro();
        } else if (LengthOutput.getText().toString().endsWith("nm")) {
            convertToNano();
        } else if (LengthOutput.getText().toString().endsWith("ft")) {
            convertToFoot();
        } else if (LengthOutput.getText().toString().endsWith("in")) {
            convertToInch();
        }
    }


    private void convertToInch() {
        if (lengthInputUnit.getText().toString().equalsIgnoreCase("cm")) {
            lengthInputNo = lengthInputNo * 0.3937007874;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " in"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("mm")) {
            lengthInputNo = lengthInputNo * 0.0393700787;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " in"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("km")) {
            lengthInputNo = lengthInputNo * 39370.07874;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " in"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("μm")) {
            lengthInputNo = lengthInputNo * 0.0000393701;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " in"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("nm")) {
            lengthInputNo = lengthInputNo / 25400000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " in"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("ft")) {
            lengthInputNo = lengthInputNo * 12;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " in"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("m")) {
            lengthInputNo = lengthInputNo * 39.37007874;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " in"));
        } else {
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " in"));
        }
    }

    private void convertToFoot() {
        if (lengthInputUnit.getText().toString().equalsIgnoreCase("cm")) {
            lengthInputNo = lengthInputNo * 0.032808399;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " ft"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("mm")) {
            lengthInputNo = lengthInputNo * 0.0032808399;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", lengthInputNo + " ft"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("km")) {
            lengthInputNo = lengthInputNo * 3280.839895;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " ft"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("μm")) {
            lengthInputNo = lengthInputNo * 0.0000032808;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " ft"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("nm")) {
            lengthInputNo = lengthInputNo * 304800000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " ft"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("in")) {
            lengthInputNo = lengthInputNo * 0.0833333333;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " ft"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("m")) {
            lengthInputNo = lengthInputNo * 3.280839895;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " ft"));
        } else {
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " ft"));
        }
    }

    private void convertToNano() {
        if (lengthInputUnit.getText().toString().equalsIgnoreCase("cm")) {
            lengthInputNo = lengthInputNo * 10000000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " nm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("mm")) {
            lengthInputNo = lengthInputNo * 1000000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " nm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("km")) {
            lengthInputNo = lengthInputNo * 1000000000000L;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " nm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("μm")) {
            lengthInputNo = lengthInputNo * 1000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " nm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("ft")) {
            lengthInputNo = lengthInputNo * 304800000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " nm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("in")) {
            lengthInputNo = lengthInputNo * 25400000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " nm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("m")) {
            lengthInputNo = lengthInputNo * 1000000000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " nm"));
        } else {
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " ft"));
        }
    }

    private void convertToMicro() {
        if (lengthInputUnit.getText().toString().equalsIgnoreCase("cm")) {
            lengthInputNo = lengthInputNo * 10000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " μm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("mm")) {
            lengthInputNo = lengthInputNo * 1000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " μm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("km")) {
            lengthInputNo = lengthInputNo * 1000000000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " μm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("nm")) {
            lengthInputNo = lengthInputNo * 0.001;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " μm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("ft")) {
            lengthInputNo = lengthInputNo * 304800;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " μm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("in")) {
            lengthInputNo = lengthInputNo * 25400;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " μm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("m")) {
            lengthInputNo = lengthInputNo * 1000000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " μm"));
        } else {
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " μm"));
        }
    }

    private void convertToCm() {
        if (lengthInputUnit.getText().toString().equalsIgnoreCase("m")) {
            lengthInputNo = lengthInputNo * 100;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " cm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("mm")) {
            lengthInputNo = lengthInputNo / 10;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " cm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("km")) {
            lengthInputNo = lengthInputNo * 100000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " cm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("μm")) {
            lengthInputNo = lengthInputNo / 10000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " cm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("nm")) {
            lengthInputNo = lengthInputNo / 10000000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " cm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("ft")) {
            lengthInputNo = lengthInputNo * 30.48;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " cm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("in")) {
            lengthInputNo = lengthInputNo * 2.54;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " cm"));
        } else {
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " cm"));
        }
    }

    private void convertToM() {
        if (lengthInputUnit.getText().toString().equalsIgnoreCase("cm")) {
            lengthInputNo = lengthInputNo / 100;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " m"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("mm")) {
            lengthInputNo = lengthInputNo / 1000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " m"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("km")) {
            lengthInputNo = lengthInputNo * 1000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " m"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("μm")) {
            lengthInputNo = lengthInputNo / 1000000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " m"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("nm")) {
            lengthInputNo = lengthInputNo / 1000000000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " m"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("ft")) {
            lengthInputNo = lengthInputNo / 3.280839895;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " m"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("in")) {
            lengthInputNo = lengthInputNo / 39.37007874;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " m"));
        } else {
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " m"));
        }
    }

    private void convertToMm() {
        if (lengthInputUnit.getText().toString().equalsIgnoreCase("cm")) {
            lengthInputNo = lengthInputNo * 10;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " mm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("m")) {
            lengthInputNo = lengthInputNo * 1000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " mm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("km")) {
            lengthInputNo = lengthInputNo * 1000000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " mm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("μm")) {
            lengthInputNo = lengthInputNo / 1000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " mm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("nm")) {
            lengthInputNo = lengthInputNo / 1000000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " mm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("ft")) {
            lengthInputNo = lengthInputNo * 304.8;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " mm"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("in")) {
            lengthInputNo = lengthInputNo * 25.4;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " mm"));
        } else {
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " mm"));
        }
    }

    private void convertToKm() {
        if (lengthInputUnit.getText().toString().equalsIgnoreCase("cm")) {
            lengthInputNo = lengthInputNo / 100000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " km"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("m")) {
            lengthInputNo = lengthInputNo / 1000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " km"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("mm")) {
            lengthInputNo = lengthInputNo / 1000000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " km"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("μm")) {
            lengthInputNo = lengthInputNo / 1000000000;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " km"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("nm")) {
            lengthInputNo = lengthInputNo / 1000000000000L;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " km"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("ft")) {
            lengthInputNo = lengthInputNo / 3280.839895;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " km"));
        } else if (lengthInputUnit.getText().toString().equalsIgnoreCase("in")) {
            lengthInputNo = lengthInputNo / 39370.07874;
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " km"));
        } else {
            decimalFormat(lengthInputNo);
            LengthOutput.setText(String.format("%s", df.format(lengthInputNo) + " km"));
        }
    }
}











