package com.apptreak.convertx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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


public class Temperature extends Fragment implements View.OnClickListener {
    private Button btndeg, btnfar, btnkel, btndegOp, btnfarOp, btnkelOp;
    TextView textTempUnit, textTempOut;
    EditText textTempInput;
    RelativeLayout TempLayout;
    java.text.DecimalFormat df = new java.text.DecimalFormat("#.#####");
    double tempinputNo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TempLayout = (RelativeLayout) inflater.inflate(R.layout.temp_layout, container, false);

        btndeg = (Button) TempLayout.findViewById(R.id.btndeg);
        btnfar = (Button) TempLayout.findViewById(R.id.btnfar);
        btnkel = (Button) TempLayout.findViewById(R.id.btnkel);
        btndegOp = (Button) TempLayout.findViewById(R.id.btndegOp);
        btnfarOp = (Button) TempLayout.findViewById(R.id.btnfarOp);
        btnkelOp = (Button) TempLayout.findViewById(R.id.btnkelOp);

        textTempInput = (EditText) TempLayout.findViewById(R.id.tempInput);
        textTempUnit = (TextView) TempLayout.findViewById(R.id.tempUnit);
        textTempOut = (TextView) TempLayout.findViewById(R.id.tempOut);

        btndeg.setOnClickListener(this);
        btnfar.setOnClickListener(this);
        btnkel.setOnClickListener(this);
        btndegOp.setOnClickListener(this);
        btnfarOp.setOnClickListener(this);
        btnkelOp.setOnClickListener(this);

        return TempLayout;
    }

    @Override
    public void onClick(View v) {
        df.setRoundingMode(RoundingMode.CEILING);
        if (textTempInput.getText().toString().length() != 0)
            tempinputNo = Double.parseDouble(textTempInput.getText().toString());
        else
            tempinputNo = 0;
        hideSoftKeyboard();

        switch (v.getId()) {
            case R.id.btndeg:
                textTempUnit.setText(R.string.button_deg);
                outputCheck();
                break;
            case R.id.btnfar:
                textTempUnit.setText(R.string.button_far);
                outputCheck();
                break;
            case R.id.btnkel:
                textTempUnit.setText(R.string.button_kel);
                outputCheck();
                break;

            case R.id.btndegOp:
                toDeg();
                break;
            case R.id.btnfarOp:
                toFar();
                break;
            case R.id.btnkelOp:
                toKel();
                break;

        }
    }


    void outputCheck() {
        if (textTempOut.getText().toString().endsWith("°C")) {
            toDeg();
        } else if (textTempOut.getText().toString().endsWith("°F")) {
            toFar();
        } else if (textTempOut.getText().toString().endsWith("°K")) {
            toKel();
        }

    }


    private void toDeg() {
        if (textTempUnit.getText().toString().equalsIgnoreCase("°F")) {
            textTempOut.setText(String.format("%s", df.format(((tempinputNo - 32) * 5) / 9) + " °C"));
        } else if (textTempUnit.getText().toString().equalsIgnoreCase("°K")) {
            textTempOut.setText(String.format("%s", df.format(tempinputNo - 273.15) + " °C"));
        } else  {
            textTempOut.setText(String.format("%s", df.format(tempinputNo) + " °C"));
        }
    }

    private void toFar() {
        if (textTempUnit.getText().toString().equalsIgnoreCase("°C")) {
            textTempOut.setText(String.format("%s", df.format(((tempinputNo * 9) / 5) + 32) + " °F"));
        } else if (textTempUnit.getText().toString().equalsIgnoreCase("°K")) {
            textTempOut.setText(String.format("%s", df.format(((tempinputNo * 9) / 5) - 459.67) + " °F"));
        } else textTempOut.setText(String.format("%s", df.format(tempinputNo) + " °F"));
    }

    private void toKel() {
        if (textTempUnit.getText().toString().equalsIgnoreCase("°F")) {
            textTempOut.setText(String.format("%s", df.format(((tempinputNo + 459.67) * 5) / 9) + " °K"));
        } else if (textTempUnit.getText().toString().equalsIgnoreCase("°C")) {
            textTempOut.setText(String.format("%s", df.format(tempinputNo + 273.15) + " °K"));
        } else textTempOut.setText(String.format("%s", df.format(tempinputNo) + " °K"));
    }

    void hideSoftKeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
